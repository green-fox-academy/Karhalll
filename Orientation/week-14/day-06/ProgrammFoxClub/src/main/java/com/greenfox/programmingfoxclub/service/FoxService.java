package com.greenfox.programmingfoxclub.service;

import com.greenfox.programmingfoxclub.model.Fox;
import com.greenfox.programmingfoxclub.model.Trick;
import com.greenfox.programmingfoxclub.repositary.FoxRepo;
import com.greenfox.programmingfoxclub.repositary.TrickRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoxService {
  FoxRepo foxRepo;
  TrickRepo trickRepo;

  public FoxService(FoxRepo foxRepo, TrickRepo trickRepo) {
    this.foxRepo = foxRepo;
    this.trickRepo = trickRepo;
  }

  public List<Trick> tricksToLearn(String name) {
    if (!isFox(name)) {
      return null;
    }
    return trickRepo.findAll().stream()
        .filter(trick -> getFox(name).getTricks().stream()
                            .noneMatch(learnedTrick -> learnedTrick == trick))
        .collect(Collectors.toList());
  }

  public Fox getFox(String name) {
    if (isFox(name)) {
      return foxRepo.getFoxByName(name);
    } else {
      return null;
    }
  }

  public void addFox(String name) {
    foxRepo.addFox(name);
  }

  public boolean isFox(String name) {
    return foxRepo.containsFox(name);
  }
}
