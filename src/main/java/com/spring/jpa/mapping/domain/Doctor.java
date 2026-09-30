package com.spring.jpa.mapping.domain;

import com.spring.jpa.mapping.dto.DoctorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String specialization;

    @ManyToMany
    @JoinTable(name = "doctor_hospital",joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "hospital_id"))
    private List<Hospital> hospitals;

    public Doctor(DoctorDTO doctorDTO) {
        this.name = doctorDTO.getName();
        this.age = doctorDTO.getAge();
        this.specialization=doctorDTO.getSpecialization();


    }
}
