import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class WriteSingleLine {
  public static void main(String[] args) {
    // Write a function that is able to manipulate a file
    // By writing your name into it as a single line
    // The file should be named "my-file.txt"
    // In case the program is unable to write the file,
    // It should print the following error message: "Unable to write file: my-file.txt"
    writingSingleLine("Martin Fučík");
  }

  public static void writingSingleLine(String line) {
    try {
      Path filePath = Paths.get("assets/my-file.txt");
      ArrayList<String> input = new ArrayList<>();
      input.add(line);
      Files.write(filePath, input);
    } catch (IOException e) {
      System.out.println("Unable to write file: my-file.txt");
    }
  }
}
