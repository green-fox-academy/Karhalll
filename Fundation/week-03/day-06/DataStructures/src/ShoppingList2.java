import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingList2 {
  public static void main(String[] args) {
    HashMap<String, Float> products = new HashMap<String, Float>() {
      {
        put("Milk", 1.07f);
        put("Rice", 1.59f);
        put("Eggs", 3.14f);
        put("Cheese", 12.60f);
        put("Chicken Breasts", 9.40f);
        put("Apples", 2.31f);
        put("Tomato", 2.58f);
        put("Potato", 1.75f);
        put("Onion", 1.10f);
      }
    };

    HashMap<String, Integer> bobsList = new HashMap<String, Integer>() {
      {
        put("Milk", 3);
        put("Rice", 2);
        put("Eggs", 2);
        put("Cheese", 1);
        put("Chicken Breasts", 4);
        put("Apples", 1);
        put("Tomato", 2);
        put("Potato", 1);
      }
    };

    HashMap<String, Integer> alicesList = new HashMap<String, Integer>() {
      {
        put("Rice", 1);
        put("Eggs", 5);
        put("Chicken Breasts", 2);
        put("Apples", 1);
        put("Tomato", 10);
      }
    };

    System.out.println("Bob pays: " + sum(products, bobsList));
    System.out.println("Alice pays: " + sum(products, alicesList));
    System.out.println(whoMore(bobsList, alicesList, "Rice") + " buys more Rice.");
    System.out.println(whoMore(bobsList, alicesList, "Potato") + " buys more Potato.");
    System.out.println(moreDifferent(bobsList, alicesList) + " buys more different products");
    System.out.println(moreProducts(bobsList, alicesList) + " buys more pieces of products");
  }

  public static float sum(HashMap<String, Float> products, HashMap<String, Integer> shoppingList) {
    float sum = 0;
    for (String key:shoppingList.keySet()) {
      sum += shoppingList.get(key) * products.get(key);
    }
    return sum;
  }

  public static String whoMore(HashMap<String, Integer> shoppingList1,
                                HashMap<String, Integer> shoppingList2,
                                String product) {

    int fistAmount = amountOf(shoppingList1, product);
    int secondAmount = amountOf(shoppingList2, product);

    if (fistAmount > secondAmount) {
      return "Bob";
    } else {
      return "Alice";
    }
  }

  public static int amountOf(HashMap<String, Integer> shoppingList, String product) {
    if (shoppingList.get(product) != null) {
      return shoppingList.get(product);
    } else {
      return 0;
    }
  }

  public static String moreDifferent(HashMap<String, Integer> shoppingList1,
                                     HashMap<String, Integer> shoppingList2) {

    if (shoppingList1.size() > shoppingList2.size()) {
      return "Bob";
    } else {
      return "Alice";
    }
  }

  public static String moreProducts(HashMap<String, Integer> shoppingList1,
                                     HashMap<String, Integer> shoppingList2) {

    if (productCount(shoppingList1) > productCount(shoppingList2)) {
      return "Bob";
    } else {
      return "Alice";
    }
  }

  public static int productCount(HashMap<String, Integer> hashMap) {
    int sum = 0;
    for (int number:hashMap.values()) {
      sum += number;
    }
    return sum;
  }
}
