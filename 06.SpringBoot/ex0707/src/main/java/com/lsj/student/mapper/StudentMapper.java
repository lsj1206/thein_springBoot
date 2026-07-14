package com.lsj.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lsj.student.dto.Student;

@Mapper
public interface StudentMapper {
	List<Student> findAll();
}
