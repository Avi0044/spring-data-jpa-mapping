package com.spring.jpa.mapping.mapper;

import com.spring.jpa.mapping.domain.Employee;
import com.spring.jpa.mapping.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}
