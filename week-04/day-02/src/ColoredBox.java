import java.util.HashMap;
import java.util.Random;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
  public static void mainDraw(Graphics graphics) {
    // Draw a box that has different colored lines on each edge.
    graphics.setColor(randomColor());
    graphics.drawLine(WIDTH/4, HEIGHT/4, 3*WIDTH/4, HEIGHT/4);
    graphics.setColor(randomColor());
    graphics.drawLine(WIDTH/4, HEIGHT/4, WIDTH/4, 3*HEIGHT/4);
    graphics.setColor(randomColor());
    graphics.drawLine(3*WIDTH/4, 3*HEIGHT/4, 3*WIDTH/4, HEIGHT/4);
    graphics.setColor(randomColor());
    graphics.drawLine(3*WIDTH/4, 3*HEIGHT/4, WIDTH/4, 3*HEIGHT/4);

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
