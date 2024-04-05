package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.Student;

import jakarta.persistence.JoinColumn;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
