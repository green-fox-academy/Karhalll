public class Anagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("dog", "god"));
    System.out.println(isAnagram("green", "fox"));
  }

  public static boolean isAnagram(String firstWord, String secondWord) {

    String secondReversed = "";
    for (int i = secondWord.length() - 1; i >= 0; i--) {
      secondReversed += secondWord.charAt(i);
    }

    if (firstWord.equals(secondReversed)) {
      return true;
    } else {
      return false;
    }
  }
}
