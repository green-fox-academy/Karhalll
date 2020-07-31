import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {
  public static void main(String[] args) {
    // Read all data from 'log.txt'.
    // Each line represents a log message from a web server
    // Write a function that returns an array with the unique IP addresses.
    // Write a function that returns the GET / POST request ratio.

    List<String> log = null;

    try {
      Path filePath = Paths.get("assets/log.txt");
      log = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Can not read file!");
    }

    getAllUniqueIP(log);
    System.out.println("GET/POST ratio is: " + getGETPOSTRatio(log));
  }

  public static String[] getAllUniqueIP(List<String> log) {
    if (log == null) {
      System.out.println("From getAllUniqueIP(): Log not found!");
      return null;
    }

    List<String> uniqueIPs = new ArrayList<>();

    for (String line : log) {
      String ipAddress = line.substring(27, 38);
      if (!uniqueIPs.contains(ipAddress)) {
        uniqueIPs.add(ipAddress);
        System.out.println(ipAddress);
      }
    }

    String[] arrayOfIPs = new String[uniqueIPs.size()];
    uniqueIPs.toArray(arrayOfIPs);
    return arrayOfIPs;
  }

  public static float getGETPOSTRatio(List<String> log) {
    if (log == null) { return -1; }

    float get = 0;
    float post = 0;

    List<String> uniqueIPs = new ArrayList<>();

    for (String line : log) {
      if (line.charAt(41) == 'G') {
        get++;
      } else if (line.charAt(41) == 'P') {
        post++;
      }
    }

    return get / post;
  }
}
