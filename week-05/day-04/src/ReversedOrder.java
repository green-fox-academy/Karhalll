import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {
  public static void main(String[] args) {
    // Create a method that decrypts reversed-order.txt

    decryptFile("reversed-order");
  }

  public static void decryptFile(String fileName) {
    try {
      Path filePath = Paths.get("assets/" + fileName + ".txt");
      List<String> encryptedText = Files.readAllLines(filePath);

      Path filePathDecrypted = Paths.get("assets/decrypted-" + fileName + ".txt");
      List<String> decryptedText = new ArrayList<>();

      for (int i = encryptedText.size() - 1; i >= 0; i--) {
        decryptedText.add(encryptedText.get(i));
      }

      Files.write(filePathDecrypted, decryptedText);

    } catch (IOException e) {
      System.out.println("File not found!");
    }
  }
}
