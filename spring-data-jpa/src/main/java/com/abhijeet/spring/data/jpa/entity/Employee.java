package com.abhijeet.spring.data.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "accountId", referencedColumnName = "accountId")
    private Account account;

    /*@ManyToOne()
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;*/

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="employee_speciality_mapping",
    joinColumns =@JoinColumn(name = "employeeId", referencedColumnName = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "specialityId" ,referencedColumnName = "specialityId")

    )
    private List<Speciality> specialities;

    public void addSpeciality(Speciality speciality){
        if(specialities==null){
            specialities = new ArrayList<>();
        }
        specialities.add(speciality);
    }


}
