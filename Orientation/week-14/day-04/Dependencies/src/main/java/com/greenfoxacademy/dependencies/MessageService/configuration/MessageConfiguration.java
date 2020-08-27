package com.greenfoxacademy.dependencies.MessageService.configuration;

import com.greenfoxacademy.dependencies.MessageService.service.EmailService;
import com.greenfoxacademy.dependencies.MessageService.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
  @Bean
  public MessageService messageService() {
    return new EmailService();
  }
}
