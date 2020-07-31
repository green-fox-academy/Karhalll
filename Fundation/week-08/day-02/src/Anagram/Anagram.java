package Anagram;

import java.util.Arrays;

public class Anagram {
  public boolean isAnagram(String first, String second) {
    String s1 = first.replaceAll("\\s", "");
    String s2 = second.replaceAll("\\s", "");
    if (s1.length() != s2.length()) {
      return false;
    } else {
      char[] ArrayS1 = s1.toLowerCase().toCharArray();
      char[] ArrayS2 = s2.toLowerCase().toCharArray();
      Arrays.sort(ArrayS1);
      Arrays.sort(ArrayS2);
      return Arrays.equals(ArrayS1, ArrayS2);
    }
  }
}
