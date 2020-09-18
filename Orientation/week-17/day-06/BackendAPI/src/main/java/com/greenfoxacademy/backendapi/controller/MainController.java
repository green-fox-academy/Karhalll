package com.greenfoxacademy.backendapi.controller;

import com.greenfoxacademy.backendapi.domain.Doubling;
import com.greenfoxacademy.backendapi.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  private final MainService mainService;

  @Autowired
  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping("/")
  public String showIndexPage() {
    return "index";
  }

  @GetMapping("/doubling")
  @ResponseBody
  public ResponseEntity<Doubling> calculateDoubling(@RequestParam(required = false) Integer input) {
    return ResponseEntity.ok()
        .body(mainService.doubling(input));
  }

//  @GetMapping("/greeter")
//  @ResponseBody
//  public ResponseEntity<String> greet(@RequestParam String name,) {}

}
