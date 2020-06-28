package Inheritance.GardenApplication;

public class Plant {
  String name;
  String color;

  float waterAmount;
  int waterNeed;
  float waterAbsorbIndex;

  Plant(String name, String color, int waterNeed, float waterAbsorbIndex) {
    this.name = name;
    this.color = color;
    this.waterNeed = waterNeed;
    this.waterAbsorbIndex = waterAbsorbIndex;

    waterAmount = 0;
  }

  String status() {
    if (waterAmount > waterNeed) {
      return "doesnt need water";
    } else {
      return "needs water";
    }
  }

  void water(int waterAmount) {
    this.waterAmount += waterAmount * waterAbsorbIndex;
  }
}
