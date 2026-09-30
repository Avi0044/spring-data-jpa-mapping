package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Hospital;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private Long id;

    private String name;

    private int age;

    private String specialization;

    private List<Long> hospitalIds;
}
