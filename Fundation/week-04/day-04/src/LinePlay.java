import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {

  public static void mainDraw(Graphics graphics) {

    int segments = 15;

    for (int i = 1; i < segments; i++) {
      int xPos = i * WIDTH / segments;
      int yPos = i * HEIGHT / segments;

      graphics.setColor(Color.GREEN);
      graphics.drawLine(0, yPos, xPos, HEIGHT);

      graphics.setColor(new Color(182, 111, 240));
      graphics.drawLine(xPos, 0, WIDTH, yPos);
    }
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Line Play");
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