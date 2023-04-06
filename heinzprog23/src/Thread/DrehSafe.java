package Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrehSafe extends JFrame implements ActionListener, Runnable {
    int counter = 0;
    int switcher = 9;
    Color c = Color.GREEN;
    Color c2 = Color.RED;

    JButton[] buttons;


    public static void main(String[] args) {
        new DrehSafe();

    }

    public DrehSafe() {
        setLocation(250, 150);
        setSize(400, 400);
        setTitle("Spinning Safe");
        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 3));
        buttons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton("" + i);
            buttons[i].addActionListener(this);
            buttons[i].setName(" " + i);
        }
        c.add(buttons[0]);
        c.add(buttons[9]);
        c.add(buttons[8]);
        c.add(buttons[1]);
        c.add(new JPanel());
        c.add(buttons[7]);
        c.add(buttons[2]);
        c.add(new JPanel());
        c.add(buttons[6]);
        c.add(buttons[3]);
        c.add(buttons[4]);
        c.add(buttons[5]);
        setVisible(true);
        new Thread(this).start();
    }

    //(8-2-2-4-7-2-5-3-0-1)
    //(0-1-2-3-4-5-6-7-8-9)
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton x;
        x = (JButton) e.getSource();
        switch (x.getName()) {
            case "0" -> {
                if (counter == 8) {
                    counter = 9;
                    x.setBackground(Color.RED);
                } else {
                    counter = 0;
                }
            }
            case "1" -> {
                if (counter == 9) {
                    System.exit(0);
                } else {
                    counter = 0;
                }
            }
            case "2" -> {
                if (counter == 1) {
                    counter = 2;
                } else if (counter == 2) {
                    counter = 3;
                } else if (counter == 5) {
                    counter = 6;
                } else {
                    counter = 0;
                }
            }
            case "3" -> {
                if (counter == 7) {
                    counter = 8;
                } else {
                    counter = 0;
                }
            }
            case "4" -> {
                if (counter == 3) {
                    counter = 4;
                } else {
                    counter = 0;
                }
            }
            case "5" -> {
                if (counter == 6) {
                    counter = 7;
                } else {
                    counter = 0;

                }
            }
            case "7" -> {
                if (counter == 4) {
                    counter = 5;
                } else {
                    counter = 0;
                }
            }
            case "8" -> {
                if (counter == 0) {
                    counter = 1;
                }
            }
            default -> {
                counter = 0;
            }
        }
        System.out.println(counter);
        if (counter == 0) {
            switcher = 10 - switcher;
            for (JButton j : buttons) {
                //j.setBackground(c2);
            }
        } else if (counter > 0) {
            for (JButton j : buttons) {
                //j.setBackground(c);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                buttons[i].setText("" + ((Integer.parseInt(buttons[i].getText()) + switcher) % 10));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {;
            }
        }

    }
}
