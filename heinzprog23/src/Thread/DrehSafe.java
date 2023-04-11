package Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * DrehSafe mit der Kombination (8-2-2-4-7-2-5-3-0-1).
 *
 * @author Stefan Janke 214 058
 * @author Filippo Fiorenza 205 194
 * @author Tarik Bugra Kalkan 205 302
 */

public class DrehSafe extends JFrame implements ActionListener, Runnable {

    JButton[] buttons;


    public static void main(String[] args) {
        new DrehSafe();

    }

    /**
     * Konstruktor that creates a Safe.
     * With Size, Title and Buttons.
     */

    public DrehSafe() {
        setSize(400, 400);
        setTitle("Spinning Safe");
        setLayout(new GridLayout(4, 3));
        buttons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton("" + i);
            buttons[i].addActionListener(this);
            buttons[i].setName(" " + i);
        }
        add(buttons[0]);
        add(buttons[9]);
        add(buttons[8]);
        add(buttons[1]);
        add(new JPanel());
        add(buttons[7]);
        add(buttons[2]);
        add(new JPanel());
        add(buttons[6]);
        add(buttons[3]);
        add(buttons[4]);
        add(buttons[5]);
        setVisible(true);
        new Thread(this).start();
    }

    int counter = 0;
    int switcher = 9;

    //(8-2-2-4-7-2-5-3-0-1)
    //(0-1-2-3-4-5-6-7-8-9)
    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         *  On Button Click it checks the Button for it Value and if the Button is pressed in the right order or not.
         *  If the Button is pressed in the wrong order the Safe rotates in the other direction and the counter resets.
         *
         */

        switch (Integer.parseInt(e.getActionCommand())) {
            case 0 -> {
                if (counter == 8) {
                    counter = counter + 1;
                } else {
                    counter = 0;
                }
            }
            case 1 -> {
                if (counter == 9) {
                    System.exit(0);
                } else {
                    counter = 0;
                }
            }
            case 2 -> {
                if (counter == 1) {
                    counter = counter + 1;
                } else if (counter == 2) {
                    counter = counter + 1;
                } else if (counter == 5) {
                    counter = counter + 1;
                } else {
                    counter = 0;
                }
            }
            case 3 -> {
                if (counter == 7) {
                    counter = counter + 1;
                } else {
                    counter = 0;
                }
            }
            case 4 -> {
                if (counter == 3) {
                    counter = counter + 1;
                } else {
                    counter = 0;
                }
            }
            case 5 -> {
                if (counter == 6) {
                    counter = counter + 1;
                } else {
                    counter = 0;

                }
            }
            case 7 -> {
                if (counter == 4) {
                    counter = counter + 1;
                } else {
                    counter = 0;
                }
            }
            case 8 -> {
                if (counter == 0) {
                    counter = counter + 1;
                }
            }
            default -> {
                counter = 0;
            }
        }
        if (counter == 0) {
            switcher = 10 - switcher;
        }
        for (JButton j : buttons) {
            j.setBackground(Color.RED);
        }
        if (counter > 0) {
            for (JButton j : buttons) {
                j.setBackground(Color.GREEN);
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
            } catch (InterruptedException ie) {
                ;
            }
        }

    }
}
