import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {
    // Write a program that stores a number, and the user has to figure it out.
    // The user can input guesses, after each guess the program would tell one
    // of the following:
    //
    // The stored number is higher
    // The stored number is lower
    // You found the number: 8

    Scanner scanner = new Scanner(System.in);

    final int secretNumber = 58;
    boolean isGuessCorrect = false;

    System.out.println("Try to guess the secret number between 0 - 100");

    while (!isGuessCorrect) {
      System.out.println("Your guess: ");
      int guess = scanner.nextInt();

      if (guess < 0 || guess > 100) {
        System.out.println("Number is between 0 - 100");
        System.out.println("Try again");
      } else if (guess < secretNumber) {
        System.out.println("The stored number is higher");
        System.out.println("Try again");
      } else if (guess > secretNumber) {
        System.out.println("The stored number is lower");
        System.out.println("Try again");
      } else {
        System.out.println("You found the number: " + secretNumber);
        System.out.println("You WIN!");
        isGuessCorrect = true;
      }
    }
  }
}
