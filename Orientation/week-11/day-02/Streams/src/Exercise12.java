import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise12 {
  public static void main(String[] args) {
    //   The swcharacters.csv file contains the list of characters appeared in the Star Wars universe.
    //
    //   "BBY" stands for Before the Battle of Yavin, it's the "year zero" in the Galactic Standard Calendar. For the age calculation let's assume that it's "year zero" and every character lives for the sake of simplicity.

    try {
      List<String[]> characters = Files.lines(Paths.get("src/swcharacters.csv"))
          .skip(1)
          .map(line -> line.split(";"))
          .collect(Collectors.toList());

      //   Create Stream expressions to perform the following exercises:

      //     Print the name of the heaviest character (if the mass is unknown, ignore that character)
      characters
          .stream()
          .filter(ch -> !ch[2].equals("unknown"))
          .sorted((a, b) -> b[2].compareTo(a[2]))
          .limit(1)
          .forEach(ch -> System.out.println(ch[0]));

      //     Print the average height of the male characters
      System.out.println(characters
          .stream()
          .filter(ch ->  ch[7].equals("male") && !ch[1].equals("unknown"))
          .mapToInt(ch -> Integer.parseInt(ch[1]))
          .summaryStatistics()
          .getAverage()
      );

      //     Print the average height of the female characters
      System.out.println(characters
          .stream()
          .filter(ch ->  ch[7].equals("female") && !ch[1].equals("unknown"))
          .mapToInt(ch -> Integer.parseInt(ch[1]))
          .summaryStatistics()
          .getAverage()
      );

      //     Get the age distribution of the characters by gender (where the gender can be "male", "female" and "other")
      //       The age groups are: "below 21", "between 21 and 40", "above 40" and "unknown"
      //       The result should be a Map<String, Map<String, Integer>>

    } catch (IOException e) {
      System.out.println("Can't read file!");
    }


  }
}
