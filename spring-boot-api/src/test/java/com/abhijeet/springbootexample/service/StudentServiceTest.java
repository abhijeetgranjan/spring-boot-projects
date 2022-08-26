package com.abhijeet.springbootexample.service;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentServiceImpl studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student1 = Student.builder().id(1).name("Abhijeet").roll(1205330).registrationNumber(121).build();
        Student student2 = Student.builder().id(2).name("Ranjan").roll(1205331).registrationNumber(122).build();
        List<Student> students = Arrays.asList(student1, student2);
        Mockito.when(studentRepository.findAll()).thenReturn(students);

    }

    @Test
    @DisplayName("Test Case to Check getAllStudents")
    void getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        assertEquals(2, allStudents.size());
    }


}