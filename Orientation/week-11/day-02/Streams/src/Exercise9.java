import java.util.Map;
import java.util.stream.Collectors;

public class Exercise9 {
  public static void main(String[] args) {
    // Write a Stream Expression to find the frequency of characters in a given string!
    String string = "Write a Stream Expression to find the frequency of characters in a given string!";

    Map<Character, Integer> frequencies = string.chars().boxed()
        .collect(Collectors.toMap(
            k -> (char) k.intValue(),
            v -> 1,
            Integer::sum));
    System.out.println("Frequencies:\n" + frequencies);
  }
}
