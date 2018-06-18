package com.jeongseop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/loginForm")
  public String login() {
    return "member/login";
  }
}
