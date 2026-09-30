package com.spring.jpa.mapping.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.jpa.mapping.domain.Course;
import com.spring.jpa.mapping.domain.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private  Long id;

    private String courseName;

    private String duration;

    public CourseDTO(Course course) {
        this.id=course.getId();
        this.courseName = course.getCourseName();
        this.duration = course.getDuration();
    }

    //private List<UserDTO> students;
}
