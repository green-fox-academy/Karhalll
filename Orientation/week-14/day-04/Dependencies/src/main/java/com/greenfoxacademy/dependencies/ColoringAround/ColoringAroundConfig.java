package com.greenfoxacademy.dependencies.ColoringAround;

import com.greenfoxacademy.dependencies.HelloDIProject.Printer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColoringAroundConfig {
  @Bean
  public Printer printer() {
    return new Printer();
  }
}
