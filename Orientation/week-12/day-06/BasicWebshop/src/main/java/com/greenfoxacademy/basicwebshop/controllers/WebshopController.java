package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.structures.ShopItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebshopController {

  private List<ShopItem> items;

  public WebshopController() {
    items = new ArrayList<>();
    items.add(new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000f, 5));
    items.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000f, 2));
    items.add(new ShopItem("Coca cola", "0.5l standard coke", 25f, 0));
    items.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119f, 100));
    items.add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 300f, 1));
  }

  @GetMapping("/webshop")
  public String mainPage(Model model) {
    model.addAttribute("items", items);
    return "index";
  }
}
