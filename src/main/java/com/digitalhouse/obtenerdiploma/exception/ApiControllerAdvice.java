package com.digitalhouse.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

    @ExceptionHandler(ObtenerDiplomaControllerExceptionCustom.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handlerException(ObtenerDiplomaControllerExceptionCustom exception) {
        ErrorDTO error = exception.getError();
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handlerException(ApplicationException exception) {
        Map<String,String> messages = new HashMap<>();
        messages.put("Error description", exception.getMessage());
        ErrorDTO error = new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del sistema", null);

        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handlerException(HttpMessageNotReadableException exception) {
        Map<String, String> messages = new HashMap<>();
        messages.put("Error", exception.getMessage());
        ErrorDTO error = new ErrorDTO(HttpStatus.BAD_REQUEST, "Parsing error", messages);

        return new ResponseEntity<>(error, error.getStatus());
    }


}
