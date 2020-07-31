package main.java.animals;

public class Mammal extends Animal {
  int numberOfMammaryGlands;

  public Mammal(String name) {
    super(name);
  }

  public void combHair() {
    System.out.println(name + " is combing hair.");
  }

  @Override
  public String breed() {
    return "pushing miniature versions out.";
  }
}
