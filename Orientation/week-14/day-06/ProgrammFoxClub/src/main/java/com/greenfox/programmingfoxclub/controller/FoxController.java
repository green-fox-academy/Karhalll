package com.greenfox.programmingfoxclub.controller;

import com.greenfox.programmingfoxclub.model.Drink;
import com.greenfox.programmingfoxclub.model.Food;
import com.greenfox.programmingfoxclub.model.Fox;
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
    Fox fox = foxService.getFox(name);
    fox.setFood(food);
    fox.setDrink(drink);
    return "redirect:/?name=" + name;
  }
}
