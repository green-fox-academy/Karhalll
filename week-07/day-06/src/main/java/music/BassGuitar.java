package main.java.music;

public class BassGuitar extends StringedInstrument {
  public BassGuitar() {
    super("BaseGuitar", 4);
  }

  public BassGuitar(int numberOfStrings) {
    super("BaseGuitar", numberOfStrings);
  }

  @Override
  String sound() {
    return "Duum-duum-duum";
  }
}
