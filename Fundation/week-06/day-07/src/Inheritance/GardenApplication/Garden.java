package Inheritance.GardenApplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Plant> plants;

  Garden() {
    plants = new ArrayList<>();
  }

  void addPlant(Plant plant) {
    plants.add(plant);
  }

  void info() {
    for (Plant plant : plants) {
      System.out.println("The " + plant.color + " " + plant.name + " " + plant.status());
    }

    System.out.println();
  }

  void waterPlants(int waterAmount) {
    System.out.println("Watering with " + waterAmount);

    List<Plant> needsWater = needsWater();
    for (Plant plant : needsWater) {
      plant.water(waterAmount / needsWater.size());
    }
  }

  List<Plant> needsWater() {
    List<Plant> needsWater = new ArrayList<>();

    for (Plant plant : plants) {
      if (plant.waterAmount < plant.waterNeed) {
        needsWater.add(plant);
      }
    }

    return needsWater;
  }
}
