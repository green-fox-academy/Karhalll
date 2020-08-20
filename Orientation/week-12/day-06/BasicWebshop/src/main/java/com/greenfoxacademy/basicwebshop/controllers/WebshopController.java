package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.repositories.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public abstract class WebshopController {

  protected Stock items = new Stock();
  protected static String currentCurrency = "Kč";

  @ModelAttribute
  public void priceInCurrency(Model model) {
    model.addAttribute("currency", currentCurrency);
  }
}
