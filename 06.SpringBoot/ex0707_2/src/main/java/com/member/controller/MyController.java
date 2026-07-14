package com.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.model.Member;
import com.member.service.MyService;

@RestController
public class MyController {
	
	private final MyService myService;

	MyController(MyService myService) {
		this.myService = myService;
	}
	
	@GetMapping("/member")
	public List<Member> getMember() {
		List<Member> list = myService.selectMember();
		return list;
	}

}
