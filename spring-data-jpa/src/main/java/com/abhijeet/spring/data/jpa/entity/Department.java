package com.abhijeet.spring.data.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Department")
public class Department {

    @Id
    @SequenceGenerator(name = "department_sequence", sequenceName = "department_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_sequence")
    @Column(name = "departmentId")
    private int departmentId;

    @Column(name = "departmentName")
    private String departmentName;

   /* @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private List<Employee> employeeList;*/

}

