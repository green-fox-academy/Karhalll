package com.greenfoxacademy.backendapi.controller;

import com.greenfoxacademy.backendapi.domain.Until;
import com.greenfoxacademy.backendapi.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public ResponseEntity<Object> calculateDoubling(@RequestParam(required = false) Integer input) {
    return ResponseEntity.ok()
        .body(mainService.doubling(input));
  }

  @GetMapping("/greeter")
  @ResponseBody
  public ResponseEntity<Object> greet(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String title) {
    return mainService.greeter(name, title);
  }

  @GetMapping("/appenda/{appendable}")
  @ResponseBody
  public ResponseEntity<String> appendA(@PathVariable String appendable) {
    return ResponseEntity.ok()
        .body("{\"appended\": \"" + appendable + "a\"}");
  }

  @GetMapping("/appenda/")
  public ResponseEntity<HttpStatus> appendAError() {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/dountil/{action}")
  @ResponseBody
  public ResponseEntity<Object> doActionUntil(@RequestBody(required = false) Until until, @PathVariable String action) {
    return ResponseEntity.ok()
        .body(mainService.doUntil(until.getUntil(), action));
  }
}
