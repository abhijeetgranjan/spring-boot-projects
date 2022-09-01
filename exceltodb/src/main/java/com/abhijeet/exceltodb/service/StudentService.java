package com.abhijeet.exceltodb.service;

import com.abhijeet.exceltodb.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    String uploadDataToDatabase(MultipartFile file);

    List<Student> getAllStudents();
}
