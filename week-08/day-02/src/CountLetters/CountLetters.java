package CountLetters;

import java.util.HashMap;

public class CountLetters {
  public HashMap<String, Integer> countLetters(String string) {
    HashMap<String, Integer> lettersCounted = new HashMap<>();
    for (char letter : string.toCharArray()) {
      if (!lettersCounted.containsKey(Character.toString(letter))) {
        lettersCounted.put(Character.toString(letter), 1);
      } else {
        lettersCounted.replace(Character.toString(letter),
            lettersCounted.get(Character.toString(letter))+1);
      }
    }
    return lettersCounted;
  }
}
