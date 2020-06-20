package Pirates;

import java.util.Random;

public class Pirate {
  int intoxication = 0;
  boolean isSleeping = false;
  boolean isAlive = true;
  boolean hasParrot = false;

  public void drinkSomeRum() {
    if (!isAlive) {
      System.out.println("He's dead.");
      return;
    }

    if (intoxication <= 4) {
      intoxication++;
    }
    if (intoxication == 5) {
      isSleeping = true;
    }
  }

  public void howsItGoingMate() {
    if (!isAlive) {
      System.out.println("He's dead.");
      return;
    }

    if (intoxication <= 4) {
      System.out.println("Pour me anudder!");
    } else {
      System.out.println("Arghh, I'm Pirate. How d'ya d'ink its goin?");
      isSleeping = true;
    }
  }

  public void die() {
    isAlive = false;
  }

  public void brawl(Pirate enemyPirate) {
    if (!isAlive || !enemyPirate.isAlive) { return; }

    Random random = new Random();
    int diceThrow = random.nextInt(3);

    switch (diceThrow) {
      case 0:
        isAlive = false;
        break;
      case 1:
        enemyPirate.isAlive = false;
        break;
      case 2:
        isSleeping = true;
        enemyPirate.isSleeping = true;
        break;
    }
  }
}
