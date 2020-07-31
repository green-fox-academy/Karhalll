package Recursion;

public class BunniesAgain {
  public static void main(String[] args) {
    System.out.println(bunniesAgain(9));
  }

  private static int bunniesAgain(int n) {
    if (n <= 0) {
      return 0;
    } else if (n % 2 == 0) {
      return 2 + bunniesAgain(n - 1);
    } else {
      return 3 + bunniesAgain(n - 1);
    }
  }
}
