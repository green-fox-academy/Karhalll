package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.User;
import com.greenfoxacademy.reddit.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  @Autowired
  public UserServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public boolean isAlreadyUser(String username) {
    return userRepo.findFirstByUsername(username) != null;
  }

  @Override
  public void registerUser(String username, String password) {
    userRepo.save(new User(username, password));
  }

  @Override
  public boolean validLogIn(String username, String password) {
    return userRepo.findFirstByUsername(username).getPassword().equals(password);
  }
}
