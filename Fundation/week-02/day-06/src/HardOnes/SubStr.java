import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubStr {
  public static void main(String[] args) {
    //  Create a function that takes two strings as a parameter
    //  Returns the starting index where the second one is starting in the first one
    //  Returns `-1` if the second string is not in the first one

    //  Example:

    //  should print: `17`
    System.out.println(subStr("this is what I'm searching in", "searching"));

    //  should print: `-1`
    System.out.println(subStr("this is what I'm searching in", "not"));

    System.out.println(subStr("Bla bla bla bla bla glum bla bla bla bla", "glum"));
  }

  public static int subStr(String input, String q) {
    Pattern pattern = Pattern.compile(q);
    Matcher matcher = pattern.matcher(input);

    if (matcher.find()) {
      return matcher.start();
    } else {
      return -1;
    }
  }
}
