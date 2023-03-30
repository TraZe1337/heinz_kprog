package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rainbow extends Frame implements ActionListener {

    Button b = new Button("Click here");

    public static void main(String[] args) {
        Rainbow frm = new Rainbow();
        frm.setSize(800, 100);
        frm.setVisible(true);
    }

    public Rainbow() {
        super();
        setTitle("Rainbow");
        setLayout(new FlowLayout());
        b.addActionListener(this);
        add(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Rainbowroad road = new Rainbowroad();
        road.run();
    }
}

class Rainbowroad extends Frame implements Runnable {

    Color[] colors = {Color.black, Color.blue, Color.cyan, Color.GRAY, Color.green, Color.magenta, Color.orange,
            Color.pink, Color.red, Color.white, Color.yellow};

    int col = 0;
    public Rainbowroad() {
    }

    public void run() {
        this.setSize(400, 400);
        setBackground(Color.black);
        setVisible(true);
        int i = 0;
        setBackground(colors[col]);
        col = (col + 1) % colors.length;
        repaint();
        while (true) {
            setBackground(colors[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }

    }
}