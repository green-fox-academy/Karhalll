import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {

  public static void mainDraw(Graphics graphics) {

    int segments = 64; //Also works for 4/16/64. All any power of 2 ;)
    int sideSegments = (int) Math.sqrt(segments);

    for (int i = 0; i < sideSegments; i++) {
      for (int j = 0; j < sideSegments; j++) {
        drawSegment(
            i * WIDTH / sideSegments,
            j * HEIGHT / sideSegments,
            sideSegments,
            graphics
        );
      }
    }
  }

  public static void drawSegment(int xPlus, int yPlus, int sideSegments, Graphics graphics) {
    int lines = 15;

    int quarterX = WIDTH / sideSegments;
    int quarterY = HEIGHT / sideSegments;

    for (int i = 1; i < lines; i++) {

      int xPos = i * quarterX / lines;
      int yPos = i * quarterY / lines;
      graphics.setColor(Color.GREEN);
      graphics.drawLine(xPlus + 0, yPlus + yPos, xPlus + xPos, yPlus + quarterY);

      graphics.setColor(new Color(182, 111, 240));
      graphics.drawLine(xPlus + xPos, yPlus + 0, xPlus + quarterX, yPlus + yPos);
    }
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Line Play Quarters");
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
