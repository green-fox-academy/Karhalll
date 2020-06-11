import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
  public static void mainDraw(Graphics graphics) {
    // Draw the night sky:
    //  - The background should be black
    //  - The stars can be small squares
    //  - The stars should have random positions on the canvas
    //  - The stars should have random color (some shade of grey)

    int starSize = 2;
    int numberOfStars = 200;

    for (int i = 0; i < numberOfStars; i++) {
      drawRandomPosStar(starSize, graphics);
    }
  }

  public static void drawRandomPosStar(int size, Graphics graphics) {
    int randomX = (int) (Math.random() * WIDTH);
    int randomY = (int) (Math.random() * HEIGHT);

    drawStar(randomX, randomY, size, graphics);
  }

  public static void drawStar(int x, int y, int size, Graphics graphics) {
    graphics.setColor(randomGray());
    graphics.fillRect(x, y, size, size);
  }

  public static Color randomGray() {
    int randomInt = 56 + ((int) (Math.random() * 200));
    Color randomGray = new Color(randomInt, randomInt, randomInt);
    return randomGray;
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    panel.setBackground(Color.BLACK);
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
