package com.abhijeet.spring.data.jpa.onetoone;

import com.abhijeet.spring.data.jpa.entity.Account;
import com.abhijeet.spring.data.jpa.entity.Department;
import com.abhijeet.spring.data.jpa.entity.Employee;
import com.abhijeet.spring.data.jpa.entity.Speciality;
import com.abhijeet.spring.data.jpa.repository.AccountRepository;
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

    @Autowired
    private AccountRepository accountRepository;



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

    /*public void saveManyToOneMapping(){
        Department operations = Department.builder().departmentName("operations").build();
        Department pmo = Department.builder().departmentName("pmo").build();

        Account axis = Account.builder().accountNumber(6).bankName("AXIS").build();


        Employee amit = Employee.builder().employeeName("amit").employeeMail("ab@a.com").department(operations).account(axis).build();
        Employee bhavesh = Employee.builder().employeeName("bhavesh").employeeMail("ab@a.com").department(operations).account(axis).build();
        Employee chandu = Employee.builder().employeeName("chandu").employeeMail("ab@a.com").department(pmo).account(axis).build();
        Employee dullu = Employee.builder().employeeName("dullu").employeeMail("ab@a.com").department(pmo).account(axis).build();

        departmentRepository.save(pmo);
        departmentRepository.save(operations);

        accountRepository.save(axis);

        employeeRepository.save(amit);
        employeeRepository.save(bhavesh);
        employeeRepository.save(chandu);
        employeeRepository.save(dullu);
    }*/

    public void addManyToManyMappings(){

        Speciality java = Speciality.builder().stream("JAVA").build();
        Speciality spring = Speciality.builder().stream("Spring").build();

        Account canara = Account.builder().accountNumber(6).bankName("CANARA").build();


        Employee arpit = Employee.builder().employeeName("ARPIT").employeeMail("ab@a.com").account(canara).build();
        arpit.addSpeciality(java);
        arpit.addSpeciality(spring);

        employeeRepository.save(arpit);



    }

}
