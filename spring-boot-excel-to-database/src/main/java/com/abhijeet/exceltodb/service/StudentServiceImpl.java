package com.abhijeet.exceltodb.service;

import com.abhijeet.exceltodb.entity.Student;
import com.abhijeet.exceltodb.helper.ExcelConversion;
import com.abhijeet.exceltodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class StudentServiceImpl  implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExcelConversion excelConversion;


    @Override
    public String uploadDataToDatabase(MultipartFile file) {
        String message = null;
        try{
            List<Student> students = excelConversion.convertDataToJavaObject(file);
            List<Student> students1 = studentRepository.saveAll(students);
            message= "success";
        }catch (Exception e){
            throw new RuntimeException();
        }

        return message;


    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
