import java.util.Random;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

  public static void mainDraw(Graphics graphics){
    // draw four different size and color rectangles.
    // avoid code duplication.

    for (int i = 0; i < 4; i++) {
      graphics.setColor(randomColor());
      drawRandomRect(i * WIDTH/4, i * HEIGHT/4, graphics);
    }
  }

  public static void drawRandomRect(int x, int y,Graphics graphics) {
    Random random = new Random();
    graphics.drawRect(
        x,
        y,
        10 + random.nextInt(WIDTH/4),
        10 + random.nextInt(HEIGHT/4)
    );
  }

  public static Color randomColor() {
    Random random = new Random();
    int red = random.nextInt(255);
    int green = random.nextInt(255);
    int blue = random.nextInt(255);

    Color randomColor = new Color(red, green, blue);

    return randomColor;
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}