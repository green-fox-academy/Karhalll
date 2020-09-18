package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.domain.Doubling;
import com.greenfoxacademy.backendapi.domain.Greeter;

public interface MainService {
  Doubling doubling(Integer integerToDouble);
  Greeter greeter(String name, String title);
}
