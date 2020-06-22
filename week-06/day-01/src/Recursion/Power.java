package Recursion;

public class Power {
  public static void main(String[] args) {
    System.out.println(power(3, 2));
  }

  private static int power(int base, int n) {
    if (n > 0) {
      return base * (power(base, n-1));
    } else {
      return 1;
    }
  }
}
