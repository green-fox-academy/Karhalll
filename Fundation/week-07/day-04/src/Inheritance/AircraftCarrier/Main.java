package Inheritance.AircraftCarrier;

public class Main {
  public static void main(String[] args) throws Exception {
    Carrier carrier1 = new Carrier(5000, 2300);

    System.out.println(carrier1.getStatus());

    for (int i = 0; i < 2; i++) {
      carrier1.add(new F16());
    }
    for (int i = 0; i < 3; i++) {
      carrier1.add(new F35());
    }
    System.out.println(carrier1.getStatus());

    carrier1.fill();
    System.out.println(carrier1.getStatus());

    Carrier carrier2 = new Carrier(carrier1);

    carrier1.fight(carrier2);
    System.out.println(carrier1.getStatus());
    System.out.println(carrier2.getStatus());
  }
}
