import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
    // Create a function that takes a number
    // divides ten with it,
    // and prints the result.
    // It should print "fail" if the parameter is 0

    System.out.println("Insert number: ");

    Scanner scanner = new Scanner(System.in);
    int divisor = scanner.nextInt();

    try {
      int result = 10 / divisor;
      System.out.println("10 / " + divisor + " = " + result);
    } catch (ArithmeticException e) {
      System.out.println("Can't divide by zero!");
    }
  }
}
