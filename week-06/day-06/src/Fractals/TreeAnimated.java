package Fractals;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

public class TreeAnimated extends Canvas {

  private JFrame frame;
  private final int WIDTH = 1280;
  private final int HEIGHT = 720;

  public TreeAnimated() {
    frame = new JFrame("TreeAnimated");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    frame.add(this);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    TreeAnimated ft = new TreeAnimated();
    ft.setVisible(true);
    ft.setBackground(new Color(12, 49, 63));
  }

  @Override
  public void paint(Graphics graphics) {
    graphics.setColor(new Color(247, 211, 51));

    for (int i = 0; i < 10; i++) {
      graphics.clearRect(0, 0, WIDTH, HEIGHT);

      branch(graphics, WIDTH/2, 8*HEIGHT/10, -90, i);

      try {
        Thread.sleep(250);
      } catch (Exception e) {
        System.out.println("Cant sleep");
      }
    }
  }

  public void branch(Graphics graphics, int x1, int y1, int angle, int level) {
    if (level <= 0) {
      return;
    }

    int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * level * 12.0);
    int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * level * 12.0);

    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setStroke(new BasicStroke(0.5f * level));
    g2d.drawLine(x1, y1, x2, y2);

    branch(graphics, x2, y2, angle - 25, level - 1);
    branch(graphics, x2, y2, angle, level - 1);
    branch(graphics, x2, y2, angle + 25, level - 1);
  }
}
