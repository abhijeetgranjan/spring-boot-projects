package com.abhijeet.springbootexample.controller;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/student/roll/{roll}")
    public Student getStudentByRoll(@PathVariable("roll") int roll) {
        return studentService.getStudentByRoll(roll);
    }

    @PutMapping("/students/{roll}")
    public void updateStudent(@RequestBody Student student ,@PathVariable("roll") int roll){
        studentService.updateStudent(student,roll);
    }

    @DeleteMapping("/students/{roll}")
    @Transactional
    public void deleteStudent(@PathVariable("roll") int roll){
        studentService.deleteStudent(roll);
    }



}
