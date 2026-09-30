package com.spring.jpa.mapping.domain;

import com.spring.jpa.mapping.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String home;

    private String city;

    private String state;

    private String zipCode;

    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "address")
    private Employee employee;*/

    public Address(AddressDTO addressDTO) {
        this.home=addressDTO.getHome();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zipCode = addressDTO.getZipCode();
    }
}
