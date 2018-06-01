package com.jeongseop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BaseTestController {
    public static final String testUid = "jsmaster";
    @Autowired
    protected TestRestTemplate restTemplate;
    protected String access_token;

    protected void testIssuedAccessToken() {
        String tokenEndpoint = "/oauth/token";
        MultiValueMap<String, String> requestbody = new LinkedMultiValueMap<>();
        requestbody.add("grant_type", "password");
        requestbody.add("client_id", "cli");
        requestbody.add("client_secret", "secret");
        requestbody.add("username", BaseTestController.testUid);
        requestbody.add("password", "1234");
        requestbody.add("override", "true");
        requestbody.add("scope", "member.info.public");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity(requestbody, headers);

        ResponseEntity<Map> responseObject = restTemplate.postForEntity(tokenEndpoint, entity, Map.class);
        assertThat(responseObject.getStatusCode()).isEqualTo(HttpStatus.OK);

        Map responseBody = responseObject.getBody();
        assertThat(responseBody).isNotNull();

        access_token = Optional.ofNullable(responseBody.get("access_token"))
                .map(Object::toString)
                .orElse("");
        assertThat(access_token).isNotEqualTo("");
    }

    protected String getAccessToken() {
        return access_token;
    }
}
