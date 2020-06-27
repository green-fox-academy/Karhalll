package Fractals;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskyCarpet {
  public static void mainDraw(Graphics graphics) {
    graphics.setColor(Color.BLACK);
    drawSquareGrid(graphics, HEIGHT/3, WIDTH/3, HEIGHT/3, 5);
  }

  private static void drawSquareGrid(
      Graphics graphics, int side, int posX, int posY, int level) {
    if (level <= 0) {
      return;
    }
    graphics.fillRect(posX, posY, side, side);

    drawSquareGrid(graphics, side/3, posX - 2*side/3, posY - 2*side/3, level - 1);
    drawSquareGrid(graphics, side/3, posX + side/3, posY - 2*side/3, level - 1);
    drawSquareGrid(graphics, side/3, posX + 4*side/3, posY - 2*side/3, level - 1);

    drawSquareGrid(graphics, side/3, posX - 2*side/3, posY + side/3, level - 1);
    drawSquareGrid(graphics, side/3, posX + 4*side/3, posY + side/3, level - 1);

    drawSquareGrid(graphics, side/3, posX - 2*side/3, posY + 4*side/3, level - 1);
    drawSquareGrid(graphics, side/3, posX + side/3, posY + 4*side/3, level - 1);
    drawSquareGrid(graphics, side/3, posX + 4*side/3, posY + 4*side/3, level - 1);

  }

  static int WIDTH = 600;
  static int HEIGHT = 600;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("SierpinskyCarpet");
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
