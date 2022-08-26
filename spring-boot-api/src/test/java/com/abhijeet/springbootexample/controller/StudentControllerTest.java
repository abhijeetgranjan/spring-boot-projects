package com.abhijeet.springbootexample.controller;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class StudentControllerTest {

    @Autowired
    private StudentController studentController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;
    private List<Student> studentList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        student = Student.builder().roll(1).name("Abhi").registrationNumber(123).build();
        studentList.add(student);
    }

    @Test
    void getStudentByRoll() throws Exception {
        Mockito.when(studentService.getStudentByRoll(1)).
                thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/roll/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).
                andExpect(jsonPath("$.name").value(student.getName()));
    }


}