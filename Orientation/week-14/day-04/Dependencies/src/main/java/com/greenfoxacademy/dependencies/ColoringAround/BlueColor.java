package com.greenfoxacademy.dependencies.ColoringAround;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("BlueColor")
public class BlueColor implements MyColor {

  @Override
  public void printColor() {
    System.out.println("It is blue in color...");
  }
}
