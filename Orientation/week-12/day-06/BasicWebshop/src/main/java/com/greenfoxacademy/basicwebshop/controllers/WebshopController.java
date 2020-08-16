package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.Search;
import com.greenfoxacademy.basicwebshop.models.Type;
import com.greenfoxacademy.basicwebshop.repositories.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebshopController {

  private Stock items = new Stock();
  private String currentCurrency = "Kč";

  @ModelAttribute
  public void priceInCurrency(Model model) {
    model.addAttribute("currency", currentCurrency);
  }

  @GetMapping({"/", "/webshop"})
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

  @GetMapping("/more-filters")
  public String moreFilters(Model model) {
    model.addAttribute("items", items.getItems());
    return "moreFilters";
  }

  @GetMapping("/filter-by-type/{type}")
  public String filterByType(@PathVariable Type type, Model model) {
    model.addAttribute("items", items.getByType(type));
    return "moreFilters";
  }

  @GetMapping("/price-in-euro")
  public String priceInEur(Model model) {
    model.addAttribute("currency", currentCurrency = "€");
    model.addAttribute("items", items.getItems());
    return "moreFilters";
  }

  @GetMapping("/price-in-original")
  public String priceInOriginal(Model model) {
    model.addAttribute("currency", currentCurrency = "Kč");
    model.addAttribute("items", items.getItems());
    return "moreFilters";
  }
}
