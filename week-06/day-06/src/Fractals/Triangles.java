package Fractals;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  public static void mainDraw(Graphics graphics) {

    int[] positionsX = {0, WIDTH, WIDTH/2};
    int[] positionsY = {0, 0, HEIGHT};

    graphics.drawPolygon(positionsX, positionsY, 3);

    drawTriangle(graphics, HEIGHT/2, WIDTH/2, HEIGHT/2, 5);
  }

  private static void drawTriangle(Graphics graphics, int height, int posX, int posY, int level) {
    if (level < 0) {
      return;
    }

    int halfSide = (int) Math.round(height / Math.sqrt(3));

    int[] positionsX = {posX, posX + halfSide, posX - halfSide};
    int[] positionsY = {posY - height, posY, posY};

    graphics.drawPolygon(positionsX, positionsY, 3);

    drawTriangle(graphics, height/2, posX + halfSide, posY - height/2, level - 1);
    drawTriangle(graphics, height/2, posX, posY + height/2, level - 1);
    drawTriangle(graphics, height/2, posX - halfSide, posY - height/2, level - 1);
  }

  static int WIDTH = 369;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Triangles");
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
