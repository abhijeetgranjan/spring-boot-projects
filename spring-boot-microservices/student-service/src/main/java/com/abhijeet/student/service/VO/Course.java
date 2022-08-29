package com.abhijeet.student.service.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {


    private int courseId;
    private String courseName;
    private int credit;
}
