package com.lsj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsj.entity.MemberEntity;
import com.lsj.repository.MemberRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "회원관리", description = "회원 CRUD API")
@RestController
@RequestMapping("/member")
public class MemberController {

	private final MemberRepository repository;

	public MemberController(MemberRepository repository) {
		this.repository = repository;
	}

	/**
     * 회원 등록
     * URL : POST /member/save
     * save() 메서드를 이용하여 데이터를 저장한다.
     */
	@Operation(summary = "회원 저장")
    @PostMapping("/save")
    public String save() {

    	MemberEntity member = new MemberEntity();
        member.setName("홍길동");
        member.setAge(20);

        repository.save(member);

        return "저장 완료";
    }

    /**
     * 회원 전체 조회
     * URL : GET /member/list
     * findAll() 메서드를 이용하여 모든 회원을 조회한다.
     */
	@Operation(summary = "회원 목록")
    @GetMapping("/list")
    public List<MemberEntity> list() {

        return repository.findAll();
    }

    /**
     * 회원 상세 조회
     * URL : GET /member/{id}
     * findById() 메서드를 이용하여 회원번호(id)로 조회한다.
     */
    @GetMapping("/{id}")
    public MemberEntity detail(@PathVariable Integer id) {

        return repository.findById(id).orElse(null);
    }

    /**
     * 회원 수정
     * URL : PUT /member/update
     * save() 메서드는 기본키(id)가 존재하면 수정(Update)을 수행한다.
     */
    @PutMapping("/update")
    public String update(@RequestBody MemberEntity member) {

        repository.save(member);

        return "수정 완료";
    }

    /**
     * 회원 삭제
     * URL : DELETE /member/{id}
     * deleteById() 메서드를 이용하여 회원을 삭제한다.
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        repository.deleteById(id);

        return "삭제 완료";
    }
	
	@GetMapping("/name/{name}")
	public List<MemberEntity> search(@PathVariable String name) {

		return repository.findByName(name);
	}

}
