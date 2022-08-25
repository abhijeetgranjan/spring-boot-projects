package com.abhijeet.springbootexample.controller;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<String> saveStudent(@Valid @RequestBody Student student, BindingResult errors) {

        try {
            if (errors.hasErrors()) {
                throw new RuntimeException(errors.toString()) ;
            }

            LOGGER.info(" saveStudent method invoked ");
            Student savedStudent = studentService.saveStudent(student);
            if (savedStudent != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Data is saved");
            }

        }catch (Exception e){
            LOGGER.info(" exception caught in saveStudent");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Please check the request ");
    }

    @GetMapping("/student/roll/{roll}")
    public ResponseEntity<Object> getStudentByRoll(@PathVariable("roll") int roll) {
        LOGGER.info(" getStudentByRoll method invoked for roll "+roll);
        Student studentByRoll = studentService.getStudentByRoll(roll);
        if(studentByRoll!=null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentByRoll);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with roll "+ roll+" doesn't exist");

    }

    @PutMapping("/students/roll/{roll}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable("roll") int roll) {
        LOGGER.info(" updateStudent method invoked  for student with roll" + roll);
        Student updatedStudent = studentService.updateStudent(student, roll);
        if(updatedStudent!=null){
            return ResponseEntity.status(HttpStatus.OK).body("updated the student details");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error in updating the student details");
    }

    @DeleteMapping("/students/roll/{roll}")
    @Transactional
    public ResponseEntity<String> deleteStudent(@PathVariable("roll") int roll) {
        LOGGER.info(" deleteStudent method invoked  with roll" + roll);
        int i = studentService.deleteStudent(roll);
        if(i>0){
            return ResponseEntity.status(HttpStatus.OK).body("deleted  the student record");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the roll");
    }


}
