import java.util.Arrays;
import java.util.List;

public class AppendLetter {
  public static void main(String... args) {
    List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
    // Create a method called "appendA()" that adds "a" to every string in the "far" list.
    // The parameter should be a list.

    System.out.println(appendA(far));
  }

  public static String appendA(List<String> list) {
    for (int i = 0; i < list.size(); i++) {
      String newString = list.get(i) + 'a';
      list.set(i, newString);
    }

    return list.toString();
  }
}

// The output should be: "boa", "anaconda", "koala", "panda", "zebra"