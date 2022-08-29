package com.abhijeet.student.service.service;

import com.abhijeet.student.service.VO.ResponseTemplateVO;
import com.abhijeet.student.service.entity.Student;

public interface StudentService {
    Student saveStudent(Student student);

    ResponseTemplateVO getStudentWithCourse(int id);
}
