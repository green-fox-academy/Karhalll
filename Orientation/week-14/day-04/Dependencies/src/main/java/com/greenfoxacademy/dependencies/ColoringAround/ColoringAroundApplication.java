package com.greenfoxacademy.dependencies.ColoringAround;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColoringAroundApplication implements CommandLineRunner {

  @Autowired
  @Qualifier("RedColor")
  private MyColor myColor;

  public static void main(String[] args) {
    SpringApplication.run(ColoringAroundApplication.class, args);

    System.exit(0);
  }

  @Override
  public void run(String... args) throws Exception {
    myColor.printColor();
  }
}
