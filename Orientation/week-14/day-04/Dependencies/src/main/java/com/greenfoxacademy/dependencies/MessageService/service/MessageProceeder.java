package com.greenfoxacademy.dependencies.MessageService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProceeder {

  MessageService messageService;

  @Autowired
  public MessageProceeder(MessageService messageService) {
    this.messageService = messageService;
  }

  public void setMessageService(MessageService messageService) {
    this.messageService = messageService;
  }

  public void processMessage(String message, String sendTo) {
    messageService.sendMessage(message, sendTo);
  }
}
