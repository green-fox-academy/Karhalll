package com.greenfoxacademy.dependencies.UsefulUtilities.controllers;

import com.greenfoxacademy.dependencies.UsefulUtilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilityController {

  @Autowired
  private UtilityService utilityService;

  @GetMapping("/useful")
  public String homepage() {
    return "useful";
  }

  @GetMapping("/useful/colored")
  public String colored(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }

  @GetMapping("/useful/email")
  public String email(@RequestParam String email, Model model) {
    model.addAttribute("valid", utilityService.validateEmail(email));
    return "validator";
  }
}
