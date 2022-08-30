package com.abhijeet.spring.data.jpa.repository;

import com.abhijeet.spring.data.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //normal jpa query using findBy
    Employee findByEmployeeMail(String email);

    //native query
    @Query(value = "select * from Employee e where e.employee_mail = ?1", nativeQuery = true)
    Employee getEmployeeByEmailAddress(String email);

    //native named params query
    @Query(value = "select * from Employee e where e.employee_name = :name", nativeQuery = true)
    List<Employee> findEmployeeMailByEmployeeName(@Param("name") String name);
}
