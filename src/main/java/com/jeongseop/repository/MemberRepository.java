package com.jeongseop.repository;

import com.jeongseop.domain.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
	public Member findByUid(String uid);
}
