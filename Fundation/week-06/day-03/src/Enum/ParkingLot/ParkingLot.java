package Enum.ParkingLot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < 256; i++) {
      cars.add(new Car());
    }

    System.out.println("=== TYPES OF CARS ===");
    numberOfEveryType(cars);
    System.out.println();

    System.out.println("=== COLORS ===");
    numberOfEveryColor(cars);
    System.out.println();

    mostFrequentlyOccurringVehicle(cars);
  }

  private static void numberOfEveryType(List<Car> cars) {
    for (int i = 0; i < CarType.values().length; i++) {
      int numberOfType = 0;
      for (Car car : cars) {
        if (car.type == CarType.values()[i]) {
          numberOfType++;
        }
      }
      System.out.println(CarType.values()[i] + ": " + numberOfType);
    }
  }

  private static void numberOfEveryColor(List<Car> cars) {
    for (int i = 0; i < CarColor.values().length; i++) {
      int numberOfColor = 0;
      for (Car car : cars) {
        if (car.color == CarColor.values()[i]) {
          numberOfColor++;
        }
      }
      System.out.println(CarColor.values()[i] + ": " + numberOfColor);
    }
  }

  private static void mostFrequentlyOccurringVehicle(List<Car> cars) {
    HashMap<String, Integer> variantsCount = new HashMap<>();

    for (Car car : cars) {
      String key = car.color + " " + car.type;
      if (!variantsCount.containsKey(key)) {
        variantsCount.put(key, 0);
      } else {
        variantsCount.put(key, variantsCount.get(key) + 1);
      }
    }

    int max = Collections.max(variantsCount.values());

    for (Map.Entry<String, Integer> entry : variantsCount.entrySet()) {
      if (entry.getValue() == max) {
        System.out.println("Most frequently occuring vehicle is "
            + entry.getKey()+ " (" + entry.getValue() + ")");
      }
    }
  }
}
