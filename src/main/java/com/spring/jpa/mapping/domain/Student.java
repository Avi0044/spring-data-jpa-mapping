package com.spring.jpa.mapping.domain;

import com.spring.jpa.mapping.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String college;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address addres;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    //@JoinColumn(name = "course_id")
    private Course course;

    public Student(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.age = userDTO.getAge();
        this.college = userDTO.getCollege();
        this.addres = new Address(userDTO.getAddress());
        if(userDTO.getCourse().getId()==null){
            this.course=new Course(userDTO.getCourse());
        }
    }
}
