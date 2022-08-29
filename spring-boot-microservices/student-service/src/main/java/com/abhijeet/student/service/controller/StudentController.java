package com.abhijeet.student.service.controller;

import com.abhijeet.student.service.VO.ResponseTemplateVO;
import com.abhijeet.student.service.entity.Student;
import com.abhijeet.student.service.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        log.info(" saveStudent method invoked ");
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(savedStudent);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<ResponseTemplateVO> getStudentWithCourse(@PathVariable("id") int id){
        log.info("getStudentWithCourse invoked");
        ResponseTemplateVO studentWithCourse = studentService.getStudentWithCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentWithCourse);
    }


}
