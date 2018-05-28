package com.jeongseop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testTokenEndPointInvalid() {
        String url = "/oauth/token";
        String parameters = "?response_type=token&client_id=&redirect_uri=/&scope=read";
        ResponseEntity<Map> response = restTemplate.getForEntity(url + parameters, Map.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void testTokenEndPointValid() {
        String url = "/oauth/token";
        String parameters = "?response_type=token&client_id=cli&redirect_uri=/api/main&scope=read";
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Map> response = restTemplate.getForEntity(url + parameters, Map.class);
        //assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }
}
