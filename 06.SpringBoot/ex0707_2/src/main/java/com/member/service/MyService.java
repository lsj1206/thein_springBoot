package com.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.member.mapper.MyMapper;
import com.member.model.Member;

@Service
public class MyService {
	
	private final MyMapper myMapper;

	MyService(MyMapper myMapper) {
		this.myMapper = myMapper;
	}
	
	public List<Member> selectMember() {
		return myMapper.selectMember();
	}
}
