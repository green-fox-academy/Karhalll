import java.util.Scanner;

public class PrintBigger {
  public static void main(String[] args) {
    // Write a program that asks for two numbers and prints the bigger one

    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert two integers (separated by space): ");
    int firstNum = scanner.nextInt();
    int secondNum = scanner.nextInt();

    if (firstNum > secondNum) {
      System.out.println(firstNum);
    } else if (secondNum > firstNum) {
      System.out.println(secondNum);
    } else {
      System.out.println("Numbers are even");
    }
  }
}
