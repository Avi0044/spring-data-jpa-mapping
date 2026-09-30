package com.spring.jpa.mapping.dto;

import com.spring.jpa.mapping.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private int age;

    private String college;

    private AddressDTO address;

    private CourseDTO course;

    public UserDTO(Student student) {
        this.id = student.getId();
        this.name =student.getName();
        this.age = student.getAge();
        this.college = student.getCollege();
        this.address = new AddressDTO(student.getAddres());
        this.course = new CourseDTO(student.getCourse());

    }
}
