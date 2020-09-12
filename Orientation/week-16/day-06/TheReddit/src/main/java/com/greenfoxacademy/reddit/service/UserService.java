package com.greenfoxacademy.reddit.service;

public interface UserService {
  boolean isAlreadyUser(String username);
  void registerUser(String username, String password);
  boolean validLogIn(String username, String password);
}
