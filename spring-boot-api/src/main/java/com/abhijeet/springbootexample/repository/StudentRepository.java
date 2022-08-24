package com.abhijeet.springbootexample.repository;

import com.abhijeet.springbootexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Student findByRoll(int roll);


}
