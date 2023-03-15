package com.anil.spring.boot.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.spring.boot.api.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
