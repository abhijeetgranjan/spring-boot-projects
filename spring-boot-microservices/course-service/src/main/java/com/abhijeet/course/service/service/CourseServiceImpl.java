package com.abhijeet.course.service.service;

import com.abhijeet.course.service.entity.Course;
import com.abhijeet.course.service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional getCourseById(int id) {
        return courseRepository.findById(id);
    }
}
