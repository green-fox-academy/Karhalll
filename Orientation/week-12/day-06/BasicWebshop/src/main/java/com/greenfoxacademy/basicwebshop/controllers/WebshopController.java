package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.structures.Search;
import com.greenfoxacademy.basicwebshop.structures.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebshopController {

  private Stock items = new Stock();

  @GetMapping("/webshop")
  public String mainPage(Model model) {
    model.addAttribute("items", items.getItems());
    return "index";
  }

  @GetMapping("/only-available")
  public String onlyAvailable(Model model) {
    model.addAttribute("items", items.getAvailable());
    return "index";
  }

  @GetMapping("/cheapest-first")
  public String cheapestFirst(Model model) {
    model.addAttribute("items", items.getSortedByPrice());
    return "index";
  }

  @GetMapping("/contains-nike")
  public String containsNike(Model model) {
    model.addAttribute("items", items.getByContains("nike"));
    return "index";
  }

  @GetMapping("/average-stock")
  public String averageStock(Model model) {
    model.addAttribute("averageStock", items.averageStock());
    return "index";
  }

  @GetMapping("/most-expensive")
  public String mostExpensive(Model model) {
    model.addAttribute("items", items.getMostExpensive());
    return "index";
  }

  @PostMapping("/search")
  public String search(@ModelAttribute Search text, Model model) {
    model.addAttribute("items", items.getByContains(text.getText()));
    return "index";
  }
}
