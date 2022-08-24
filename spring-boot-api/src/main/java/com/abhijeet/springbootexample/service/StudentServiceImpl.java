package com.abhijeet.springbootexample.service;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByRoll(int roll) {
        return studentRepository.findByRoll(roll);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
