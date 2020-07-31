import java.util.Scanner;

public class MileToKmConverter {
  public static void main(String[] args) {
    // Write a program that asks for a double that is a distance in miles,
    Scanner scanner = new Scanner(System.in);

    System.out.println("Insert distance in miles (double): ");
    double miles = scanner.nextDouble();

    // then it converts that value to kilometers and prints it
    double milesToKm = miles * 1.609344;
    System.out.println("That is " + milesToKm + " km.");
  }
}