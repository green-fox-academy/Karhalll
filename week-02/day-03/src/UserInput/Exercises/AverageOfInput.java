import java.util.Scanner;

public class AverageOfInput {
  public static void main(String[] args) {
    // Write a program that asks for 5 integers in a row,
    // then it should print the sum and the average of these numbers like:
    //
    // Sum: 22, Average: 4.4

    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert 5 integers in row (with spaces between them): ");
    int firstInt = scanner.nextInt();
    int secondInt = scanner.nextInt();
    int thirdInt = scanner.nextInt();
    int fourthInt = scanner.nextInt();
    int fifthInt = scanner.nextInt();

    int sum = firstInt + secondInt + thirdInt + fourthInt + fifthInt;
    float avg = sum / 5f;

    System.out.println("Sum: " + sum + ", Average: " + avg);
  }
}
