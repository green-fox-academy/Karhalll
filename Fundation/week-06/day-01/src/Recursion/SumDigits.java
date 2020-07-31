package Recursion;

public class SumDigits {
  public static void main(String[] args) {
    System.out.println(sumDigits(123456));
  }

  private static int sumDigits(int n) {
    if (n > 0) {
      return (n % 10) + sumDigits(n / 10);
    } else {
      return 0;
    }
  }
}
