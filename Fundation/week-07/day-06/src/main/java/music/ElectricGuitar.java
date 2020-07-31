package main.java.music;

public class ElectricGuitar extends StringedInstrument {
  public ElectricGuitar() {
    super("ElectricGuitar", 6);
  }

  public ElectricGuitar(int numberOfStrings) {
    super("ElectricGuitar", numberOfStrings);
  }

  @Override
  String sound() {
    return "Twang";
  }
}
