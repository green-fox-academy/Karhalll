package Recursion;

public class StringAgainAndAgain {
  public static void main(String[] args) {
    System.out.println(separateWithStar("hjaksd"));
  }

  private static String separateWithStar(String string) {
    if (string.length() <= 0) {
      return "";
    } else if (string.length() == 1) {
      return string.charAt(0) + "";
    } else {
      return string.charAt(0) + "*" + separateWithStar(string.substring(1));
    }
  }
}
