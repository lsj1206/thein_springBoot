package com.lsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsj.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
