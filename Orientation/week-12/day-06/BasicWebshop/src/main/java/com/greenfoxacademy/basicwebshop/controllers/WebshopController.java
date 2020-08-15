package com.greenfoxacademy.basicwebshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebshopController {

  @GetMapping("/webshop")
  public String mainPage(Model model) {
    return "default";
  }
}
