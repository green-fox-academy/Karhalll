package FiveTreesClasses;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Tree> forest = new ArrayList<Tree>() {
      {
        add(new Tree("Oak", new Color(39, 106, 55), 15, 'M'));
        add(new Tree("Maple", new Color(106, 151, 56), 25, 'M'));
        add(new Tree("Birch", new Color(151, 185, 73), 8, 'F'));
        add(new Tree("Pine", new Color(53, 83, 30), 25, 'F'));
        add(new Tree("Spruce", new Color(74, 107, 50), 10, 'F'));
      }
    };
  }
}
