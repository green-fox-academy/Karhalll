package com.greenfoxacademy.backendapi.controller;

import com.greenfoxacademy.backendapi.dto.ArrayAction;
import com.greenfoxacademy.backendapi.dto.Entries;
import com.greenfoxacademy.backendapi.dto.Until;
import com.greenfoxacademy.backendapi.service.LogService;
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
  private final LogService logService;

  @Autowired
  public MainController(MainService mainService, LogService logService) {
    this.mainService = mainService;
    this.logService = logService;
  }

  @GetMapping("/")
  public String showIndexPage() {
    return "index";
  }

  @GetMapping("/doubling")
  @ResponseBody
  public ResponseEntity<Object> calculateDoubling(@RequestParam(required = false) Integer input) {

    logService.logParamAction("/doubling", "input", input);

    return ResponseEntity.ok()
        .body(mainService.doubling(input));
  }

  @GetMapping("/greeter")
  @ResponseBody
  public ResponseEntity<Object> greet(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String title) {

    logService.log2ParamsAction("/greeter", "name", name, "title", title);

    return mainService.greeter(name, title);
  }

  @GetMapping("/appenda/{appendable}")
  @ResponseBody
  public ResponseEntity<String> appendA(@PathVariable String appendable) {

    logService.logParamAction("/appenda/{appendable}", "appendable", appendable);

    return ResponseEntity.ok()
        .body("{\"appended\": \"" + appendable + "a\"}");
  }

  @GetMapping("/appenda/")
  public ResponseEntity<HttpStatus> appendAError() {

    logService.logParamAction("/appenda/", "", null);

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/dountil/{action}")
  @ResponseBody
  public ResponseEntity<Object> doActionUntil(@RequestBody(required = false) Until until,
                                              @PathVariable String action) {

    logService.log2ParamsAction("/dountil/{action}", "until", until, "action", action);

    return ResponseEntity.ok()
        .body(mainService.doUntil(until.getUntil(), action));
  }

  @PostMapping("/arrays")
  @ResponseBody
  public ResponseEntity<Object> handleArrayAction(@RequestBody ArrayAction arrayAction) {

    logService.logParamAction("/arrays", "array_action", arrayAction);

    return ResponseEntity.ok()
        .body(mainService.handleArrayAction(arrayAction));
  }

  @GetMapping("/log")
  @ResponseBody
  public ResponseEntity<Entries> sendLogs() {
    return ResponseEntity.ok()
        .body(logService.entries());
  }
}
