package com.greenfoxacademy.dependencies.HelloDIProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloBeanWorldApplication implements CommandLineRunner {

  private final Printer printer;

  public HelloBeanWorldApplication(Printer printer) {
    this.printer = printer;
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloBeanWorldApplication.class, args);

    System.exit(0);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("hello");
  }
}
