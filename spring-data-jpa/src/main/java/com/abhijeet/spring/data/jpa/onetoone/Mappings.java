package com.abhijeet.spring.data.jpa.onetoone;

import com.abhijeet.spring.data.jpa.entity.Account;
import com.abhijeet.spring.data.jpa.entity.Department;
import com.abhijeet.spring.data.jpa.entity.Employee;
import com.abhijeet.spring.data.jpa.repository.DepartmentRepository;
import com.abhijeet.spring.data.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Mappings {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public void saveOneToOneMapping() {
        Account account123 = Account.builder().accountNumber(6).bankName("AXIS").build();
        Employee qwerty = Employee.builder().employeeName("port").employeeMail("ab@a.com").account(account123).build();

        employeeRepository.save(qwerty);
    }

    public void saveOneToManyMapping(){

        Employee a = Employee.builder().employeeName("a").employeeMail("ab@a.com").build();
        Employee b = Employee.builder().employeeName("b").employeeMail("ab@a.com").build();
        Employee c = Employee.builder().employeeName("c").employeeMail("ab@a.com").build();
        Employee d = Employee.builder().employeeName("d").employeeMail("ab@a.com").build();

        List<Employee> atciList = Arrays.asList(a,b);
        List<Employee> hrList = Arrays.asList(c,d);

        Department atci = Department.builder().departmentName("ATCI").employeeList(atciList).build();
        Department hr = Department.builder().departmentName("hr").employeeList(hrList).build();

        departmentRepository.save(atci);
        departmentRepository.save(hr);


    }


}
