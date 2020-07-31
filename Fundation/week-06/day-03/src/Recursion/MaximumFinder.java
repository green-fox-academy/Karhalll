package Recursion;

public class MaximumFinder {
  public static void main(String[] args) {
    int[] numbers = new int[]{5, 1523, 8, 45, 23, 521, 5, 1};

    System.out.println(maximumFinder(numbers, numbers.length));
  }

  private static int maximumFinder(int[] numbers, int numbersLength) {
    if (numbersLength == 1) {
      return numbers[0];
    } else {
      return Math.max(
          numbers[numbersLength - 1],
          maximumFinder(numbers, numbersLength - 1));
    }
  }
}
