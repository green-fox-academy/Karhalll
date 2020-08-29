package com.greenfox.programmingfoxclub.service;

import com.greenfox.programmingfoxclub.model.Fox;
import com.greenfox.programmingfoxclub.repositary.FoxRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxService {
  FoxRepo foxRepo;

  public FoxService(FoxRepo foxRepo) {
    this.foxRepo = foxRepo;
  }

  public Fox getFox(String name) {
    if (!isFox(name)) {
      foxRepo.addFox(name);
    }
    return foxRepo.getFoxByName(name);
  }

  private boolean isFox(String name) {
    return foxRepo.contains(name);
  }
}
