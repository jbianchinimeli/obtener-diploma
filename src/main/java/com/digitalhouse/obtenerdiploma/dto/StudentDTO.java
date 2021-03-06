package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@AllArgsConstructor
public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayuscula")
    @Size(min = 1, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String name;

    @NotEmpty(message = "La lista no puede ser vacia")
    @Valid
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}
