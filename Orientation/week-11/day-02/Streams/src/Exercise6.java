import java.util.ArrayDeque;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exercise6 {
  public static void main(String[] args) {
    // Write a Stream Expression to find the uppercase characters in a string!

    String string = "Hello World! I have 3 uppercase characters in me.";

    string.chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isUpperCase)
        .forEach(System.out::println);
  }
}
