package com.greenfox.programmingfoxclub.service;

import com.greenfox.programmingfoxclub.model.User;
import com.greenfox.programmingfoxclub.repositary.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepo userRepo;

  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public boolean isAlreadyUser(String username) {
    return userRepo.findFirstByUsername(username) != null;
  }

  public void registerUser(String username, String password) {
    userRepo.save(new User(username, password));
  }

  public boolean validLogIn(String username, String password) {
    return userRepo.findFirstByUsername(username).getPassword().equals(password);
  }
}
