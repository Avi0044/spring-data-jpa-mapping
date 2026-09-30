package com.spring.jpa.mapping.mapper;

import com.spring.jpa.mapping.domain.Organization;
import com.spring.jpa.mapping.dto.OrganizationDTO;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMappierImpl implements OrganizationMapper{
    @Override
    public OrganizationDTO toDTO(Organization organization) {
        if (organization == null){
            return null;
        }
        OrganizationDTO organizationDTO= new OrganizationDTO();
        organizationDTO.setId(organization.getId());
        organizationDTO.setName(organization.getName());
        organizationDTO.setDateOfJoining(organization.getDateOfJoining());
        return organizationDTO;

    }

    @Override
    public Organization toEntity(OrganizationDTO organizationDTO) {
        if (organizationDTO== null){
            return null;
        }
        Organization organization =new Organization();
        organization.setId(organizationDTO.getId());
        organization.setName(organizationDTO.getName());
        organization.setDateOfJoining(organizationDTO.getDateOfJoining());
        return organization;
    }
}
