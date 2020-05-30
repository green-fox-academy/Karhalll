import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {
    // Write a program that asks for a number.
    // It would ask this many times to enter an integer,
    // if all the integers are entered, it should print the sum and average of these
    // integers like:
    //
    // Sum: 22, Average: 4.4

    Scanner scanner = new Scanner(System.in);

    int sum = 0;

    System.out.println("How many Integers: ");
    int numberCount = scanner.nextInt();

    for (int i = 0; i < numberCount; i++) {
      System.out.println("Insert " + (i + 1) + ". Integer: ");
      sum += scanner.nextInt();
    }

    System.out.println("Sum: " + sum + ", Average: " + (float)(sum / numberCount));
  }
}
