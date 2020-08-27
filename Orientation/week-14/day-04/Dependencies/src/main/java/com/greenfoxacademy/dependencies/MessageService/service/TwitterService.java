package com.greenfoxacademy.dependencies.MessageService.service;

import org.springframework.stereotype.Service;

@Service
public class TwitterService implements MessageService {
  @Override
  public void sendMessage(String message, String sendTo) {
    System.out.println("Twitter Sent to " + sendTo + " with Message=" + message);
  }
}
