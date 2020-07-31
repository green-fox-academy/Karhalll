import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {
  public static void main(String[] args) {
    // Create a method that decrypts reversed-lines.txt

    decryptFile("reversed-lines");
  }

  public static void decryptFile(String fileName) {
    try {
      Path filePath = Paths.get("assets/" + fileName + ".txt");
      List<String> encryptedText = Files.readAllLines(filePath);

      Path filePathDecrypted = Paths.get("assets/decrypted-" + fileName + ".txt");
      List<String> decryptedText = new ArrayList<>();

      for (String line : encryptedText) {
        String decryptedLine = "";
        for (int i = line.length() - 1; i >= 0; i--) {
          decryptedLine += line.charAt(i);
        }
        decryptedText.add(decryptedLine);
      }

      Files.write(filePathDecrypted, decryptedText);

    } catch (IOException e) {
      System.out.println("File not found!");
    }
  }
}
