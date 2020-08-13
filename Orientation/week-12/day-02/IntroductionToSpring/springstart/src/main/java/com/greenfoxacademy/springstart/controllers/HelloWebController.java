package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

  @RequestMapping("/web/greeting")
  public String greeting(Model model, @RequestParam String name, @RequestParam String size,
                         @RequestParam String r, @RequestParam String g, @RequestParam String b) {
    Greeting greeting = new Greeting();

    String style = "font-size:" + size + "px;" +
        "color:rgb(" + r + "," + g + "," + b + ");";

    model.addAttribute("greeting", greeting.getGreeting());
    model.addAttribute("style", style);
    model.addAttribute("name", name);
    model.addAttribute("greetCount", greeting.getGreetCount());
    return "greeting";
  }
}
