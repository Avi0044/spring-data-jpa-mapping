package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {

    private Long id;

    private String name;

    private String dateOfJoining;

    public OrganizationDTO(Organization organization) {

        this.id = organization.getId();
        this.name = organization.getName();
        this.dateOfJoining = organization.getDateOfJoining();
    }
}
