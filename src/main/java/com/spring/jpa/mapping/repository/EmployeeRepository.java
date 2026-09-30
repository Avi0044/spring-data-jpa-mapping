package com.spring.jpa.mapping.repository;

import com.spring.jpa.mapping.domain.Employee;
import com.spring.jpa.mapping.dto.EmployeeDTO;
import com.spring.jpa.mapping.dto.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //@Query(value = "Select e from Employee e where e.id = :empId")
    @Query(value = "SELECT new com.spring.jpa.mapping.dto.EmployeeDTO(e.id as id, e.name as name, e.age as age, new com.spring.jpa.mapping.dto.AddressDTO(e.address.id,e.address.home,e.address.city,e.address.state,e.address.zipCode),new com.spring.jpa.mapping.dto.OrganizationDTO(e.organization.id,e.organization.name,e.organization.dateOfJoining)) FROM Employee e WHERE e.id = :empId" )
    EmployeeDTO findByEmployId(Long empId);

    EmployeeProjection findProjectedById(Long id);

    Employee findAnythingById(Long empId);

}
