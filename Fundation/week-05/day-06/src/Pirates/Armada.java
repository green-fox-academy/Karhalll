package Pirates;

import java.util.ArrayList;
import java.util.List;

public class Armada {
  List<Ship> ships = new ArrayList<Ship>();

  public boolean war(Armada enemyArmada) {
    int ourSize = ships.size();
    int enemySize = enemyArmada.ships.size();

    while(ourSize > 0 && enemySize > 0) {
      boolean weWonBattle = ships.get(ourSize - 1).battle(enemyArmada.ships.get(enemySize - 1));

      if (weWonBattle) {
        enemySize--;
      } else {
        ourSize--;
      }
    }

    return ourSize > 0;
  }
}
