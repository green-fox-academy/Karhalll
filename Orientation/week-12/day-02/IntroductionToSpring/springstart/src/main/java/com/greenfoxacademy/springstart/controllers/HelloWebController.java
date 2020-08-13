package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

  @GetMapping("/web/greeting")
  public String greeting(Model model, @RequestParam String name, @RequestParam String size,
                         @RequestParam String r, @RequestParam String g, @RequestParam String b) {

    Greeting greeting = new Greeting();

    model.addAttribute("greeting", greeting.getGreeting());
    model.addAttribute("style", setStyle(size, r, g, b));
    model.addAttribute("name", name);
    model.addAttribute("greetCount", greeting.getGreetCount());

    return "greeting";
  }

  private String setStyle(String size, String r, String g, String b) {
    return "font-size:" + size + "px;" +
        "color:rgb(" + r + "," + g + "," + b + ");";
  }

  @GetMapping("/FizzBuzzWoof")
  public String fizzBuzzWoofGreeting(Model model) {

    Greeting greeting = new Greeting();

    String output = "";
    int wordsNumber = 0;

    int visitCount = greeting.getGreetCount().intValue();
    if (visitCount%3 == 0 || visitCount%5 == 0 || visitCount%7 == 0) {
      if (visitCount%3 == 0) {
        output += "Fizz";
        wordsNumber++;
      }
      if (visitCount%5 == 0) {
        output += "Buzz";
        wordsNumber++;
      }
      if (visitCount%7 == 0) {
        output += "Woof";
        wordsNumber++;
      }
    } else {
      output += visitCount;
    }

    model.addAttribute("FizzBuzzWoof", output);
    model.addAttribute("fontSize", setFontSize(wordsNumber));

    return "fizzBuzzWoof";
  }

  private int setFontSize(int wordsNumber) {
    int fontSize;
    switch (wordsNumber) {
      case 1:
        fontSize = 24;
        break;
      case 2:
        fontSize = 48;
        break;
      case 3:
        fontSize = 72;
        break;
      default:
        fontSize = 16;
    }
    return fontSize;
  }
}
