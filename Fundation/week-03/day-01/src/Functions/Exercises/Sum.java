public class Sum {
  public static void main(String[] args) {
    // Create the usual class wrapper and main method on your own.

    // Write a function called `sum` that returns the sum of numbers from zero to the given parameter

    System.out.println(sum(1));
    System.out.println(sum(3));
    System.out.println(sum(5));
    System.out.println(sum(10));
  }

  private static int sum (int lastInt) {
    int sum = 0;
    for (int i = 1; i <= lastInt; i++) {
      sum += i;
    }
    return sum;
  }
}
