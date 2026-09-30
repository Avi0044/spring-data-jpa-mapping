package com.spring.jpa.mapping.mapper;

import com.spring.jpa.mapping.domain.Organization;
import com.spring.jpa.mapping.dto.OrganizationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    OrganizationDTO toDTO(Organization organization);
    Organization toEntity(OrganizationDTO organizationDTO);
}
