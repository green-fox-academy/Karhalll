import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {
  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt

    decryptFile("duplicated-chars");
  }

  public static void decryptFile(String fileName) {
    try {
      Path filePath = Paths.get("assets/" + fileName + ".txt");
      List<String> encryptedText = Files.readAllLines(filePath);

      Path filePathDecrypted = Paths.get("assets/decrypted-duplicated-chars.txt");
      List<String> decryptedText = new ArrayList<>();

      for (String line : encryptedText) {
        String decryptedLine = "";
        for (int i = 0; i < line.length(); i++) {
          if (i % 2 == 0) {
            decryptedLine += line.charAt(i);
          }
        }
        decryptedText.add(decryptedLine);
      }

      Files.write(filePathDecrypted, decryptedText);

    } catch (IOException e) {
      System.out.println("File not found!");
    }
  }
}
