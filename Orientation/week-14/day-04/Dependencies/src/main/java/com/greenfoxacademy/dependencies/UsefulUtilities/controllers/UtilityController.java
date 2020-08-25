package com.greenfoxacademy.dependencies.UsefulUtilities.controllers;

import com.greenfoxacademy.dependencies.UsefulUtilities.services.UtilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilityController {

  private final UtilityService utilityService;

  public UtilityController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful")
  public String homepage() {
    return "usefullUtilities/useful";
  }

  @GetMapping("/useful/colored")
  public String colored(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "usefullUtilities/colored";
  }

  @GetMapping("/useful/email")
  public String email(@RequestParam String email, Model model) {
    model.addAttribute("valid", utilityService.validateEmail(email));
    return "usefullUtilities/validator";
  }

  @GetMapping("/useful/encoder")
  public String encoding(@RequestParam String text, @RequestParam Integer number, Model model) {
    model.addAttribute("text", utilityService.caesar(text, number));
    return "usefullUtilities/caesar";
  }

  @GetMapping("/useful/decoder")
  public String decoding(@RequestParam String text, @RequestParam Integer number, Model model) {
    model.addAttribute("text", utilityService.caesar(text, -number));
    return "usefullUtilities/caesar";
  }
}
