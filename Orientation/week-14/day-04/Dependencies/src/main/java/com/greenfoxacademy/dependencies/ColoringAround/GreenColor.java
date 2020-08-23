package com.greenfoxacademy.dependencies.ColoringAround;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("GreenColor")
public class GreenColor implements MyColor {

  @Override
  public void printColor() {
    System.out.println("It is green in color...");
  }
}
