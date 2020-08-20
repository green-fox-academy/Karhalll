package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoreFiltersController extends WebshopController {

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

  @PostMapping("/filter-by-price")
  public String filterByPrice(
      @ModelAttribute(name = "number") String number,
      @ModelAttribute(name = "method") String method,
      Model model) {

    if (!number.isEmpty()) {
      Double price = Double.parseDouble(number);
      System.out.println(price);

      switch (method) {
        case "Above":
          model.addAttribute("items", items.getAbove(price));
          break;
        case "Below":
          model.addAttribute("items", items.getBelow(price));
          break;
        case "Exactly":
          model.addAttribute("items", items.getExactly(price));
          break;
      }
    } else {
      model.addAttribute("items", items.getItems());
    }

    return "moreFilters";
  }
}
