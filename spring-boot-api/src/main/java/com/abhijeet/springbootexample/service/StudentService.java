package com.abhijeet.springbootexample.service;

import com.abhijeet.springbootexample.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentByRoll(int roll);

    void saveStudent(Student student);

    void updateStudent(Student student, int roll);
}
