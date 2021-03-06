import java.util.Scanner;

public class DrawDiagonal {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
    // square like this:
    //
    //
    // %%%%%
    // %%  %
    // % % %
    // %  %%
    // %%%%%
    //
    // The square should have as many lines as the number was

    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert positive integer: ");
    int number = scanner.nextInt();

    if (number > 1) {

      String percentSigns = "";

      // Upper side of the square
      for (int i = 0; i < number; i++) {
        percentSigns += "%";
      }
      System.out.println(percentSigns);

      // Square content
      for (int i = 0; i < number - 2; i++) {
        String whiteSpaces = "";
        for (int j = 0; j < i; j++) {
          whiteSpaces += " ";
        }

        String whiteSpacesRev = "";
        for (int j = number - 3 - i; j > 0; j--) {
          whiteSpacesRev += " ";
        }
        System.out.println("%" + whiteSpaces + "%" + whiteSpacesRev + "%");
      }

      // Downer side of the square
      percentSigns = "";
      for (int i = 0; i < number; i++) {
        percentSigns += "%";
      }
      System.out.println(percentSigns);


    } else if (number == 1) {
      System.out.println("%");
    } else {
      System.out.println("I said POSITIVE!");
    }
  }
}
