package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.domain.ArrayAction;
import org.springframework.http.ResponseEntity;

public interface MainService {
  Object doubling(Integer integerToDouble);
  ResponseEntity<Object> greeter(String name, String title);
  Object doUntil(Integer until, String action);

  Object handleArrayAction(ArrayAction arrayAction);
}
