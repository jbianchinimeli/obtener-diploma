package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
@AllArgsConstructor
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String subject;

    @NotNull(message = "La nota no puede estar vacia")
    @Min(value = 0, message = "La minima nota es 0")
    @Max(value = 10, message = "La maxima nota es 10")
    private Integer note;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

}
