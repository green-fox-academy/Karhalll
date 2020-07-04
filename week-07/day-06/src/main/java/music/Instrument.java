package main.java.music;

public abstract class Instrument {
  protected String name;

  Instrument(String name) {
    this.name = name;
  }

  abstract void play();
}
