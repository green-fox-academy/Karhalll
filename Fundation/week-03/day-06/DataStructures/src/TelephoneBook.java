import java.util.HashMap;

public class TelephoneBook {
  public static void main(String[] args) {
    HashMap<String, String> telephoneBook = new HashMap<String, String>() {
      {
        put("William A. Lathan", "405-709-1865");
        put("John K. Miller", "402-247-8568");
        put("Hortensia E. Foster", "606-481-6467");
        put("Amanda D. Newland", "319-243-5613");
        put("Brooke P. Askew", "307-687-2982");
      }
    };

    System.out.println("John K. Miller's phone number is: "
        + telephoneBook.get("John K. Miller"));
    System.out.println("Phone number 307-687-2982 is: "
        + getKeyByValue(telephoneBook, "307-687-2982") + "'s");
    System.out.println("Do we know Chris E. Myers' phone number: "
        + telephoneBook.containsKey("Chris E. Myer"));
  }

  public static String getKeyByValue(HashMap<String, String> hashMap, String value) {
    String keyString = "";
    for (String key:hashMap.keySet()) {
      if (hashMap.get(key).equals(value)) {
        keyString = key;
        break;
      }
    }
    return keyString;
  }
}
