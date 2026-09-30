package com.spring.jpa.mapping.domain;

import com.spring.jpa.mapping.dto.OrganizationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String dateOfJoining;

    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "organization")
    private List<Employee> employees;*/


    public Organization(OrganizationDTO organization) {
        this.name = organization.getName();
        this.dateOfJoining = organization.getDateOfJoining();
    }
}
