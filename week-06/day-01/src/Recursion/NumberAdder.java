package Recursion;

public class NumberAdder {
  public static void main(String[] args) {
    System.out.println(numberAdder(0));
  }

  private static int numberAdder(int n) {
    if (n > 1) {
      return n + numberAdder(n - 1);
    } else {
      return 1;
    }
  }
}
