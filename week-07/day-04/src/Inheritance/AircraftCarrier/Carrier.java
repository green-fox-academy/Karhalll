package Inheritance.AircraftCarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  private List<Aircraft> aircrafts = new ArrayList<>();

  int healthPoints;
  int ammoStored;

  Carrier(int healthPoints,int ammoStored) {
    this.healthPoints = healthPoints;
    this.ammoStored = ammoStored;
  }

  void add(Aircraft aircraft) {
    if (aircraft.isPriority()) {
      aircrafts.add(0, aircraft);
    } else {
      aircrafts.add(aircraft);
    }
  }

  void fill() throws Exception {
    if (ammoStored <= 0) {
      throw new Exception("Ammo storage is empty!");
    } else {
      // The priority aircrafts are filled first (add() is making sure that they are at top of list)
      for (int i = 0; i < aircrafts.size() || ammoStored <= 0; i++) {
        ammoStored = aircrafts.get(i).refill(ammoStored);
      }
    }
  }

  void fight(Carrier carrierToFight) {
    int totalDMG = 0;
    for (Aircraft aircraft : aircrafts) {
      totalDMG += aircraft.fight();
    }

    carrierToFight.healthPoints -= totalDMG;
  }

  String getStatus() {
    if (healthPoints <= 0) {
      return "It's dead Jim :(";
    } else {
      String aircraftsStatuses = "";
      int totalDMG = 0;
      for (Aircraft aircraft : aircrafts) {
        aircraftsStatuses += aircraft.getStatus() + "\n";
        totalDMG += aircraft.ammo * aircraft.baseDmg;
      }

      String output = "HP: " + healthPoints
          + ", Aircraft count: " + aircrafts.size()
          + ", Ammo Storage: " + ammoStored
          + ", Total damage: " + totalDMG + "\n";

      if (aircrafts.size() > 0) {
        output += "Aircrafts:\n" + aircraftsStatuses;
      }

      return output;
    }
  }
}
