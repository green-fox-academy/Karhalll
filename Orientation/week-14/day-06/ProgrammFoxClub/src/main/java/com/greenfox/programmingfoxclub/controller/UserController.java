package com.greenfox.programmingfoxclub.controller;

import com.greenfox.programmingfoxclub.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping({"/", "/login"})
  public String userLogin(@RequestParam(required = false) String error, Model model) {
    model.addAttribute("error", error);
    return "user-login";
  }
  @PostMapping("/login")
  public String logAs(@RequestParam String username, @RequestParam String password) {
    if (username.isEmpty()) {
      return "redirect:/login?error=You haven't provided any name!";
    } else if (!userService.isAlreadyUser(username)) {
      return "redirect:/login?error=This username doesn't exist";
    } else if (password.isEmpty()) {
      return "redirect:/login?error=Please provide some password!";
    } else if (userService.validLogIn(username, password)) {
      return "redirect:/" + username + "/login";
    } else {
      return "redirect:/login?error=Invalid password!";
    }
  }

  @GetMapping("/register")
  public String registration(@RequestParam(required = false) String error, Model model) {
    model.addAttribute("error", error);
    return "registration";
  }

  @PostMapping("/register")
  public String tryRegisterNewUser(@RequestParam String username, @RequestParam String password,
                                   @RequestParam String passwordCheck) {
    if (username.isEmpty()) {
      return "redirect:/register?error=You haven't provided any name!";
    } else if (userService.isAlreadyUser(username)) {
      return "redirect:/register?error=This username is already taken!";
    } else if (password.isEmpty()) {
      return "redirect:/register?error=Please provide some password!";
    } else if (!password.equals(passwordCheck)) {
      return "redirect:/register?error=Passwords don't match!";
    }

    userService.registerUser(username, password);
    return "redirect:/" + username + "/login";
  }
}
