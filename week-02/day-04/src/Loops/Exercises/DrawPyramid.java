import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
    // pyramid like this:
    //
    //
    //    *
    //   ***
    //  *****
    // *******
    //
    // The pyramid should have as many lines as the number was

    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert integer: ");
    int number = scanner.nextInt();

    for (int i = 1; i <= number; i++) {
      String whiteSpaces = "";
      for ( int j = 1; j <= (number - i); j++) {
        whiteSpaces += " ";
      }

      String stars = "";
      for (int j = 1; j < i; j++) {
        stars += "*";
      }

      System.out.println(whiteSpaces + stars + "*" + stars + whiteSpaces);
    }
  }
}
