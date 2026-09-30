package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDTOResponse {

    private Long id;

    private String name;

    private AddressDTO address;

    public HospitalDTOResponse(Hospital hospital){
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.address = new AddressDTO(hospital.getAddress());
    }

}
