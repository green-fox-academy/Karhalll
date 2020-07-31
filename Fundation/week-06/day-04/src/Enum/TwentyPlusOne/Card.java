package Enum.TwentyPlusOne;

public class Card {
  Color color;
  Suit suit;
  Rank rank;

  public String CardFace() {
    return rank + " of " + suit;
  }
}
