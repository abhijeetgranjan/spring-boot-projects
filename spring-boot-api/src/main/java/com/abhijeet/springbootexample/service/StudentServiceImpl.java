package com.abhijeet.springbootexample.service;

import com.abhijeet.springbootexample.entity.Student;
import com.abhijeet.springbootexample.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Student> getAllStudents() {
        LOGGER.info(" finding all students ");
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByRoll(int roll) {
        LOGGER.info(" fetching student with roll ");
        return studentRepository.findByRoll(roll);
    }

    @Override
    public Student saveStudent(Student student) {
        LOGGER.info("save student begins");
        Student save = studentRepository.save(student);
        return save;
    }

    @Override
    public Student updateStudent(Student student, int roll) {
        LOGGER.info("update student begins");
        Student byRoll = studentRepository.findByRoll(roll);
        if (byRoll != null) {
            LOGGER.info(" the student with roll " + roll + " exists");
            if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
                byRoll.setName(student.getName());
            }
            if (Objects.nonNull(student.getRegistrationNumber()) && student.getRegistrationNumber() != 0) {
                byRoll.setRegistrationNumber(student.getRegistrationNumber());
            }
            if (Objects.nonNull(student.getRoll()) && student.getRegistrationNumber() != 0) {
                byRoll.setRoll(student.getRoll());
            }
            return studentRepository.save(byRoll);
        } else {
            LOGGER.info(" the student with roll " + roll + " doesn't exist");
        }

        return null;
    }

    @Override
    public int deleteStudent(int roll) {
        LOGGER.info(" deleting the record of student begins");
        return studentRepository.deleteByRoll(roll);

    }
}
