package Fractals;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {
  public static void mainDraw(Graphics graphics) {

    drawCircles(graphics, HEIGHT, 0, 0, 5);
  }

  private static void drawCircles(Graphics graphics, int diameter, int posX, int posY, int level) {
    if (level <= 0) {
      return;
    }

    graphics.drawOval(posX, posY, diameter, diameter);

    drawCircles(graphics, diameter/2, posX + diameter/4, posY, level - 1);

    int a = (int) Math.round((diameter/2f) * Math.sqrt(3) / 2);
    int v = Math.round((diameter/4f) * 3 / 2);

    drawCircles(graphics, diameter/2, posX + diameter/4, posY, level - 1);
    drawCircles(graphics, diameter/2, posX + diameter/4 + a/2, posY + v, level - 1);
    drawCircles(graphics, diameter/2, posX + diameter/4 - a/2, posY + v, level - 1);
  }

  static int WIDTH = 640;
  static int HEIGHT = 640;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Circles");
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
