import java.util.Scanner;

public class DrawDiamond {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
    // diamond like this:
    //
    //
    //    *
    //   ***
    //  *****
    // *******
    //  *****
    //   ***
    //    *
    //
    // The diamond should have as many lines as the number was

    Scanner scanner = new Scanner(System.in);
    System.out.println("Insert ODD integer: ");
    int number = scanner.nextInt();

    if (number % 2 == 0) {
      System.out.println("I said ODD integer!");
    } else {
      int half = number / 2;
      for (int i = 0; i < number; i++) {

        String whiteSpaces = "";
        String stars = "";

        if (i <= half) {
          for (int j = 0; j < (half - i); j++) {
            whiteSpaces += " ";
          }
          for (int j = 0; j < i; j++) {
            stars += "*";
          }
        } else {
          for (int j = i - half; j > 0; j--) {
            whiteSpaces += " ";
          }
          for (int j = number - i; j > 1; j--) {
            stars += "*";
          }
        }

        System.out.println(whiteSpaces + stars + "*" + stars);
      }
    }
  }
}
