package com.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.member.model.Member;

@Mapper
public interface MyMapper {
	List<Member> selectMember();
}
