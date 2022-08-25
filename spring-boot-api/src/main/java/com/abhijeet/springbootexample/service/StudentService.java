package com.abhijeet.springbootexample.service;

import com.abhijeet.springbootexample.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentByRoll(int roll);

    Student  saveStudent(Student student);

    Student updateStudent(Student student, int roll);

    int deleteStudent(int roll);
}
