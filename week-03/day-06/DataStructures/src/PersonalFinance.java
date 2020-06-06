import java.util.ArrayList;
import java.util.Arrays;

public class PersonalFinance {
  public static void main(String[] args) {
    ArrayList<Integer> expenses = new ArrayList<>(
        Arrays.asList(500, 1000, 1250, 175, 800, 120)
    );

    System.out.println("We spend: " + sum(expenses));
    System.out.println("Our greatest expense is: " + greatest(expenses));
    System.out.println("Our cheapest spending is: " + smallest(expenses));
    System.out.println("The average amount of our spending is: " + average(expenses));
  }

  public static int sum(ArrayList<Integer> arrayList) {
    int sum = 0;
    for (int number:arrayList) {
      sum += number;
    }
    return sum;
  }

  public static int greatest(ArrayList<Integer> arrayList) {
    int greatest = 0;
    for (int number:arrayList) {
      if (number > greatest) {
        greatest = number;
      }
    }
    return greatest;
  }

  public static int smallest(ArrayList<Integer> arrayList) {
    int smallest = Integer.MAX_VALUE;
    for (int number : arrayList) {
      if (number < smallest) {
        smallest = number;
      }
    }
    return smallest;
  }

  public static int average(ArrayList<Integer> arrayList) {
    int sum = sum(arrayList);
    int numbersCount = arrayList.size();

    return sum / numbersCount;
  }
}
