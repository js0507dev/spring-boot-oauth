package com.jeongseop.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeongseop.domain.Member;
import com.jeongseop.domain.MemberRole;
import com.jeongseop.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/members")
@Slf4j
public class MemberController {
	@Autowired
	MemberRepository memberRepository;
	
	@PostMapping("/{newid}")
	public String join(@RequestBody Member member, @PathVariable String newid, HttpServletResponse response) throws Exception {
		log.info("uid["+newid+"]");
		log.info("member["+member+"]");
		
		Member old = memberRepository.findByUid(newid);
		if(old != null && newid.equals(old.getUid())) {
			throw new Exception("duplicate uid ["+newid+"]");
		}
		
		MemberRole role = new MemberRole("BASIC");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.setRoles(Arrays.asList(role));
		memberRepository.save(member);
		return "{\"state\":\"success\"}";
	}
	
	@GetMapping("")
	public String list() {
		return "test....";
	}
}
