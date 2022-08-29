package com.abhijeet.student.service.service;

import com.abhijeet.student.service.VO.Course;
import com.abhijeet.student.service.VO.ResponseTemplateVO;
import com.abhijeet.student.service.entity.Student;
import com.abhijeet.student.service.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseTemplateVO getStudentWithCourse(int id) {
        log.info("inside getStudentWithCourse");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<Student> byId = studentRepository.findById(id);
        log.info("student details fetched ");
        Course forObject = restTemplate.getForObject("http://COURSE-SERVICE/api/course/1", Course.class);
        log.info("course  details fetched ");
        vo.setStudent(byId.get());
        vo.setCourse(forObject);
        return vo;

    }
}
