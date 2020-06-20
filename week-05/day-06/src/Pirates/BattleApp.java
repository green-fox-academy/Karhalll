package Pirates;

public class BattleApp {
  public static void main(String[] args) {
    Ship ship1 = new Ship();
    Ship ship2 = new Ship();

    ship1.fillShip();
    ship2.fillShip();

    ship1.shipStatus();
    ship2.shipStatus();

    System.out.println("First ship won: " + ship1.battle(ship2));
    System.out.println();

    ship1.shipStatus();
    ship2.shipStatus();
  }
}
