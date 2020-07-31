import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class DoableHomework {
  List<String> types = new ArrayList<String>() {
    {
      add("Oak");
      add("Maple");
      add("Birch");
      add("Pine");
      add("Spruce");
    }
  };

  List<Color> colors = new ArrayList<Color>() {
    {
      add(new Color(39, 106, 55));
      add(new Color(106, 151, 56));
      add(new Color(151, 185, 73));
      add(new Color(53, 83, 30));
      add(new Color(74, 107, 50));
    }
  };

  List<Integer> ages = new ArrayList<Integer>() {
    {
      add(15);
      add(25);
      add(8);
      add(25);
      add(10);
    }
  };

  List<Character> sexes = new ArrayList<Character>() {
    {
      add('M');
      add('M');
      add('F');
      add('F');
      add('F');
    }
  };
}
