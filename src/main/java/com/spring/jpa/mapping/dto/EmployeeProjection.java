package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Address;
import com.spring.jpa.mapping.domain.Organization;
import jakarta.persistence.*;

public interface EmployeeProjection {

     Long getId();

     String getName();

     int getAge();

     AddressProjection getAddress();

     OrganizationProjection getOrganization();




}
