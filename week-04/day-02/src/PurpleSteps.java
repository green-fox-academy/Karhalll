import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps {
  public static void mainDraw(Graphics graphics) {
    // Reproduce this:
    // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r3.png]

    int numberOfSteps = 19;
    int size = 5 * numberOfSteps / 3;
    for (int i = 0; i < numberOfSteps; i++) {
      drawPurpleStep(WIDTH/size + i * WIDTH/size, WIDTH/size, graphics);
    }
  }

  public static void drawPurpleStep(int step, int size, Graphics graphics) {
    graphics.setColor(new Color(168, 81, 238));
    graphics.fillRect(step, step, size, size);
    graphics.setColor(Color.BLACK);
    graphics.drawRect(step, step, size, size);
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
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