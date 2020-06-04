import java.util.ArrayList;

public class Unique {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as a parameter
    //  Returns a list of numbers where every number in the list occurs only once

    //  Example
    System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
    //  should print: `[1, 11, 34, 52, 61]`
  }

  public static String unique(int[] numbers) {
    ArrayList<Integer> numbersList = new ArrayList<Integer>();

    for (int number:numbers) {
      numbersList.add(number);
    }

    numbersList.sort(null);

    for (int i = 1; i < numbersList.size(); i++) {
      if (numbersList.get(i) == numbersList.get(i - 1)) {
        numbersList.remove(i);
      }
    }

    return numbersList.toString();
  }
}
