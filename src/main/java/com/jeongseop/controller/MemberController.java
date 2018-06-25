package com.jeongseop.controller;

import com.jeongseop.domain.Member;
import com.jeongseop.domain.MemberRole;
import com.jeongseop.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @PreAuthorize("#oauth2.hasScope('member.info.public')")
    @GetMapping
    public ResponseEntity<Member> selectMember(
            @AuthenticationPrincipal OAuth2Authentication authentication) throws Exception {
        String username = authentication.getName();
        Set<String> scopes = authentication.getOAuth2Request().getScope();
        Member chkMember = memberRepository.findByUid(username);
        Member member = authenticationMember(chkMember, scopes);
        return new ResponseEntity(member, HttpStatus.OK);
    }

    @PostMapping("/{newid}")
    public String signup(
            @RequestBody Member member,
            @PathVariable(required=true) String newid,
            HttpServletResponse response) throws Exception {
        Member old = memberRepository.findByUid(newid);
        if (old != null && newid.equals(old.getUid())) {
            throw new Exception("duplicate uid [" + newid + "]");
        }

        MemberRole role = new MemberRole("USER");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRoles(Arrays.asList(role));
        memberRepository.save(member);
        return "";
    }

    private Member authenticationMember(Member member, Set<String> scopes) {
        Member result = new Member();
        result.setName(member.getName());
        result.setUid(member.getUid());
        if(scopes.contains("member.info.email"))
            result.setEmail(member.getEmail());

        return result;
    }
}
