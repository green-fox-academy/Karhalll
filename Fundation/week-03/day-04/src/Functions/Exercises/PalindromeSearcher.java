import java.util.ArrayList;

public class PalindromeSearcher {
  public static void main(String[] args) {
    System.out.println(palindromeSearcher("dog goat dad duck doodle never"));
    System.out.println(palindromeSearcher("apple"));
    System.out.println(palindromeSearcher("racecar"));
    System.out.println(palindromeSearcher(""));
  }

  public static String palindromeSearcher(String string) {
    ArrayList<String> palindromes = new ArrayList<String>();
    for (int i = 0; i < string.length(); i++) {
      for (int j = i + 3; j <= string.length(); j++) {
        if (isPalindrome(string.substring(i, j))) {
          palindromes.add(string.substring(i, j));
        }
      }
    }
    return palindromes.toString();
  }

  public static boolean isPalindrome(String input) {
    StringBuilder plain = new StringBuilder(input);
    StringBuilder reverse = plain.reverse();
    return (reverse.toString()).equals(input);
  }
}
