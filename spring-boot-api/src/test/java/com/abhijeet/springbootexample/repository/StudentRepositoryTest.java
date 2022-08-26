package com.abhijeet.springbootexample.repository;

import com.abhijeet.springbootexample.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student1 = Student.builder().name("Abhijeet").roll(1).registrationNumber(121).id(1).build();
        Mockito.when(studentRepository.findByRoll(1)).thenReturn(student1);
    }


    @Test
    void findByRoll() {
        int roll =1;
        Student byRoll = studentRepository.findByRoll(roll);
        assertEquals(roll,byRoll.getRoll());

    }




}