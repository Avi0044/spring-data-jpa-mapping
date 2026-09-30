package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {
    private Long id;

    private String name;

    private Long addressId;
}
