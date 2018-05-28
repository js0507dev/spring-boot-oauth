package com.jeongseop.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
        requestbody.add("grant_type","password");
        requestbody.add("client_id","cli");
        requestbody.add("username","userid0");
        requestbody.add("password","pwd0");
        requestbody.add("override","true");
        requestbody.add("scope","member.info.public");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(requestbody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(tokenEndpoint, entity, Map.class);
        JSONObject json = new JSONObject(response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(json).isNotNull();
        log.info("=========================");
        json.keySet()
                .forEach(k -> log.info(k + "[" + json.getString(k) + "]"));
        log.info("=========================");
        access_token = Optional.ofNullable(json.getString("access_token"))
                .orElse("");
        assertThat(access_token).isEqualTo("");
    }

    protected String getAccessToken() {
        return access_token;
    }
}
