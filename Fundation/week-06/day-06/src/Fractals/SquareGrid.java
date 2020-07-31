package Fractals;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquareGrid {
  public static void mainDraw(Graphics graphics) {

    Graphics2D graphics2D = (Graphics2D) graphics;
    drawSquareGrid(graphics2D, HEIGHT/2, WIDTH/4, HEIGHT/4, 4, 20);
  }

  private static void drawSquareGrid(
      Graphics2D graphics, int side, int posX, int posY, int level, int stroke) {
    if (level <= 0) {
      return;
    }

    graphics.setStroke(new BasicStroke(stroke));
    graphics.drawRect(posX, posY, side, side);

    drawSquareGrid(graphics, side/2, posX - side/4, posY - side/4, level - 1, stroke/2);
    drawSquareGrid(graphics, side/2, posX + 3*side/4, posY - side/4, level - 1, stroke/2);
    drawSquareGrid(graphics, side/2, posX - side/4, posY + 3*side/4, level - 1, stroke/2);
    drawSquareGrid(graphics, side/2, posX + 3*side/4, posY + 3*side/4, level - 1, stroke/2);
  }

  static int WIDTH = 640;
  static int HEIGHT = 640;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("SquareGrid");
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
