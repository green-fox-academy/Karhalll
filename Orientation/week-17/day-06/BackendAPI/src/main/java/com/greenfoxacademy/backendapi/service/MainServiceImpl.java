package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.domain.Doubling;
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
}
