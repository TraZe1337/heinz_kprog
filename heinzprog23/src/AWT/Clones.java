package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Clones extends Frame implements ActionListener {

    Button b = new Button("Clone");
    Button b2 = new Button("Repaint");
    Color[] colors = {Color.black, Color.blue, Color.cyan, Color.GRAY, Color.green, Color.magenta, Color.orange,
            Color.pink, Color.red, Color.white, Color.yellow};
    int col = 0;

    public Clones() {
        super();
        WindowQuitter wquit = new WindowQuitter();
        this.addWindowListener(wquit);
        setTitle("Repaint or Clone!");
        setLayout(new FlowLayout());
        b2.addActionListener(this);
        b.addActionListener(this);
        b2.setActionCommand("repaint");
        b.setActionCommand("clone");
        add(b2);
        add(b);

    }

    public static void main(String[] args) {
        Clones cl = new Clones();
        cl.setSize(500, 500);
        cl.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "clone" -> {
               Clones c =  new Clones();
               c.setSize(500,500);
               c.setVisible(true);
            }
            case "repaint" -> {
                setBackground(colors[col]);
                col = (col + 1) % colors.length;
                repaint();
            }
        }

    }
    static class WindowQuitter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}