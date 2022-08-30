package com.abhijeet.spring.data.jpa.service;

import com.abhijeet.spring.data.jpa.entity.Employee;
import com.abhijeet.spring.data.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByEmailAddress(String email) {
        return employeeRepository.getEmployeeByEmailAddress(email);
    }

    public  Employee findByEmployeeMail(String email){
        return employeeRepository.findByEmployeeMail(email);
    }

    @Override
    public List<Employee> findEmployeeMailByEmployeeName(String name) {
        return employeeRepository.findEmployeeMailByEmployeeName(name);
    }
}
