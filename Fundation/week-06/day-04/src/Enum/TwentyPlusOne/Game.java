package Enum.TwentyPlusOne;

import java.util.Random;

public class Game {
  Deck deck = new Deck();

  int enemyScore;
  int playerScore = 0;

  boolean gameOver = false;

  public Game() {
    Random random = new Random();
    enemyScore = random.nextInt(7) + 15;

    deck.shuffleDeck();
  }

  public void drawCard() {
    Card drawCard = deck.pullFirst();
    playerScore += drawCard.rank.value;

    System.out.println("You draw : " + drawCard.CardFace());

    if (playerScore > 21) {
      gameOver = true;
      evaluateGame();
    } else {
      System.out.println(printScore());
      deck.removeCard(drawCard);
    }
  }

  public String printScore() {
    return "Your score is: " + playerScore;
  }
  public String printEnemyScore() {
    return "Enemy score is: " + enemyScore;
  }

  public void evaluateGame() {
    if (playerScore > enemyScore && playerScore < 21) {
      System.out.println("You win!");
    } else if (playerScore == enemyScore) {
      System.out.println("It is a draw!");
    } else {
      System.out.println("You lost!");
    }
    System.out.println(printScore());
    System.out.println(printEnemyScore());
    System.out.println("=========================");
    gameOver = true;
  }
}
