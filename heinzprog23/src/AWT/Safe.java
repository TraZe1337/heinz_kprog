package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Safe extends Frame implements ActionListener {
    int counter;


    public static void main(String[] args) {
        Safe frm = new Safe();
        frm.setSize(300, 250);
        frm.setVisible(true);
    }

    public Safe() {
        super();
        setTitle("Open this Safe!");
        setLayout(new FlowLayout());
        for(int i = 0; i<10; i++){
            Button b = new Button(" " + i);
            b.addActionListener(this);
            b.setActionCommand(" " + i);
            add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case " 0" -> {
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
            case " 1" -> {
                if (counter == 1) {
                    setBackground(Color.GREEN);
                    counter = 2;
                } else {
                    setBackground(Color.RED);
                    counter = 0;
                }

            }
            case " 2" -> {
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
            case " 3" -> {
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
