package Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class DrehSafe3 extends JFrame implements ActionListener, Runnable {

    JButton[] buttons;

    long sleeptime;

    boolean isOtherThreadRunning = false;


    public static void main(String[] args) {
        new SetupWindow();

    }

    public DrehSafe3(long sleeptime) {
        this.sleeptime = sleeptime;
    }

    int s = 0;
    int d = 1;

    //(8-5-2-9-6-3-0-7-4-1)
    //(0-1-2-3-4-5-6-7-8-9)
    public void actionPerformed(ActionEvent e) {
        DrehSafe3 y = new DrehSafe3(sleeptime * 2 / 3);
        System.out.println(s);
        switch (Integer.parseInt(e.getActionCommand())) {
            case 0 -> {
                if (s == 6) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            case 1 -> {
                if (s == 9) {
                    s = s + 1;

                } else {
                    s = 0;
                }
            }
            case 2 -> {
                if (s == 2) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            case 3 -> {
                if (s == 5) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            case 4 -> {
                if (s == 8) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            case 5 -> {
                if (s == 1) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            case 6 -> {
                if (s == 4) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            case 7 -> {
                if (s == 7) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            case 8 -> {
                if (s == 0) {
                    s = s + 1;
                }
            }
            case 9 -> {
                if (s == 3) {
                    s = s + 1;
                } else {
                    s = 0;
                }
            }
            default -> {
                s = 0;
            }
        }
        System.out.println(s);

        Color col = s == 0 ? Color.RED : Color.GREEN;

        if (s == 0) {
            d = 10 - d;
            isOtherThreadRunning = true;
            y.setup();
        }
        if(!y.getState2()){
            isOtherThreadRunning=false;
        }
        for (JButton b : buttons) {
            b.setBackground(col);
        }
        if (s == 10) {
            if (!isOtherThreadRunning) {
                //System.exit(0);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            } else {
                s = 9;
            }
        }
        repaint();
    }

    public boolean running = false;

    public void run() {
        while (true) {
            running = true;
            for (int i = 0; i < 10; i++) {
                buttons[i].setText("" + ((Integer.parseInt(buttons[i].getText()) + d) % 10));
            }
            try {
                Thread.sleep(sleeptime);
            } catch (Exception e) {
                throw new RuntimeException();
            } finally {
                running = false;
            }
        }

    }

    public boolean getState2() {
        return running;
    }

    public void setup(){
        setLocation(250, 150);
        setSize(400, 400);
        //setTitle("Spinning Safe");
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

    public static class SetupWindow extends JFrame {
        public SetupWindow() {
            DrehSafe3 d =  new DrehSafe3(3000);
            d.setup();
            d.setTitle("Main Safe!");

        }
    }

}
