package Inheritance.AircraftCarrier;

public class F35 extends Aircraft {
  F35() {
    super("F35", 12, 50);
  }

  @Override
  boolean isPriority() {
    return true;
  }
}
