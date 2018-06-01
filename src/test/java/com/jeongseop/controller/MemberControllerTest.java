package com.jeongseop.controller;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MemberControllerTest extends BaseTestController {
    @Before
    public void testSetup() {
        testIssuedAccessToken();
    }

    @Test
    public void testGetMemberInfo() {
        String userInfoEndpoint = "/member";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getAccessToken());
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpoint, HttpMethod.GET, entity, Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(
                Optional.ofNullable(response.getBody().get("uid"))
                        .map(Object::toString)
                        .orElse(""))
                .isEqualTo(BaseTestController.testUid);
    }
}
