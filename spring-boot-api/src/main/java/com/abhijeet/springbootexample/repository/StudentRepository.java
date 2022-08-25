package com.abhijeet.springbootexample.repository;

import com.abhijeet.springbootexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByRoll(int roll);

    int deleteByRoll(int roll);


}
