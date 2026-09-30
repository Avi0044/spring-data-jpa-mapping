package com.spring.jpa.mapping.domain;

import com.spring.jpa.mapping.dto.HospitalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "hospitals")
    List<Doctor> doctors;

    public Hospital(HospitalDTO hospitalDTO, Address address) {

        this.name=hospitalDTO.getName();
        this.address = address;
    }
}
