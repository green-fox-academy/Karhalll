package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Fox;

public interface FoxRepo {

  boolean containsFox(String name);
  Fox getFoxByName(String name);
  void addFox(String name);
}
