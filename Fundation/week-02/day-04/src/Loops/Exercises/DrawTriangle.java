import java.util.Scanner;

public class DrawTriangle {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
    // triangle like this:
    //
    // *
    // **
    // ***
    // ****
    //
    // The triangle should have as many lines as the number was

    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert integer: ");
    int number = scanner.nextInt();

    for (int i = 1; i <= number; i++) {
      String out = "";
      for (int j = 1; j <= i; j++) {
        out += "*";
      }

      System.out.println(out);
    }
  }
}
