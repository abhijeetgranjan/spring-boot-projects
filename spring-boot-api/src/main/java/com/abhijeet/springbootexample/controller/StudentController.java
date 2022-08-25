package com.abhijeet.springbootexample.controller;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        LOGGER.info(" getAllStudents method invoked ");
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public void saveStudent(@RequestBody Student student) {
        LOGGER.info(" saveStudent method invoked ");
        studentService.saveStudent(student);
    }

    @GetMapping("/student/roll/{roll}")
    public Student getStudentByRoll(@PathVariable("roll") int roll) {
        LOGGER.info(" getStudentByRoll method invoked for roll "+roll);
        return studentService.getStudentByRoll(roll);
    }

    @PutMapping("/students/roll/{roll}")
    public void updateStudent(@RequestBody Student student, @PathVariable("roll") int roll) {
        LOGGER.info(" updateStudent method invoked  for student with roll" + roll);
        studentService.updateStudent(student, roll);
    }

    @DeleteMapping("/students/roll/{roll}")
    @Transactional
    public void deleteStudent(@PathVariable("roll") int roll) {
        LOGGER.info(" deleteStudent method invoked  with roll" + roll);
        studentService.deleteStudent(roll);
    }


}
