package com.greenfoxacademy.dependencies.ColoringAround;

import com.greenfoxacademy.dependencies.HelloDIProject.Printer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("RedColor")
public class RedColor implements MyColor {

  private final Printer printer;

  public RedColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("It is red in color...");
  }
}
