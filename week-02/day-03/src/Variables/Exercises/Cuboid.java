public class Cuboid {
  public static void main(String[] args) {
    // Write a program that stores 3 sides of a cuboid as variables (doubles)
    double a = 20;
    double b = 45;
    double c = 59;

    // The program should write the surface area and volume of the cuboid like:
    //
    // Surface Area: 600
    // Volume: 1000

    double surface = 2 * ((a * b) + (b * c) + (a * c));
    System.out.println("Surface Area: " + surface);

    double volume = a * b * c;
    System.out.println("Volume: " + volume);
  }
}
