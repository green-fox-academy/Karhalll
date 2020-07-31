import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3d {
  public static void mainDraw(Graphics graphics) {
    // Reproduce this:
    // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r4.png]

    int size = 10;
    int beforeSize = 0;
    for (int i = 0; i < 6; i++) {
      drawPurpleStep(size + i*size + beforeSize, size + size*i, graphics);
      beforeSize += size*i;
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