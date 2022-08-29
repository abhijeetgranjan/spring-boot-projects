package com.abhijeet.course.service.service;

import com.abhijeet.course.service.entity.Course;

import java.util.Optional;

public interface CourseService {
    Course saveCourse(Course course);

    Optional getCourseById(int id);
}
