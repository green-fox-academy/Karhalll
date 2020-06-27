package Fractals;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Tree {
  public static void mainDraw(Graphics graphics) {
    graphics.setColor(new Color(247, 211, 51));
    branch(graphics, WIDTH/2, 8*HEIGHT/10, -90, 9);
  }

  private static void branch(Graphics graphics, int x1, int y1, int angle, int level) {
    if (level <= 0) {
      return;
    }

    int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * level * 12.0);
    int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * level * 12.0);
    graphics.drawLine(x1, y1, x2, y2);

    branch(graphics, x2, y2, angle - 25, level - 1);
    branch(graphics, x2, y2, angle, level - 1);
    branch(graphics, x2, y2, angle + 25, level - 1);

  }

  static int WIDTH = 800;
  static int HEIGHT = 800;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Tree");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    panel.setBackground(new Color(12, 49, 63));
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
