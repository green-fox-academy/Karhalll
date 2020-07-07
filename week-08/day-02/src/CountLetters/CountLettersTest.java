package CountLetters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class CountLettersTest {

  @Test
  void countLetters() {
    CountLetters countLetters = new CountLetters();
    HashMap<String, Integer> lettersCounted = new HashMap<String, Integer>() {
      {
        put("a", 1);
        put("p", 2);
        put("l", 1);
        put("e", 1);
      }
    };
    assertEquals(lettersCounted, countLetters.countLetters("apple"));
  }
}