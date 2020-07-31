package PostIt;

import java.awt.Color;

public class Main {
  public static void main(String[] args) {
    PostIt ideaOne = new PostIt(Color.ORANGE, "Idea 1", Color.BLUE);
    PostIt awesome = new PostIt(Color.PINK, "Awesome", Color.BLACK);
    PostIt superb = new PostIt(Color.YELLOW, "Superb!", Color.GREEN);
  }
}
