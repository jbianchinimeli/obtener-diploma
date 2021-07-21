package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.exception.ApplicationException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CertificateServiceImpl implements CertificateService {
    public CertificateDTO analyzeNotes(StudentDTO notes) {
        if (Objects.isNull(notes)) {
            throw new ApplicationException("The student is null");
        }
        CertificateDTO response = new CertificateDTO(notes);
        response.setAverage(calculateAverage(notes));
        response.setMessage(writeDiploma(notes));
        return response;
    }

    private Double calculateAverage(StudentDTO notes) {
        if(Objects.isNull(notes.getSubjects())){
            throw new ApplicationException("Student subject list is null");
        }
        int sum = notes.getSubjects().stream().mapToInt(SubjectDTO::getNote).sum();
        return sum / (double) notes.getSubjects().size();
    }

    private String writeDiploma(StudentDTO notes) {
        Double localAverage = calculateAverage(notes);
        String studentName = notes.getName();
        String message = studentName + " usted ha conseguido el promedio de " + localAverage;
        if (localAverage > 9) message = withHonors(localAverage, studentName);
        return message;
    }

    private String withHonors(Double localAverage, String localStudent) {
        return "¡Felicitaciones " + localStudent + "! Usted tiene el gran promedio de " + localAverage;
    }
}
