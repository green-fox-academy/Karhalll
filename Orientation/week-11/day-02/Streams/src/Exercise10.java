import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise10 {
  public static void main(String[] args) {
    // Create a Fox class with 3 properties:name, color and age Fill a list with at least 5 foxes and:

    List<Fox> foxes = Arrays.asList(
        new Fox("Bistrouska", Color.green, 2),
        new Fox("Usajda", Color.black, 3),
        new Fox("Zrzavice", Color.red, 12),
        new Fox("Klarka", Color.green, 15),
        new Fox("Dasenka", Color.GRAY, 7)
    );

    // Write a Stream Expression to find the foxes with green color!
    foxes.stream()
        .filter(fox -> fox.color == Color.green)
        .forEach(fox -> System.out.println(fox.name));

    // Write a Stream Expression to find the foxes with green color, and age less then 5 years!
    foxes.stream()
        .filter(fox -> fox.color == Color.green && fox.age < 5)
        .forEach(fox -> System.out.println(fox.name));

    // Write a Stream Expression to find the frequency of foxes by color!
    Map<Color, Integer> frequencies = foxes.stream()
        .collect(Collectors.toMap(
            k -> k.color,
            v -> 1,
            Integer::sum));
    System.out.println(frequencies);
  }
}
