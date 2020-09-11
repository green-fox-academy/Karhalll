package com.greenfox.programmingfoxclub.controller;

import com.greenfox.programmingfoxclub.service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/{username}")
public class MainController {

  FoxService foxService;

  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String index(@PathVariable String username, @RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getByName(name));
    model.addAttribute("actions", foxService.getFirst5SortedActionHistory(name));
    return checkFoxAndLoadPage("information", name, username);
  }

  @GetMapping("/login")
  public String login(@PathVariable String username, @RequestParam(required = false) String error, Model model) {
    model.addAttribute(username);
    model.addAttribute("error", error);
    return "login";
  }

  @PostMapping("/login")
  public String loginAs(@PathVariable String username, @RequestParam String name, @RequestParam String submit) {
    if (name.equals("")) {
      return "redirect:/" + username + "/login?error=You haven't provided any name!";
    }
    if (submit.equals("Create New")) {
      if (foxService.isFox(name, username)) {
        return "redirect:/" + username + "/login?error=This fox already exist!";
      }
      foxService.creatByName(name, username);
      return "redirect:/" + username + "/?name=" + name;
    }
    if (!foxService.isFox(name, username)) {
      return "redirect:/" + username + "/login?error="
          + "You have provided a name that has not been used before, add it as a new one!";
    }
    return "redirect:/" + username + "/?name=" + name;
  }

  @GetMapping("/nutritionStore")
  public String nutritionStore(@PathVariable String username, @RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getByName(name));
    model.addAttribute("foods", foxService.getAllAvailableFoods());
    model.addAttribute("drinks", foxService.getAllAvailableDrinks());
    return checkFoxAndLoadPage("nutrition-store", name, username);
  }

  @GetMapping("/trickCenter")
  public String trickCenter(@PathVariable String username, @RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getByName(name));
    model.addAttribute("tricksToLearn", foxService.tricksToLearn(name, username));
    return checkFoxAndLoadPage("trick-center", name, username);
  }

  @GetMapping("/actionHistory")
  public String actionHistory(@PathVariable String username, @RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.getByName(name));
    model.addAttribute("historyActions", foxService.getSortedActionHistory(name));
    System.out.println(foxService.getSortedActionHistory(name));
    return checkFoxAndLoadPage("action-history", name, username);
  }

  private String checkFoxAndLoadPage(String pageToLoad, String foxName, String username) {
    if (foxService.isFox(foxName, username)) {
      return pageToLoad;
    } else {
      return "redirect:/" + username + "/login";
    }
  }
}
