import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

  public static void mainDraw(Graphics graphics) {

    int pyramidHeight = 21;

    int triangleSize = WIDTH/pyramidHeight;
    int trianglesInLine = 1;
    for (int i = 1; i <= pyramidHeight; i++) {

      lineOfTriangles(
          (pyramidHeight - i)*triangleSize/2,
          i * (int) (triangleSize * Math.sqrt(3) / 2),
          trianglesInLine,
          triangleSize,
          graphics);
      trianglesInLine += 2;
    }
  }

  public static void lineOfTriangles(
      int xPosition, int yPosition, int numberOfTriangles, int size, Graphics graphics) {

    for (int i = 0; i < numberOfTriangles; i++) {
      if (i % 2 == 0) {
        drawEquilateralTriangle(xPosition + i*size/2, yPosition, size, graphics);
      } else {
        drawFlippedEquilateralTriangle(xPosition  + i*size/2, yPosition, size , graphics);
      }
    }
  }

  public static void drawEquilateralTriangle(int posX, int posY, int sideSize, Graphics graphics) {
    double v = sideSize * Math.sqrt(3) / 2;

    int[] x = {0, sideSize/2, sideSize};
    int[] y = {(int) v, 0, (int) v};

    drawTriangleRepos(posX, posY, x, y, graphics);
  }

  public static void drawFlippedEquilateralTriangle(int posX, int posY, int sideSize, Graphics graphics) {
    double v = sideSize * Math.sqrt(3) / 2;

    int[] x = {0, sideSize/2, sideSize};
    int[] y = {0, (int) v, 0};

    drawTriangleRepos(posX, posY, x, y, graphics);
  }

  public static void drawTriangleRepos(int posX, int posY, int[] x, int[] y, Graphics graphics) {
    for (int i = 0; i < 3; i++) {
      x[i] += posX;
      y[i] += posY;
    }
    drawTriangle(x, y, graphics);
  }

  public static void drawTriangle(int[] x, int[] y, Graphics graphics) {
    graphics.drawPolygon(x, y, 3);
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
