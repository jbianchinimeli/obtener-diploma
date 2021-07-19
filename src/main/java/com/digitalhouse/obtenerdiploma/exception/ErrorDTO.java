package com.digitalhouse.obtenerdiploma.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
public class ErrorDTO {

    private HttpStatus status;
    private String errorMessage;
    private Map<String, String> messages;

    public ErrorDTO(HttpStatus status, String errorMessage, Map<String, String> messages) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.messages = messages;
    }

}
