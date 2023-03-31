package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Rainbow extends Frame implements ActionListener {

    Button b = new Button("Click here");

    public static void main(String[] args) {
        Rainbow frm = new Rainbow();
        frm.setSize(500, 500);
        frm.setVisible(true);
    }

    public Rainbow() {
        super();
        WindowQuitter wquit = new WindowQuitter();
        this.addWindowListener( wquit );
        setTitle("Rainbow");
        setLayout(new FlowLayout());
        b.addActionListener(this);
        add(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread road = new Thread(new Rainbowroad());
        road.start();
    }
    class Rainbowroad extends Frame implements Runnable {

        Color[] colors = {Color.black, Color.blue, Color.cyan, Color.GRAY, Color.green, Color.magenta, Color.orange,
                Color.pink, Color.red, Color.white, Color.yellow};

        int col = 0;
        public Rainbowroad() {
            super();
            WindowQuitter wquit = new WindowQuitter();
            this.addWindowListener( wquit );
            this.setSize(400, 400);
            setTitle("glow");
            setLayout(new FlowLayout());
            setVisible(true);


        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                setBackground(colors[col]);
                col = (col + i) % colors.length;
                i ++;
                repaint();
                setBackground(colors[i]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                if(i == 10){
                    i = 0;
                }
            }


        }
    }
    static class WindowQuitter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

}