package Thread;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrehSafe2 extends JFrame implements ActionListener, Runnable {

    JButton[] buttons;

    public static void main(String[] args) {
        new DrehSafe2();

    }

    public DrehSafe2() {
        setLocation(250, 150);
        setSize(400, 400);
        setTitle("Spinning Safe");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 3));
        buttons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton("" + i);
            buttons[i].addActionListener(this);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            buttons[i].setFont(new Font("Courier", Font.BOLD, 28));
        }

        cp.add(buttons[0]);
        cp.add(buttons[9]);
        cp.add(buttons[8]);
        cp.add(buttons[1]);
        cp.add(new JPanel());
        cp.add(buttons[7]);
        cp.add(buttons[2]);
        cp.add(new JPanel());
        cp.add(buttons[6]);
        cp.add(buttons[3]);
        cp.add(buttons[4]);
        cp.add(buttons[5]);
        setVisible(true);
        new Thread(this).start();
    }

    int s = 0;
    int d = 1;
    long sleeptime = 3000;
    //(8-2-2-4-7-2-5-3-0-1)
    //(0-1-2-3-4-5-6-7-8-9)
    public void actionPerformed(ActionEvent e) {
        System.out.println(s);
        switch (Integer.parseInt(e.getActionCommand())){
            case 0 -> {
                if (s == 8) {
                    s = s+1;
                    setBackground(Color.RED);
                } else {
                    s = 0;
                }
            }
            case 1 -> {
                if (s == 9) {
                    System.exit(0);
                } else {
                    s = 0;
                }
            }
            case 2 -> {
                if (s == 1) {
                    s = s+1;
                } else if (s == 2) {
                    s = s+1;
                } else if (s == 5) {
                    s = s+1;
                } else {
                    s = 0;
                }
            }
            case 3 -> {
                if (s == 7) {
                    s = s+1;
                } else {
                    s = 0;
                }
            }
            case 4 -> {
                if (s == 3) {
                    s = s+1;
                } else {
                    s = 0;
                }
            }
            case 5 -> {
                if (s == 6) {
                    s = s+1;
                } else {
                    s = 0;

                }
            }
            case 7 -> {
                if (s == 4) {
                    s = s+1;
                    this.setBackground(Color.RED);
                } else {
                    s = 0;
                }
            }
            case 8 -> {
                if (s == 0) {
                    s = s+1;
                }
            }
            default -> {
                s = 0;
            }
        }
        System.out.println(s);

        Color col  = s==0 ? Color.RED :Color.GREEN;
        if (s == 0) {
            d = 10 - d;}
            for (JButton b : buttons) {
                b.setBackground(col);
            }
            if (s == 10) {
                System.exit(0);}
            repaint();
    }

    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                buttons[i].setText("" + ((Integer.parseInt(buttons[i].getText()) + d) % 10));
            }
            try {
                Thread.sleep(sleeptime);
            } catch (Exception e) {}
        }

    }
}
