package com.digitalhouse.obtenerdiploma.unit.service;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.exception.ApplicationException;
import com.digitalhouse.obtenerdiploma.repository.StudentRepository;
import com.digitalhouse.obtenerdiploma.service.CertificateService;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CertificateServiceTest {
    private static SubjectDTO subject1;
    private static SubjectDTO subject2;
    private static SubjectDTO subject3;
    private static SubjectDTO subject4;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    CertificateServiceImpl certificateService;

    @BeforeAll
    static void setup(){
         subject1 = new SubjectDTO("Matematica", 8);
         subject2 = new SubjectDTO("Fisica", 9);
         subject3 = new SubjectDTO("Programacion", 10);
         subject4 = new SubjectDTO("Historia", null);

    }

    @BeforeEach
    void init(){
//        Mockito.when(this.studentRepository)
    }

    @Test
    @DisplayName("Analyze notes for a null student")
    void analyzeNotesNullParamTest(){
        assertThrows(ApplicationException.class,()->this.certificateService.analyzeNotes(null));
    }

    @Test
    @DisplayName("null list of subjects")
    void analyzeNotesNullSubjectListTest(){
        StudentDTO studentDTO = new StudentDTO("Juan", null);

        assertThrows(Exception.class, ()->this.certificateService.analyzeNotes(studentDTO));

    }

    @Test
    @DisplayName("If subject list is empty the average is Double.NaN")
    void analyzeNotesEmptySubjectListTest(){
        StudentDTO studentDTO = new StudentDTO("Juan", new ArrayList<>());

        assert(Double.isNaN(this.certificateService.analyzeNotes(studentDTO).getAverage()));
    }

    @Test
    @DisplayName("If subject list is empty the average is Double.NaN")
    void analyzeNotesSubjectListContainsSubjectWithNullNoteTest(){
        StudentDTO studentDTO = new StudentDTO("Juan", Arrays.asList(subject4));

        assertThrows(NullPointerException.class, ()->this.certificateService.analyzeNotes(studentDTO));
    }




}
