package Recursion;

public class GreatestCommonDivisor {
  public static void main(String[] args) {
    System.out.println(greatestCommonDivisor(32, 144));
  }

  private static int greatestCommonDivisor(int a, int b) {
    if (b != 0) {
      return greatestCommonDivisor(b, a % b);
    } else
      return a;
  }
}
