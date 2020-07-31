import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

  public static void mainDraw(Graphics graphics) {

    int segments = 4;
    int sideSegments = (int) Math.sqrt(segments);

    int lines = 15;

    int quarterX = WIDTH / sideSegments;
    int quarterY = HEIGHT / sideSegments;

    for (int i = 1; i < lines; i++) {

      int xPos = i * quarterX / lines;
      int yPos = i * quarterY / lines;
      drawGreenLine(quarterX, yPos, quarterX - xPos, quarterY, graphics);
      drawGreenLine(quarterX, yPos, quarterX + xPos, quarterY, graphics);
      drawGreenLine(quarterX, quarterY + yPos, xPos, quarterY, graphics);
      drawGreenLine(quarterX, quarterY + yPos, 2 * quarterX - xPos, quarterY, graphics);
    }

    graphics.drawLine(quarterX, 0, quarterX, 2 * quarterY);
  }

  public static void drawGreenLine(int x1, int y1, int x2, int y2, Graphics graphics) {
    graphics.setColor(Color.GREEN);
    graphics.drawLine(x1, y1, x2, y2);
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Envelope Star");
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
