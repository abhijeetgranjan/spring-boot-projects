package com.abhijeet.springbootexample.service;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public void updateStudent(Student student, int roll) {

        Student byRoll = studentRepository.findByRoll(roll);
        if(byRoll!=null){
            if(Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())){
                byRoll.setName(student.getName());
            }
            if(Objects.nonNull(student.getRegistrationNumber()) && student.getRegistrationNumber() != 0){
                byRoll.setRegistrationNumber(student.getRegistrationNumber());
            }
            if(Objects.nonNull(student.getRoll()) && student.getRegistrationNumber() != 0){
                byRoll.setRoll(student.getRoll());
            }
            studentRepository.save(byRoll);
        }

    }

    @Override
    public void deleteStudent(int roll) {
        studentRepository.deleteByRoll(roll);
    }
}
