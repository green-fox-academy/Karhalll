package Interfaces.Printable;

public class Domino implements Printable {
  int leftSide;
  int rightSide;

  Domino(int leftSide, int rightSide) {
    this.leftSide = leftSide;
    this.rightSide = rightSide;
  }

  @Override
  public void printAllFields() {
    System.out.println("Domino A side: " + leftSide + ", B side: " + rightSide); ;
  }
}
