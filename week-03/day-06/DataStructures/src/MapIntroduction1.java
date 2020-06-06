import java.util.HashMap;

public class MapIntroduction1 {
  public static void main(String[] args) {
    HashMap<Integer, Character> map = new HashMap<>();

    System.out.println("Is map empty: " + map.isEmpty());

    map.put(97, 'a');
    map.put(98, 'b');
    map.put(99, 'c');
    map.put(65, 'A');
    map.put(66, 'B');
    map.put(67, 'C');

    for (int key:map.keySet()) {
      System.out.println(key);
    }

    for (char val:map.values()) {
      System.out.println(val);
    }

    map.put(68, 'D');

    System.out.println(map.size());

    System.out.println(map.get(99));

    System.out.println(map.remove(97));

    System.out.println("Is there a value for key 100: " + (map.get(100) != null));

    map.clear();
  }
}
