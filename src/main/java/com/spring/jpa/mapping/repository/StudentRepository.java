package com.spring.jpa.mapping.repository;

import com.spring.jpa.mapping.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //Student findAllById(Long userId);

    Optional<Student> findById(Long userId);
}
