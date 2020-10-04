package com.greenfoxacademy.p2pchat.controller;

import com.greenfoxacademy.p2pchat.dto.LoginRequest;
import com.greenfoxacademy.p2pchat.dto.LoginResponse;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

  private final String rootUrl = "https://rascals-chat.herokuapp.com/API/USER";

  @GetMapping({"/", "/login"})
  public String showLoginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String logUser(LoginRequest loginRequest, RedirectAttributes attributes) {

    RestTemplate restTemplate = new RestTemplate();

    HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest);
    LoginResponse response = restTemplate.postForObject(rootUrl + "/login", request, LoginResponse.class);

    return "redirect:/messages/" + response.getApiKey();
  }
}
