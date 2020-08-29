package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Fox;
import com.greenfox.programmingfoxclub.model.Trick;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoxRepo {
  List<Fox> foxList;

  public FoxRepo() {
    this.foxList = new ArrayList<>();
  }

  public boolean contains(String name) {
    return foxList.stream()
        .anyMatch(fox -> fox.getName().equals(name));
  }

  public Fox getFoxByName(String name) {
    return foxList.stream()
        .filter(fox -> fox.getName().equals(name))
        .findFirst()
        .get();
  }

  public void addFox(String name) {
    foxList.add(new Fox(name));
  }

  public List<Trick> getTricksByName(String name) {
    return getFoxByName(name).getTricks();
  }
}
