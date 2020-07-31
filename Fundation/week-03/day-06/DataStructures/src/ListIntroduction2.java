import java.util.ArrayList;
import java.util.Arrays;

public class ListIntroduction2 {
  public static void main(String[] args) {
    ArrayList<String> listA = new ArrayList<>(
        Arrays.asList(
            "Apple",
            "Avocado",
            "Blueberries",
            "Durian",
            "Lychee")
    );

    ArrayList<String> listB = new ArrayList<>(listA);

    System.out.println("List A contains Durian: " + listA.contains("Durian"));

    listB.remove("Durian");
    listA.add(3, "Kiwifruit");

    System.out.println("List A size: " + listA.size());
    System.out.println("List B size: " + listB.size());

    System.out.println("Index of Avocado in List A is: " + listA.indexOf("Avocado"));
    System.out.println("Index of Durian in List B is: " + listB.indexOf("Durian"));

    listB.addAll(Arrays.asList("Passion Fruit", "Pomelo"));

    System.out.println(listA.get(2));
  }
}
