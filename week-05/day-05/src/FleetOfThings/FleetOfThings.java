package FleetOfThings;

public class FleetOfThings {

  public static void main(String[] args) {
    Fleet fleet = new Fleet();
    // - You have the `Thing` class
    // - You have the `Fleet` class
    // - You have the `FleetOfThings` class with a `main` method
    // - Download those, use those
    // - In the main method create a fleet
    // - Achieve this output:
    // Create a fleet of things to have this output:
    // 1. [ ] Get milk
    fleet.add(new Thing("Get milk"));

    // 2. [ ] Remove the obstacles
    fleet.add(new Thing("Remove the obstacles"));

    // 3. [x] Stand up
    Thing standUp = new Thing("Stand up");
    standUp.complete();
    fleet.add(standUp);

    // 4. [x] Eat lunch
    Thing eatLunch = new Thing("Eat lunch");
    eatLunch.complete();
    fleet.add(eatLunch);

    System.out.println(fleet);
  }
}