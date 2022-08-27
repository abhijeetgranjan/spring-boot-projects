package com.abhijeet.spring.data.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence")
    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "employeeMail")
    private String employeeMail;

    @OneToOne()
    @JoinColumn( name = "accountId", referencedColumnName = "accountId")
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;

}
