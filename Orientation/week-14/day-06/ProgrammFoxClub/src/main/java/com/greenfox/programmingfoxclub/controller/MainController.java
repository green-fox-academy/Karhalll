package com.greenfox.programmingfoxclub.controller;

import com.greenfox.programmingfoxclub.service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  FoxService foxService;

  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String index(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getFox(name));
    return "information";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String loginAs(@RequestParam String name) {;
    return "redirect:/?name=" + name;
  }

  @GetMapping("/nutritionStore")
  public String nutritionStore(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getFox(name));
    return "nutrition-store";
  }

  @GetMapping("/trickCenter")
  public String trickCenter(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getFox(name));
    return "trick-center";
  }
}
