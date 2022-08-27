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
        //bean.saveOneToOneMapping();

        bean.saveOneToManyMapping();

    }

}
