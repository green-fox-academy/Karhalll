package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.domain.Result;
import com.greenfoxacademy.backendapi.domain.Doubling;
import com.greenfoxacademy.backendapi.domain.Error;
import com.greenfoxacademy.backendapi.domain.Greeter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

  @Override
  public Object doubling(Integer integerToDouble) {
    if (integerToDouble == null) {
      return new Error("Please provide an input!");
    } else {
      return new Doubling(integerToDouble);
    }
  }

  @Override
  public ResponseEntity<Object> greeter(String name, String title) {
    if (name == null || title == null) {
      return new ResponseEntity<>(handleGreetNullPointer(name, title), HttpStatus.BAD_REQUEST);
    } else {
      return ResponseEntity.ok()
          .body(new Greeter(name, title));
    }
  }

  @Override
  public Object doUntil(Integer until, String action) {
    if (until == null) {
      return new Error("Please provide a number!");
    } else {
      int result = action.equals("sum") ? 0 : 1;
      for (int i = 1; i <= until; i++) {
        switch (action) {
          case "sum" -> result += i;
          case "factor" -> result *= i;
        }
      }
      return new Result(result);
    }
  }

  private Error handleGreetNullPointer(String name, String title) {
    if (name == null && title == null) {
      return new Error("Please provide a name and a title!");
    } else if (name == null) {
      return new Error("Please provide a name!");
    } else {
      return new Error("Please provide a title!");
    }
  }
}
