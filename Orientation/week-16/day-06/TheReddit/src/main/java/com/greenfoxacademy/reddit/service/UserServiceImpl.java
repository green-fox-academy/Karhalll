package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.User;
import com.greenfoxacademy.reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isAlreadyUser(String username) {
    return userRepository.findFirstByUsername(username) != null;
  }

  @Override
  public void registerUser(String username, String password) {
    userRepository.save(new User(username, password));
  }

  @Override
  public boolean validLogIn(String username, String password) {
    return userRepository.findFirstByUsername(username).getPassword().equals(password);
  }
}
