import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {

  public static void mainDraw(Graphics graphics) {
    int twiceV = HEIGHT/7;
    int v = twiceV/2;
    for (int i = 0; i < 7; i++) {
      drawHexagon(WIDTH/2, v + i * HEIGHT/7, v, graphics);
    }
  }

  public static void drawHexagon(int posX, int posY, int v, Graphics graphics) {
    int side = (int) (v * 2 / Math.sqrt(3));

    int[] x = {side/2, side, side/2, -side/2, -side, -side/2};
    int[] y = {-v, 0, v, v, 0, -v};

    for (int i = 0; i < 6; i++) {
      x[i] += posX;
      y[i] += posY;
    }

    graphics.drawPolygon(x, y, 6);
  }

  // Don't touch the code below
  static int WIDTH = 630;
  static int HEIGHT = 630;

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
