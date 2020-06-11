import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {

  public static void mainDraw(Graphics graphics) {

    int dimension = 7;

    int twiceV = HEIGHT / (dimension + 1);
    int v = twiceV/2;

    int side = (int) (v * 2d / Math.sqrt(3d));

    int hexagonsInColumn = dimension/2;
    for (int i = 0; i < dimension; i++) {
      int posX = side*2 + i * side*3/2;
      int posY = 0;
      if (i <= dimension/2) {
        hexagonsInColumn++;
        for (int j = 0; j < hexagonsInColumn; j++) {
          posY = v + j * 2 * v + v*(dimension/2 + 1 - i);
          drawHexagon(posX, posY, side, v, graphics);
        }
      } else {
        hexagonsInColumn--;
        for (int j = 0; j < hexagonsInColumn; j++) {
          posY = v + j * 2 * v + v*(i - dimension/2 + 1);
          drawHexagon(posX, posY, side, v, graphics);
        }
      }
    }
  }

  public static void drawHexagon(int posX, int posY, int side, int v, Graphics graphics) {

    int[] x = {side/2, side, side/2, -side/2, -side, -side/2};
    int[] y = {-v, 0, v, v, 0, -v};

    for (int i = 0; i < 6; i++) {
      x[i] += posX;
      y[i] += posY;
    }

    graphics.drawPolygon(x, y, 6);
  }

  // Don't touch the code below
  static int WIDTH = 640;
  static int HEIGHT = 640;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Super Hexagon");
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
