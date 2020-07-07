package Anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {
  Anagram anagram = new Anagram();

  @Test
  void isAnagram1() {
    assertTrue(anagram.isAnagram("rail safety", "fairy tales"));
  }

  @Test
  void isAnagram2() {
    assertTrue(anagram.isAnagram("William Shakespeare", "I am a weakish speller"));
  }

  @Test
  void isAnagram3() {
    assertFalse(anagram.isAnagram("roast beef", "eat and BSE"));
  }
}