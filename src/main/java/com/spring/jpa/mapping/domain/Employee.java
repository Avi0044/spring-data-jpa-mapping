package com.spring.jpa.mapping.domain;

import com.spring.jpa.mapping.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.age = employeeDTO.getAge();
        this.address = new Address(employeeDTO.getAddress());
        this.organization = new Organization(employeeDTO.getOrganization());
    }
}
