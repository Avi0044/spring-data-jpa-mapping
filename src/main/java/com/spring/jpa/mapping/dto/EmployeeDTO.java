package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Address;
import com.spring.jpa.mapping.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeDTO {
    private Long id;

    private String name;

    private int age;

    private AddressDTO address;

    private OrganizationDTO organization;


    public EmployeeDTO(Long id, String name, int age, AddressDTO address, OrganizationDTO organization) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
       this.organization = organization;
    }
}
