package com.abhijeet.spring.data.jpa.service;

import com.abhijeet.spring.data.jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByEmailAddress(String email);

    Employee findByEmployeeMail(String email);

    List<Employee> findEmployeeMailByEmployeeName(String name);
}
