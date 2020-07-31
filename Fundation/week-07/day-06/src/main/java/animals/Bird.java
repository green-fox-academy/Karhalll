package main.java.animals;

import Interfaces.Flyable.Flyable;

public class Bird extends Prototheria implements Flyable {
  int numberOfFeathers;

  public Bird(String name) {
    super(name);
  }

  public void layEggs() {
    System.out.println(name + " is laying eggs.");
  }

  @Override
  public void land() {

  }

  @Override
  public void fly() {

  }

  @Override
  public void takeOff() {

  }
}
