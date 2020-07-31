package Recursion;

public class Strings {
  public static void main(String[] args) {
    System.out.println(replaceX("asxnakxxnjxnx"));
  }

  private static String replaceX(String string) {
    if (string.length() <= 0) {
      return "";
    } else if (string.charAt(0) == 'x') {
      return string.replace(string.charAt(0), 'y');
    } else {
      return string.charAt(0) + replaceX(string.substring(1));
    }
  }
}
