import java.util.ArrayList;
import java.util.Arrays;

public class Matchmaking {
  public static void main(String... args) {
    ArrayList<String>
        girls = new ArrayList<String>(Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
    ArrayList<String> boys = new ArrayList<String>(
        Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));

    // Write a method that joins the two lists by matching one girl with one boy into a new list
    // If someone has no pair, he/she should be the element of the list too
    // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

    System.out.println(makingMatches(girls, boys));
  }

  public static String makingMatches(ArrayList<String> girls, ArrayList<String> boys) {
    ArrayList<String> matches = new ArrayList<>();

    int girlsMaxIndex = girls.size() - 1;
    int boysMaxIndex = boys.size() - 1;
    int i = 0;
    while (girlsMaxIndex >= i || boysMaxIndex >= i) {
      if (girlsMaxIndex >= i) {
        matches.add(girls.get(i));
      }
      if (boysMaxIndex >= i) {
        matches.add(boys.get(i));
      }
      i++;
    }

    return matches.toString();
  }
}