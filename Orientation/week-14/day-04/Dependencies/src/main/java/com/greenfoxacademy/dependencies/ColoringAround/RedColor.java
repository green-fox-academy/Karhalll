package com.greenfoxacademy.dependencies.ColoringAround;

import com.greenfoxacademy.dependencies.HelloDIProject.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("RedColor")
public class RedColor implements MyColor {

  @Autowired
  private Printer printer;

  @Override
  public void printColor() {
    printer.log("It is red in color...");
  }
}
