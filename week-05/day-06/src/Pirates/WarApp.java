package Pirates;

public class WarApp {
  public static void main(String[] args) {
    Armada armada1 = new Armada();
    Armada armada2 = new Armada();

    int shipsInArmada = 14;

    for (int i = 0; i < shipsInArmada; i++) {
      Ship ship1 = new Ship();
      Ship ship2 = new Ship();

      ship1.fillShip();
      ship2.fillShip();

      armada1.ships.add(ship1);
      armada2.ships.add(ship2);
    }

    System.out.println("First armada won: " + armada1.war(armada2));
  }
}
