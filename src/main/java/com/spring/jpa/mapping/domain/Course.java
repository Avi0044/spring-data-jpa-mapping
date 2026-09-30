package com.spring.jpa.mapping.domain;

import com.spring.jpa.mapping.dto.CourseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String duration;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;

    public Course(CourseDTO courseDTO) {
        this.courseName=courseDTO.getCourseName();
        this.duration = courseDTO.getDuration();
    }
}
