package com.lsj.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lsj.student.dto.Student;
import com.lsj.student.mapper.StudentMapper;
import com.lsj.student.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentMapper mapper;
	
	public StudentService(StudentMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<Student> findAll() {
		return mapper.findAll();
	}
	
	
//	private final StudentRepository repo;
//	
//	public StudentService(StudentRepository repository) {
//		this.repo = repository;
//	}
//	
//	public List<Student> findAll(){
//		return repo.findAll();
//	}
}
