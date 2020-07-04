package main.java.animals;

import java.awt.Color;

public abstract class Animal {
  protected String name;
  protected int age;
  protected Color color;

  abstract String breed();

  Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Color getColor() {
    return color;
  }
}
