package com.abhijeet.spring.data.jpa;

import com.abhijeet.spring.data.jpa.onetoone.Mappings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringDataJpaApplication.class, args);
        Mappings bean = run.getBean(Mappings.class);

        // calling and saving the mappings

        // bean.saveOneToOneMapping();
        // bean.saveOneToManyMapping();
        // bean.saveManyToOneMapping();
        // bean.addManyToManyMappings();

       /*

        Queries call
        EmployeeServiceImpl bean1 = run.getBean(EmployeeServiceImpl.class);
        Employee employeeByEmailAddress = bean1.getEmployeeByEmailAddress("abhi@a.com");
        //System.out.println(employeeByEmailAddress);

        Employee findByEmployeeMail = bean1.findByEmployeeMail("abhi@a.com");
        //System.out.println(findByEmployeeMail);

        List<Employee> lkj = bean1.findEmployeeMailByEmployeeName("lkj");
        System.out.println(lkj.size());*/


    }

}
