package com.greenfoxacademy.dependencies.GreenfoxAppClass;

import com.greenfoxacademy.dependencies.GreenfoxAppClass.services.FileService;
import com.greenfoxacademy.dependencies.GreenfoxAppClass.services.ListService;
import com.greenfoxacademy.dependencies.GreenfoxAppClass.services.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreenfoxAppClassConfig {
  @Bean
  public StudentService studentService() {
//    return new FileService("src/main/resources/static/gfa/students.txt");
    return new ListService();
  }
}
