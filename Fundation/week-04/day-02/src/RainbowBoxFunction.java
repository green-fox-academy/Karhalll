import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
  public static void mainDraw(Graphics graphics) {
    // Create a square drawing function that takes 3 parameters:
    // The square size, the fill color, graphics
    // and draws a square of that size and color to the center of the canvas.
    // Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).
    int rainbowStripes = 8;
    for (int i = rainbowStripes - 1; i >= 0; i--) {
      Color color = new Color(
          Color.HSBtoRGB((float) i/rainbowStripes, 1f, 1f));
      /*switch (i) {
        case 0:
          color = Color.RED;
          break;
        case 1:
          color = Color.ORANGE;
          break;
        case 2:
          color = Color.YELLOW;
          break;
        case 3:
          color = Color.GREEN;
          break;
        case 4:
          color = Color.BLUE;
          break;
        case 5:
          color = new Color(55, 7, 95);
          break;
        case 6:
          color = new Color(139, 0, 255);
          break;
      }*/

      drawSquare(WIDTH/rainbowStripes + i*(WIDTH/rainbowStripes), color, graphics);
    }
  }

  public static void drawSquare(int size, Color color, Graphics graphics) {
    graphics.setColor(color);
    graphics.fillRect((WIDTH - size)/2, (HEIGHT - size)/2, size, size);
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