package main.java.animals;

public class Bird extends Prototheria {
  int numberOfFeathers;

  public Bird(String name) {
    super(name);
  }

  public void layEggs() {
    System.out.println(name + " is laying eggs.");
  }
}
