package com.lsj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsj.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

	// 이름 조회
    List<MemberEntity> findByName(String name);

    // 나이 조회
    List<MemberEntity> findByAge(Integer age);

    // 나이 이상
    List<MemberEntity> findByAgeGreaterThanEqual(Integer age);

    // 이름 포함
    List<MemberEntity> findByNameContaining(String keyword);

}
