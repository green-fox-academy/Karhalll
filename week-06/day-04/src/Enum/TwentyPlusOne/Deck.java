package Enum.TwentyPlusOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
  List<Card> deck = new ArrayList<>();

  public Deck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card newCard = new Card();
        if (suit == Suit.clubs || suit == Suit.spades) {
          newCard.color = Color.red;
        } else {
          newCard.color = Color.black;
        }
        newCard.rank = rank;
        newCard.suit = suit;
        deck.add(newCard);
      }
    }
  }

  public void shuffleDeck() {
    List<Card> shuffledDeck = new ArrayList<>();

    Random random = new Random();
    while (deck.size() > 0) {
      int randomIndex = random.nextInt(deck.size());
      shuffledDeck.add(deck.remove(randomIndex));
    }
    deck = shuffledDeck;
  }

  public Card pullFirst() {
    return deck.get(0);
  }

  public Card pullLast() {
    return deck.get(deck.size() - 1);
  }

  public void removeCard(Card card) {
      deck.remove(card);
  }

  public Card pullRandom() {
    Random random = new Random();
    int randomIndex = random.nextInt(deck.size());
    return deck.get(randomIndex);
  }

  public void PrintDeck() {
    for (Card card : deck) {
      System.out.println(card.CardFace());
    }
  }
}
