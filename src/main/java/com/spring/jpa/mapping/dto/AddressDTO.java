package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Address;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    private String home;

    private String city;

    private String state;

    private String zipCode;

    public AddressDTO(Address addres) {
     this.id = addres.getId();
     this.home = addres.getHome();
     this.city = addres.getCity();
     this.state = addres.getState();
     this.zipCode = addres.getZipCode();
    }

}
