package com.abhijeet.exceltodb.controller;


import com.abhijeet.exceltodb.entity.Student;
import com.abhijeet.exceltodb.helper.ExcelConversion;
import com.abhijeet.exceltodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExcelConversion excelConversion;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadDataToDatabase(@RequestParam("file") MultipartFile file) {
        try {
            boolean checkFormat = excelConversion.checkFormat(file);
            if (checkFormat) {
                String message = studentService.uploadDataToDatabase(file);
                if (message != null) {
                    return ResponseEntity.status(HttpStatus.OK).body("Data is saved");
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the data ");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the format of the file ");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(allStudents);
    }
}
