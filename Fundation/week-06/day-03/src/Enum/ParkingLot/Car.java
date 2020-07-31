package Enum.ParkingLot;

import java.util.Random;

public class Car {

  CarType type;
  CarColor color;

  public Car() {
    Random random = new Random();
    type = CarType.values()[random.nextInt(CarType.values().length)];
    color = CarColor.values()[random.nextInt(CarColor.values().length)];
  }
}
