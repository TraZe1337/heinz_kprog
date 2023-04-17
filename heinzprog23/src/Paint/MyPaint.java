package AWT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Java Programm für ein einfaches Malprogramm.
 *
 * @author Stefan Janke 214 058
 * @author Filippo Fiorenza 205 194
 * @author Tarik Bugra Kalkan 205 302
 */
public class MyPaint extends JComponent {
  /**
   * Felder für ein leeres "Blatt" zum Malen, Koordinaten der Mausbewegung und ein Feld für die
   * Grafiken aus der Java-Bibliothek.
   */
  Image image;

  Graphics2D graphic;
  int newX;
  int newY;
  int oldX;
  int oldY;

  /** MouseListener für Mausbewegung und initialem Klick zum Zeichnen. */
  public MyPaint() {
    setDoubleBuffered(false);
    addMouseListener(
        new MouseAdapter() {
          /** Koordinaten, wo der start des Malen ist. */
          public void mousePressed(MouseEvent e) {
            oldX = e.getX();
            oldY = e.getY();
          }
        });

    addMouseMotionListener(
        new MouseMotionAdapter() {
          /** Koordinaten, wo die Maus hinbewegt wird. */
          public void mouseDragged(MouseEvent e) {
            newX = e.getX();
            newY = e.getY();

            if (graphic != null) {
              graphic.drawLine(oldX, oldY, newX, newY);
              repaint();
              oldX = newX;
              oldY = newY;
            }
          }
        });
  }

  /** Erstellen einer leeren Malfläche mit der größe des frames. */
  protected void paintComponent(Graphics g) {
    if (image == null) {
      image = createImage(getSize().width, getSize().height);
      graphic = (Graphics2D) image.getGraphics();
      graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      clear();
    }
    g.drawImage(image, 0, 0, null);
  }

  /** Methode die, die gesamte Malfläche wieder Weiß macht und die Malfarbe auf Schwarz stellt. */
  public void clear() {
    graphic.setPaint(Color.WHITE);
    graphic.fillRect(0, 0, getSize().width, getSize().height);
    graphic.setPaint(Color.BLACK);
    repaint();
  }

  /** Methode zum Malen in Schwarzer farbe. */
  public void black() {
    graphic.setPaint(Color.BLACK);
  }

  /** Methode zum Malen in Roter farbe. */
  public void red() {
    graphic.setPaint(Color.RED);
  }

  /** Methode zum Malen in Grüner farbe. */
  public void green() {
    graphic.setPaint(Color.GREEN);
  }

  /** Methode zum Malen in Blauer farbe. */
  public void blue() {
    graphic.setPaint(Color.BLUE);
  }

  public static class DrawWindow {

    /** Buttons für die Farbauswahl. */
    JButton black;

    JButton red;
    JButton green;
    JButton blue;
    JButton clear;
    MyPaint myPaint;

    /**
     * ActionListener für die Erkennung der Buttons zum Wechseln der farbe oder freimachen von
     * gemaltem.
     */
    ActionListener actionListener =
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (e.getSource() == black) {
              myPaint.black();
            } else if (e.getSource() == red) {
              myPaint.red();
            } else if (e.getSource() == green) {
              myPaint.green();
            } else if (e.getSource() == blue) {
              myPaint.blue();
            } else if (e.getSource() == clear) {
              myPaint.clear();
            }
          }
        };

    public static void main(String[] args) {
      new DrawWindow().show();
    }

    /**
     * Methode für das Erstellen von Frame + Container. Anlegen der Buttons. Einfügen von Buttons
     * und Malfeld in den Container und angabe der Ausrichtung. Deklaration des Frames.
     */
    public void show() {
      JFrame frame = new JFrame();
      Container c = frame.getContentPane();
      c.setLayout(new BorderLayout());
      myPaint = new MyPaint();
      c.add(myPaint, BorderLayout.CENTER);

      black = new JButton("Black");
      black.addActionListener(actionListener);
      red = new JButton("Red");
      red.addActionListener(actionListener);
      green = new JButton("Green");
      green.addActionListener(actionListener);
      blue = new JButton("Blue");
      blue.addActionListener(actionListener);
      clear = new JButton("Clear");
      clear.addActionListener(actionListener);

      JPanel buttons = new JPanel();

      buttons.add(black);
      buttons.add(red);
      buttons.add(green);
      buttons.add(blue);
      buttons.add(clear);
      c.add(buttons, BorderLayout.SOUTH);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 600);
      frame.setResizable(false);
      frame.setVisible(true);
    }
  }
}
