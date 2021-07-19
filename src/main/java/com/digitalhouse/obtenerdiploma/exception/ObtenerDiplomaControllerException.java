package com.digitalhouse.obtenerdiploma.exception;

import lombok.Getter;

@Getter
public class ObtenerDiplomaControllerException extends RuntimeException {

    private ErrorDTO errorDTO;

    public ObtenerDiplomaControllerException(ErrorDTO errorDTO) {
        super(errorDTO.getErrorMessage());
        this.errorDTO = errorDTO;
    }
}
