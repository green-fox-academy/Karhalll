package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Fox;

import java.util.ArrayList;
import java.util.List;

public class ListFoxRepo implements FoxRepo {
  List<Fox> foxList;

  public ListFoxRepo() {
    this.foxList = new ArrayList<>();
  }

  @Override
  public boolean containsFox(String name) {
    return foxList.stream()
        .anyMatch(fox -> fox.getName().equals(name));
  }

  @Override
  public Fox getFoxByName(String name) {
    return foxList.stream()
        .filter(fox -> fox.getName().equals(name))
        .findFirst()
        .get();
  }

  @Override
  public void addFox(String name) {
    foxList.add(new Fox(name));
  }
}
