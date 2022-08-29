package com.abhijeet.course.service.controller;

import com.abhijeet.course.service.entity.Course;
import com.abhijeet.course.service.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@Slf4j
public class CourseController {

@Autowired
private CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        log.info("inside saveAllCourses method  ");
        Course course1 = courseService.saveCourse(course);
        return  ResponseEntity.status(HttpStatus.OK).body(course1);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable("id") int id){
        log.info("inside getCourseById method  for id" +id);
        Optional course = courseService.getCourseById(id);
        if(course.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(course);
        }
        return  ResponseEntity.status(HttpStatus.OK).body("No course found with the id ");
    }
}
