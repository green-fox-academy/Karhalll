package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

  List<BankAccount> accounts = new ArrayList<>();

  private BankController() {
    accounts.add(new BankAccount("Simba", 2000f, "lion"));
    accounts.add(new BankAccount("Nala", 3000f, "lion"));
    accounts.add(new BankAccount("Mufasa", 15000f, "lion"));
    accounts.add(new BankAccount("Timon", 10f, "meerkat"));
    accounts.add(new BankAccount("Pumbaa", 0f, "warthog"));
  }

  @GetMapping("/show")
  public String showAccount(Model model) {
    BankAccount account = new BankAccount("Simba", 2000f, "lion");
    model.addAttribute("account", account);
    return "account";
  }

  @GetMapping("/showAll")
  public String showAllAccounts(Model model) {
    model.addAttribute("accounts", accounts);
    return "accounts";
  }

  @GetMapping("/HTMLception")
  public String htmlCeption(Model model) {
    model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "htmlCeption";
  }
}
