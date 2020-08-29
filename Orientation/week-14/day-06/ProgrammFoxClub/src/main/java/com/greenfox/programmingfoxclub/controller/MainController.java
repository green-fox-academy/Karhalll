package com.greenfox.programmingfoxclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @GetMapping("/")
  public String index(@RequestParam String name) {
    return "information";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String loginAs(@RequestParam String name) {
    return "redirect:/?name=" + name;
  }
}
