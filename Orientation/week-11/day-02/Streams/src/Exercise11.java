import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise11 {
  public static void main(String[] args) {
    // Find a random Wikipedia article and copy the contents to a txt file.

    // Create a Stream expression which reads all text from this file, and prints the 100 most
    // common words in descending order. Keep in mind that the text contains punctuation characters
    // which should be ignored.

    try {
      Files.lines(Paths.get("src/randomWikiArticle.txt"))
          .flatMap(line -> Arrays.stream(line.replaceAll("[^a-zA-Z ]", "").split(" ")))
          .filter(string -> !string.isEmpty())
          .collect(Collectors.toMap(
              k -> k,
              v -> 1,
              Integer::sum))
          .entrySet().stream()
          .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
          .limit(100)
          .forEach(System.out::println);
    }
    catch (IOException e) {
      System.out.println("Can't read file!");
    }
  }
}
