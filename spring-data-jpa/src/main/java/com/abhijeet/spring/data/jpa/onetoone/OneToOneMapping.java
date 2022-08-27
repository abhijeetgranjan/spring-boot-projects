package com.abhijeet.spring.data.jpa.onetoone;

import com.abhijeet.spring.data.jpa.entity.Account;
import com.abhijeet.spring.data.jpa.entity.Employee;
import com.abhijeet.spring.data.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OneToOneMapping {


    @Autowired
    private EmployeeRepository employeeRepository;


    public void saveOneToOneMapping() {
        Account account123 = Account.builder().accountNumber(1245).bankName("HDFC").build();
        Employee qwerty = Employee.builder().employeeName("qwerty").employeeMail("ab@a.com").account(account123).build();

        employeeRepository.save(qwerty);
    }
}
