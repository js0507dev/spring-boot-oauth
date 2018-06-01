package com.jeongseop.repository;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i=0; i<20; i++) {
			Member member = new Member("userid"+i, encoder.encode("pwd"+i), "name"+i, "email"+i+"@test.com");
			MemberRole role = new MemberRole();
			if(i < 15) {
				role.setRolename("USER");
			}else {
				role.setRolename("ADMIN");
			}
			member.setRoles(Arrays.asList(role));
			memberRepository.save(member);
		}
	}
}
