package Fractals;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochSnowflake {
  public static void mainDraw(Graphics graphics) {
    kochLine(graphics, WIDTH/2, 20, WIDTH-20, 2*HEIGHT/3, 4);
    kochLine(graphics, WIDTH-20, 2*HEIGHT/3, 20, 2*HEIGHT/3, 4);
    kochLine(graphics, 20, 2*HEIGHT/3, WIDTH/2, 20, 4);
  }

  private static void kochLine(Graphics graphics, int x1, int y1, int x5, int y5, int level) {
    if (level <= 0) {
      graphics.drawLine(x1, y1, x5, y5);
      return;
    }

    int deltaX = x5 - x1;
    int deltaY = y5 - y1;

    int x2 = x1 + deltaX/3;
    int y2 = y1 + deltaY/3;

    int x3 = (int) ((x1+x5)/2 - Math.sqrt(3)*(y1-y5)/6);
    int y3 = (int) ((y1+y5)/2 - Math.sqrt(3)*(x5-x1)/6);

    int x4 = x5 - deltaX/3;
    int y4 = y5 - deltaY/3;

    kochLine(graphics, x1, y1, x2, y2, level - 1);
    kochLine(graphics, x2, y2, x3, y3, level - 1);
    kochLine(graphics, x3, y3, x4, y4, level - 1);
    kochLine(graphics, x4, y4, x5, y5, level - 1);
  }

  static int WIDTH = 800;
  static int HEIGHT = 800;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("KochSnowflake");
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
