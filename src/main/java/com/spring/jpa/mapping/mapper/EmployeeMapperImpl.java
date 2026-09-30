package com.spring.jpa.mapping.mapper;

import com.spring.jpa.mapping.domain.Employee;
import com.spring.jpa.mapping.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper{
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Override
    public EmployeeDTO toDTO(Employee employee) {
        if (employee ==null){
            return null;
        }
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employeeDTO.getAge());
        employeeDTO.setAddress(addressMapper.toDTO(employee.getAddress()));
        employeeDTO.setOrganization(organizationMapper.toDTO(employee.getOrganization()));
        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        if(employeeDTO == null){
            return null;
        }
        Employee employee= new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setAddress(addressMapper.toEntity(employeeDTO.getAddress()));
        employee.setOrganization(organizationMapper.toEntity(employeeDTO.getOrganization()));
        return employee;
    }
}
