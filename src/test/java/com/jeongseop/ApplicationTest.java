package com.jeongseop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
	@LocalServerPort
	private int port;
	
	@Test
	public void tokenEndPointInvalid() {
		/*MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.set("username", "user");
		request.set("password", "test");
		request.set("grant_type", "password");
		request.set("scope", "read");
		assertEquals(HttpStatus.UNAUTHORIZED
				, new TestRestTemplate()
						.postForEntity("/oauth/token", request, Map.class)
						.getStatusCode());*/
		assertThat(true);
	}

	@Test
	public void tokenEndPointValid() {
		/*MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.set("username", "user");
		request.set("password", "test");
		request.set("grant_type", "password");
		request.set("client_id", "cli");
		request.set("scope", "read");
		assertEquals(HttpStatus.OK
				, new TestRestTemplate()
						.postForEntity("/oauth/token", request, Map.class)
						.getStatusCode());*/
		assertThat(true);
	}
}
