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
        .filter(trick -> getByName(name).getTricks().stream()
                            .noneMatch(learnedTrick -> learnedTrick == trick))
        .collect(Collectors.toList());
  }

  public Fox getByName(String foxName) {
      return foxRepo.getFoxByName(foxName);
  }

  public void creatByName(String newFoxName) {
    foxRepo.save(new Fox(newFoxName));
  }

  public boolean isFox(String foxName) {
    return getByName(foxName) != null;
  }

  public void learnTrick(String foxName, Trick newTrick) {
    Fox fox = getByName(foxName);
    List<Trick> tricks = fox.getTricks();
    tricks.add(newTrick);
    fox.setTricks(tricks);
    foxRepo.save(fox);
  }
}
