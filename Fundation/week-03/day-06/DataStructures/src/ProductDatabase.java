import java.util.HashMap;

public class ProductDatabase {
  public static void main(String[] args) {
    HashMap<String, Integer> products = new HashMap<String, Integer>() {
      {
        put("Eggs", 200);
        put("Milk", 200);
        put("Fish", 400);
        put("Apples", 150);
        put("Bread", 50);
        put("Chicken", 550);
      }
    };

    System.out.println("Fish costs: " + products.get("Fish"));
    System.out.println("Most expensive product is : " + mostExpensive(products));
    System.out.println("Average price of products is : " + averagePrice(products));
    System.out.println("Products below 300 : " + howManyLowerThen(products, 300));
    System.out.println("There is something with price 125: " + products.containsKey(125));
    System.out.println("Most cheapest product is : " + cheapest(products));
  }

  public static String mostExpensive(HashMap<String, Integer> hashMap) {
    int biggestValue = 0;
    String biggestKey = "";
    for (String key:hashMap.keySet()) {
      if (hashMap.get(key) > biggestValue) {
        biggestValue = hashMap.get(key);
        biggestKey = key;
      }
    }
    return biggestKey;
  }

  public static int averagePrice(HashMap<String, Integer> hashMap) {
    int sum = 0;
    for (String key:hashMap.keySet()) {
      sum += hashMap.get(key);
    }
    return sum / hashMap.size();
  }

  public static int howManyLowerThen(HashMap<String, Integer> hashMap, int targetedValue) {
    int productCount = 0;
    for (int value : hashMap.values()) {
      if (value < targetedValue) {
        productCount++;
      }
    }
    return productCount;
  }

  public static String cheapest(HashMap<String, Integer> hashMap) {
    int smallestValue = Integer.MAX_VALUE;
    String smallestKey = "";
    for (String key:hashMap.keySet()) {
      if (hashMap.get(key) < smallestValue) {
        smallestValue = hashMap.get(key);
        smallestKey = key;
      }
    }
    return smallestKey;
  }
}
