package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ElevenColors extends Frame implements ActionListener {


    Button b0 = new Button("Black");
    Button b1 = new Button("Blue");
    Button b2 = new Button("Cyan");
    Button b3 = new Button("Gray");
    Button b4 = new Button("Green");
    Button b5 = new Button("Magenta");
    Button b6 = new Button("Orange");
    Button b7 = new Button("Pink");
    Button b8 = new Button("Red");
    Button b9 = new Button("White");
    Button b10 = new Button("Yellow");

    public static void main(String[] args) {
        ElevenColors frm = new ElevenColors();
        WindowQuitter wquit = new WindowQuitter();
        frm.addWindowListener( wquit );
        frm.setSize(600, 500);
        frm.setVisible(true);
    }

    public ElevenColors() {
        super();
        setTitle("Change my Color! ");
        setLayout(new FlowLayout());
        b0.addActionListener(this);
        b0.setActionCommand("Black");
        b1.addActionListener(this);
        b1.setActionCommand("Blue");
        b2.addActionListener(this);
        b2.setActionCommand("Cyan");
        b3.addActionListener(this);
        b3.setActionCommand("Gray");
        b4.addActionListener(this);
        b4.setActionCommand("Green");
        b5.addActionListener(this);
        b5.setActionCommand("Magenta");
        b6.addActionListener(this);
        b6.setActionCommand("Orange");
        b7.addActionListener(this);
        b7.setActionCommand("Pink");
        b8.addActionListener(this);
        b8.setActionCommand("Red");
        b9.addActionListener(this);
        b9.setActionCommand("White");
        b10.addActionListener(this);
        b10.setActionCommand("Yellow");
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
        add(b10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Black" -> {
                setBackground(Color.BLACK);
            }
            case "Blue" -> {
                setBackground(Color.BLUE);
            }
            case "Cyan" -> {
                setBackground(Color.CYAN);
            }
            case "Gray" -> {
                setBackground(Color.GRAY);
            }
            case "Green" -> {
                setBackground(Color.GREEN);
            }
            case "Magenta" -> {
                setBackground(Color.MAGENTA);
            }
            case "Orange" -> {
                setBackground(Color.ORANGE);
            }
            case "Pink" -> {
                setBackground(Color.PINK);
            }
            case "Red" ->{
                setBackground(Color.RED);
            }
            case "White" -> {
                setBackground(Color.WHITE);
            }
            case "Yellow" -> {
                setBackground(Color.YELLOW);
            }
            default -> {
                setBackground(Color.darkGray);
            }
        }
    }

    static class WindowQuitter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

}
