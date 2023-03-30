package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Safe extends Frame implements ActionListener {
    Button b0 = new Button("0");
    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    int counter;


    public static void main(String[] args) {
        Safe frm = new Safe();
        frm.setSize(800, 100);
        frm.setVisible(true);
    }

    public Safe() {
        super();
        setTitle("Open this Safe!");
        setLayout(new FlowLayout());
        b0.addActionListener(this);
        b0.setActionCommand("0");
        b1.addActionListener(this);
        b1.setActionCommand("1");
        b2.addActionListener(this);
        b2.setActionCommand("2");
        b3.addActionListener(this);
        b3.setActionCommand("3");
        b4.addActionListener(this);
        b4.setActionCommand("4");
        b5.addActionListener(this);
        b5.setActionCommand("5");
        b6.addActionListener(this);
        b6.setActionCommand("6");
        b7.addActionListener(this);
        b7.setActionCommand("7");
        b8.addActionListener(this);
        b8.setActionCommand("8");
        b9.addActionListener(this);
        b9.setActionCommand("9");
        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "0" -> {
                if (counter == 2) {
                    setBackground(Color.GREEN);
                    counter = 3;
                } else if (counter == 5) {
                    setBackground(Color.GREEN);
                    counter = 6;
                } else {
                    setBackground(Color.RED);
                    counter = 0;
                }
            }
            case "1" -> {
                if (counter == 1) {
                    setBackground(Color.GREEN);
                    counter = 2;
                } else {
                    setBackground(Color.RED);
                    counter = 0;
                }

            }
            case "2" -> {
                if (counter == 4) {
                    setBackground(Color.GREEN);
                    counter = 5;
                } else if (counter == 6) {
                    counter = 7;
                }
                else {
                    setBackground(Color.RED);
                    counter = 0;
                }
            }
            case "3" -> {
                if (counter == 3) {
                    counter = 4;
                } else if (counter == 7) {
                    System.exit(0);
                } else if(counter == 0){
                    counter = 1;
                    setBackground(Color.GREEN);
                }
                else {
                    counter = 0;
                    setBackground(Color.RED);
                }
            }
            default -> {
                setBackground(Color.RED);
                counter = 0;
            }
        }
    }
}
