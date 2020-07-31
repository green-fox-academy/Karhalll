public class Palindrome {
  public static void main(String[] args) {
    System.out.println(palindromeBuilder("word"));
  }

  public static String palindromeBuilder(String word) {
    String palindrome = word;

    for (int i = word.length() - 1; i >= 0; i--) {
      palindrome += word.charAt(i);
    }
    return palindrome;
  }
}
