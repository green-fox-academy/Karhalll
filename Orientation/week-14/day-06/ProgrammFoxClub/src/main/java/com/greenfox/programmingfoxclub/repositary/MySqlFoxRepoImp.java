package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Fox;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlFoxRepoImp implements FoxRepo {

  private final MySqlFoxRepo mySqlFoxRepo;

  public MySqlFoxRepoImp(MySqlFoxRepo mySqlFoxRepo) {
    this.mySqlFoxRepo = mySqlFoxRepo;
  }

  @Override
  public boolean containsFox(String name) {
    return false;
  }

  @Override
  public Fox getFoxByName(String name) {
    return null;
  }

  @Override
  public void addFox(String name) {
    mySqlFoxRepo.save(new Fox("name"));
  }
}
