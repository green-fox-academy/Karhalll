import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise8 {
  public static void main(String[] args) {
    List<Character> chars = Arrays.asList('a', 'h', 'o', 'j');

    String string = chars.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());

    System.out.println(string);
  }
}