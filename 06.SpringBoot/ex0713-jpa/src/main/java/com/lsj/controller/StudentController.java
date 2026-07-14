package com.lsj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lsj.entity.Department;
import com.lsj.entity.Student;
import com.lsj.repository.DepartmentRepository;
import com.lsj.repository.StudentRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "학생관리", description = "학생 CRUD API")
@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentRepository studentRepository;
	private final DepartmentRepository departmentRepository;

	public StudentController(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
		this.studentRepository = studentRepository;
		this.departmentRepository = departmentRepository;
	}

	// 학생 등록
	@PostMapping("/save")
	public String save(@RequestParam String name, @RequestParam Integer deptId) {

		Department department = departmentRepository.findById(deptId).orElse(null);

		if (department == null) {
			return "학과가 존재하지 않습니다.";
		}

		Student student = new Student();
		student.setName(name);
		student.setDepartment(department);

		studentRepository.save(student);

		return "학생 등록 완료";
	}

	// 전체 조회
	@GetMapping("/list")
	public List<Student> list() {
		return studentRepository.findAll();
	}

	// 상세 조회
	@GetMapping("/{id}")
	public Student detail(@PathVariable Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	// 삭제
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		studentRepository.deleteById(id);
		return "삭제 완료";
	}

}
