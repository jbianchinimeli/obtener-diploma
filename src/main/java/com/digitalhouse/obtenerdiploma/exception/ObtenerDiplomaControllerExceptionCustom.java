package com.digitalhouse.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

public class ObtenerDiplomaControllerExceptionCustom extends RuntimeException {

    private final BindingResult bindingResult;

    public ObtenerDiplomaControllerExceptionCustom(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public ErrorDTO getError() {
        return this.processField(this.bindingResult.getFieldErrors());
    }

    private ErrorDTO processField(List<FieldError> fieldErrors) {
        HashMap<String, String> fields = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            fields.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ErrorDTO(HttpStatus.BAD_REQUEST, "Validations Error", fields);
    }


}
