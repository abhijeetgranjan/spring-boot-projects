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
@Table(name = "Speciality")
public class Speciality {

    @Id
    @SequenceGenerator(name = "speciality_sequence", sequenceName = "speciality_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "speciality_sequence")
    @Column(name = "specialityId")
    private int specialityId;

    @Column(name = "stream")
    private String stream;
}
