package com.jeongseop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/main")
	public String index(HttpServletRequest request) {
		return "hello!";
	}
}
