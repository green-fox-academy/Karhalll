package PetrolStation;

public class Station {
  float gasAmount;

  public void refill(Car car) {
    gasAmount -= car.capacity;
    car.gasAmount += car.capacity;
  }
}
