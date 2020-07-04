package main.java.animals;

public class Prototheria extends Animal {
  public Prototheria(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "by laying eggs.";
  }
}
