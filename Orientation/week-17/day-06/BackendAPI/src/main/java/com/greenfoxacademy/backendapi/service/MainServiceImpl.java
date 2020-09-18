package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.domain.Doubling;
import com.greenfoxacademy.backendapi.domain.Greeter;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

  @Override
  public Doubling doubling(Integer integerToDouble) {
    if (integerToDouble == null) {
      return new Doubling();
    } else {
      return new Doubling(integerToDouble);
    }
  }

  @Override
  public Greeter greeter(String name, String title) {
    if (name != null && title != null) {
      return new Greeter(name, title);
    } else {
      return handleGreetNullPointer(name, title);
    }
  }

  private Greeter handleGreetNullPointer(String name, String title) {
    if (name == null && title == null) {
      return new Greeter("Please provide a name and a title!");
    } else if (name == null) {
      return new Greeter("Please provide a name!");
    } else {
      return new Greeter("Please provide a title!");
    }
  }
}
