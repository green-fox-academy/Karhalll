package com.greenfox.programmingfoxclub.controller;

import com.greenfox.programmingfoxclub.model.Drink;
import com.greenfox.programmingfoxclub.model.Food;
import com.greenfox.programmingfoxclub.model.Trick;
import com.greenfox.programmingfoxclub.service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

  FoxService foxService;

  public FoxController(FoxService foxService) {
    this.foxService = foxService;
  }

  @PostMapping("/nutritionStore")
  public String setNutrition(@RequestParam String name, @RequestParam Food food, @RequestParam Drink drink) {
    foxService.setNutrients(name, food, drink);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/trickCenter")
  public String learnTrick(@RequestParam String name, @RequestParam Trick trick) {
    foxService.learnTrick(name, trick);
    return "redirect:/?name=" + name;
  }
}
