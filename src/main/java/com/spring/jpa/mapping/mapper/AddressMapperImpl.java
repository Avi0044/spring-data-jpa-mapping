package com.spring.jpa.mapping.mapper;

import com.spring.jpa.mapping.domain.Address;
import com.spring.jpa.mapping.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper{


    @Override
    public AddressDTO toDTO(Address address) {
        if(address == null){
            return null;
        }
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setHome(address.getHome());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setZipCode(address.getZipCode());
        return addressDTO;
    }

    @Override
    public Address toEntity(AddressDTO addressDTO) {
        if(addressDTO == null){
            return null;
        }
        Address address=new Address();
        address.setId(addressDTO.getId());
        address.setHome(addressDTO.getHome());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setZipCode(address.getZipCode());
        return address;
    }
}
