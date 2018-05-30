package com.jeongseop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BaseTestController {
    @Autowired
    protected TestRestTemplate restTemplate;
    protected String access_token;

    protected void testIssuedAccessToken() {
        String tokenEndpoint = "/oauth/authorize";
        MultiValueMap<String, String> requestbody = new LinkedMultiValueMap<>();
        requestbody.add("grant_type", "password");
        requestbody.add("client_id", "cli");
        requestbody.add("username", "jsmaster");
        requestbody.add("password", "1234");
        requestbody.add("override", "true");
        requestbody.add("scope", "member.info.public");

        HttpHeaders headers = new HttpHeaders();
        Base64.Encoder encoder = Base64.getEncoder();
        headers.set("Authorization", "Basic " + encoder.encode("cli:secret".getBytes()));
        HttpEntity entity = new HttpEntity(requestbody, headers);

        Map responseObject = restTemplate.postForObject(tokenEndpoint, entity, Map.class);
        assertThat(responseObject).isNotNull();
        log.info("=========================");
        responseObject.keySet()
                .forEach(k -> log.info(k + "[" + responseObject.get(k).toString() + "]"));
        log.info("=========================");
        access_token = Optional.ofNullable(responseObject.get("access_token"))
                .map(Object::toString)
                .orElse("");
        assertThat(access_token).isEqualTo("");
    }

    protected String getAccessToken() {
        return access_token;
    }
}
