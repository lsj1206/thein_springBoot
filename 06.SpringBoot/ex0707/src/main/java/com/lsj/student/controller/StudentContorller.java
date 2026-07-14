package com.lsj.student.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsj.student.dto.Student;
import com.lsj.student.service.StudentService;

@ResponseBody
@Controller
public class StudentContorller {

	private final StudentService service;

	public StudentContorller(StudentService service) {
		this.service = service;
	}

	@GetMapping("/students")
	public List<Student> students() {
		
		// Generic;
		return service.findAll();
	}
}
