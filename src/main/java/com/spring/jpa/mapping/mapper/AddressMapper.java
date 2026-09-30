package com.spring.jpa.mapping.mapper;

import com.spring.jpa.mapping.domain.Address;
import com.spring.jpa.mapping.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDTO(Address address);
    Address toEntity(AddressDTO addressDTO);
}
