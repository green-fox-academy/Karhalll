import java.util.HashMap;

public class ProductDatabase2 {
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

    System.out.println("Products that cost less then 201: "
        + getAllLessThen(products, 201)
    );
    System.out.println("Products that cost more then 150: "
        + getAllMoreThen(products, 150)
    );
  }

  public static String getAllLessThen(HashMap<String, Integer> hashMap, int targetedValue) {
    String cheaperProducts = "";
    for (String key : hashMap.keySet()) {
      if (hashMap.get(key) < targetedValue) {
        cheaperProducts += key + " ";
      }
    }
    return cheaperProducts;
  }

  public static String getAllMoreThen(HashMap<String, Integer> hashMap, int targetedValue) {
    String output = "\n";
    for (String key : hashMap.keySet()) {
      if (hashMap.get(key) > targetedValue) {
        output += "\t\t\t\t\t\t\t\t\t" + key + " " + hashMap.get(key) + "\n";
      }
    }
    return output;
  }
}
