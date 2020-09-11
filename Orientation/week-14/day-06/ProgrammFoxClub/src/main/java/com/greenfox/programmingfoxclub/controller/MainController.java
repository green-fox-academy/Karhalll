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
    model.addAttribute("fox", foxService.getByName(name));
    return checkFoxAndLoadPage("information", name);
  }

  @GetMapping("/login")
  public String login(@RequestParam(required = false) String error, Model model) {
    model.addAttribute("error", error);
    return "login";
  }

  @PostMapping("/login")
  public String loginAs(@RequestParam String name, @RequestParam String submit) {
    if (name.equals("")) {
      return "redirect:/login?error=You haven't provided any name!";
    }
    if (submit.equals("Create New")) {
      if (foxService.isFox(name)) {
        return "redirect:/login?error=This fox already exist!";
      }
      foxService.creatByName(name);
      return "redirect:/?name=" + name;
    }
    if (!foxService.isFox(name)) {
      return "redirect:/login?error="
          + "You have provided a name that has not been used before, add it as a new one!";
    }
    return "redirect:/?name=" + name;
  }

  @GetMapping("/nutritionStore")
  public String nutritionStore(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getByName(name));
    return checkFoxAndLoadPage("nutrition-store", name);
  }

  @GetMapping("/trickCenter")
  public String trickCenter(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getByName(name));
    model.addAttribute("tricksToLearn", foxService.tricksToLearn(name));
    return checkFoxAndLoadPage("trick-center", name);
  }

  @GetMapping("/actionHistory")
  public String actionHistory(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getByName(name));
    return checkFoxAndLoadPage("action-history", name);
  }

  private String checkFoxAndLoadPage(String pageToLoad, String foxName) {
    if (foxService.isFox(foxName)) {
      return pageToLoad;
    } else {
      return "redirect:/login";
    }
  }
}
