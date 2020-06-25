package Enum.TwentyPlusOne;

import java.util.Scanner;

public class Main {

  static Game game;
  static Scanner scanner = new Scanner(System.in);
  static boolean isPlaying = true;

  public static void main(String[] args) {
    printWelcomeMessage();

    while (isPlaying) {
      startNewGame();
    }

    System.out.println("Thank you for visiting our casino. Have a great day!");
  }

  private static void printWelcomeMessage() {
    System.out.println("=======WELCOME TO OUR HUMBLE CASINO!=======");
    System.out.println("= YOU are playing game of Twenty Plus One =");
    System.out.println("===========================================");
  }

  private static void startNewGame() {
    System.out.println("Start new game (y/n): ");
    String playerAnswer = scanner.nextLine();

    if (playerAnswer.equals("y")){
      game = new Game();

      game.drawCard();
      while (!game.gameOver) {
        playGame();
      }
    } else {
      isPlaying = false;
    }
  }

  private static void playGame() {
    game.printScore();

    System.out.println("Do you want to continue? (y/n): ");
    String playerAnswer = scanner.nextLine();

    if (playerAnswer.equals("y")){
      game.drawCard();
    } else {
      game.evaluateGame();
    }
  }
}
