package Sharpie;

public class Sharpie {
  String color;
  float width;
  float inkAmount = 100f;

  public Sharpie(String color, float width) {
    this.color = color;
    this.width = width;
  }

  public void use(float inkAmount) {
    this.inkAmount -= inkAmount;
  }
}
