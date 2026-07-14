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
import com.lsj.repository.DepartmentRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "학과관리", description = "학과 CRUD API")
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    // 학과 등록
    @PostMapping("/save")
    public String save(@RequestParam String deptName) {

        Department department = new Department();
        department.setDeptName(deptName);

        repository.save(department);

        return "학과 등록 완료";
    }

    // 전체 조회
    @GetMapping("/list")
    public List<Department> list() {
        return repository.findAll();
    }

    // 상세 조회
    @GetMapping("/{id}")
    public Department detail(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        repository.deleteById(id);
        return "삭제 완료";
    }

}
