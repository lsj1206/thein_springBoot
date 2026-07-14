package com.lsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsj.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
