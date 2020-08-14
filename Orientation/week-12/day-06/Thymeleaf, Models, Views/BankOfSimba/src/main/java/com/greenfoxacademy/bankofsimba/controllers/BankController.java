package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

  @GetMapping("/show")
  public String showAccount(Model model) {
    BankAccount account = new BankAccount("Simba", 2000f, "lion");
    model.addAttribute("account", account);
    return "account";
  }

  @GetMapping("/HTMLception")
  public String htmlCeption(Model model) {
    model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "htmlCeption";
  }
}
