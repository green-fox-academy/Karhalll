package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.structures.ShopItem;
import com.greenfoxacademy.basicwebshop.structures.Stock;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
