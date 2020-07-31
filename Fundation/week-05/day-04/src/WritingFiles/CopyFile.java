package WritingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
  public static void main(String[] args) {
    // Write a function that copies the contents of a file into another
    // It should take the filenames as parameters
    // It should return a boolean that shows if the copy was successful

    System.out.println(copyFile("FileToCopy", "TargetFile"));
  }

  public static boolean copyFile(String fileToCopy, String targetFile) {
    try {
      Path fileToCopyPath = Paths.get("assets/" + fileToCopy + ".txt");
      Path targetFilePath = Paths.get("assets/" + targetFile + ".txt");

      List<String> linesToCopy = Files.readAllLines(fileToCopyPath);
      Files.write(targetFilePath, linesToCopy);

      return true;
    } catch (IOException e) {
      System.out.println("Unable to access files");
      return false;
    }
  }
}
