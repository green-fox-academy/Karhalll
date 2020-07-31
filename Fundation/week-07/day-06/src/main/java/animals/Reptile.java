package main.java.animals;

public class Reptile extends Prototheria {
  boolean isSkinned;

  public Reptile(String name) {
    super(name);
  }

  public void skin() {
    if (!isSkinned) {
      System.out.println(name + " is skinning.");
    } else {
      System.out.println(name + " is already naked!");
    }
  }
}
