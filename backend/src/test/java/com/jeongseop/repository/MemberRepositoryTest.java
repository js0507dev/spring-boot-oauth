package com.jeongseop.repository;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jeongseop.domain.Member;
import com.jeongseop.domain.MemberRole;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MemberRepositoryTest {
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void insertTest() {
		for(int i=0; i<100; i++) {
			Member member = new Member("userid"+i, "pwd"+i, "name"+i, "email"+i+"@test.com");
			MemberRole role = new MemberRole();
			if(i < 80) {
				role.setRolename("BASIC");
			} else if(i < 90) {
				role.setRolename("MANAGER");
			} else {
				role.setRolename("ADMIN");
			}
			member.setRoles(Arrays.asList(role));
			memberRepository.save(member);
		}
	}
	
	@Test
	public void testMember() {
		Optional<Member> result = Optional.ofNullable(memberRepository.findOne(85L));
		result.ifPresent(member -> log.info("member " + member));
	}
}
