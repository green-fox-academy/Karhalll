package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.domain.Doubling;
import com.greenfoxacademy.backendapi.domain.Greeter;
import org.springframework.http.ResponseEntity;

public interface MainService {
  Doubling doubling(Integer integerToDouble);
  Greeter greeter(String name, String title);

  ResponseEntity doSumUntil(Integer until);
  ResponseEntity doFactorUntil(Integer until);
}
