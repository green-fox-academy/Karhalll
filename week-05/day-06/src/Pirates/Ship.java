package Pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
  Pirate captain;
  List<Pirate> crew = new ArrayList<Pirate>();

  final static int MAX_CREW_SIZE = 20;

  public void fillShip() {
    captain = new Pirate();

    Random random = new Random();
    int randomCrewSize = random.nextInt(MAX_CREW_SIZE);

    for (int i = 0; i < randomCrewSize; i++) {
      crew.add(new Pirate());
    }
  }

  public void shipStatus() {
    String captainState;
    if (!captain.isAlive) {
      captainState = "died";
    } else if (captain.isSleeping) {
      captainState = "passed out";
    } else if (captain.intoxication > 0) {
      captainState = "intoxicated";
    } else {
      captainState = "sober and alive (Is he really a pirate?)";
    }

    System.out.println("                SHIP STATUS                 ");
    System.out.println("--------------------------------------------");
    System.out.println("Number of alive pirates: " + getAlivePirates());
    System.out.println("Captains consumed rum: " + (captain.intoxication));
    System.out.println("Captain state: " + captainState);
    System.out.println();
  }

  public boolean battle(Ship enemyShip) {
    int score = calculateBattleScore(this);
    int enemyScore = calculateBattleScore(enemyShip);

    if (score > enemyScore) {
      party(this);
      randomLosses(enemyShip);
    } else if (enemyScore > score) {
      party(enemyShip);
      randomLosses(this);
    }

    return score > enemyScore;
  }

  private void party(Ship ship) {
    Random random = new Random();
    int randomRum = random.nextInt(6);

    for (int i = 0; i < randomRum; i++) {
      ship.captain.drinkSomeRum();
      for (Pirate pirate : ship.crew) {
        pirate.drinkSomeRum();
      }
    }
  }

  private void randomLosses(Ship ship) {
    if (ship.getAlivePirates() < 1) { return; }

    Random random = new Random();
    int randomLosses = random.nextInt(ship.getAlivePirates());

    for (int i = 0; i <= randomLosses; i++) {
      Pirate pirate = ship.crew.get(i);
      if (pirate.isAlive) {
        pirate.die();
      } else {
        randomLosses++;
      }
    }
  }

  private int calculateBattleScore(Ship ship) {
    return ship.getAlivePirates() - ship.captain.intoxication;
  }

  private int getAlivePirates() {
    int alivePirates = 0;
    for (Pirate pirate : crew) {
      if (pirate.isAlive) {
        alivePirates++;
      }
    }
    return alivePirates;
  }
}
