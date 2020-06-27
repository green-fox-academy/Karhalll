package Fractals;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {
  public static void mainDraw(Graphics graphics) {
    graphics.setColor(Color.BLACK);
    drawHexagon(graphics, WIDTH/2, WIDTH/4, 0, 5);
  }

  private static void drawHexagon(
      Graphics graphics, int side, int posX, int posY, int level) {
    if (level <= 0) {
      return;
    }

    int v = (int) (Math.sqrt(3)*side/2);


    int[] positionsX = new int[6];
    int[] positionsY = new int[6];

    positionsX[0] = posX;
    positionsY[0] = posY;

    for (int i = 0; i < 5; i++) {
      positionsX[i+1] = positionsX[i] + (int)(Math.cos(Math.toRadians(i*60))*side);
      positionsY[i+1] = positionsY[i] + (int)(Math.sin(Math.toRadians(i*60))*side);
    }

    graphics.drawPolygon(positionsX, positionsY, 6);

    drawHexagon(graphics, side/3, posX, posY, level - 1);
    drawHexagon(graphics, side/3, posX + 2*side/3, posY, level - 1);

    drawHexagon(graphics, side/3, posX + side, posY + 2*v/3, level - 1);

    drawHexagon(graphics, side/3, posX, posY + 4*v/3, level - 1);
    drawHexagon(graphics, side/3, posX + 2*side/3, posY + 4*v/3, level - 1);

    drawHexagon(graphics, side/3, posX - 1*side/3, posY + 2*v/3, level - 1);
  }

  static int WIDTH = 600;
  static int HEIGHT = (int) (Math.sqrt(3)*WIDTH/2);

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Hexagon");
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
