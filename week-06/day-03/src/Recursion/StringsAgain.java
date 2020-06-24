package Recursion;

public class StringsAgain {
  public static void main(String[] args) {
    System.out.println(removeX("asxjdsxxhdjxhjx"));
  }

  private static String removeX(String string) {
    if (string.length() == 0) {
      return "";
    } else if (string.charAt(0) == 'x') {
      return removeX(string.substring(1));
    } else {
      return string.charAt(0) + removeX(string.substring(1));
    }
  }
}
