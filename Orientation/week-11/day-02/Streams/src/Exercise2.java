import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
  public static void main(String[] args) {
    // Write a Stream Expression to get the squared value of the positive number from the following list:
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10 ,14);

    List<Integer> positiveSquared = numbers.stream()
        .filter(i -> i > 0)
        .map(i -> i*i)
        .collect(Collectors.toList());

    System.out.println(positiveSquared);
  }
}
