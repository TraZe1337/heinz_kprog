package Tarik;

import java.awt.*;
import java.awt.event.*;

public class ElevenColors extends Frame implements ActionListener {
    Button redButton = new Button("Rot");
    Button grnButton = new Button("Grün");
    Button blackButton = new Button("black");
    Button blueButton = new Button("blue");
    Button cyanButton = new Button("cyan");
    Button grayButton = new Button("gray");
    Button magentaButton = new Button("magenta");
    Button orangeButton = new Button("orange");
    Button pinkButton = new Button("pink");
    Button whiteButton = new Button("white");
    Button yellowButton = new Button("yellow");


    ElevenColors() {
        setLayout(new FlowLayout());
        redButton.addActionListener(this);
        grnButton.addActionListener(this);
        blackButton.addActionListener(this);
        blueButton.addActionListener(this);
        cyanButton.addActionListener(this);
        grayButton.addActionListener(this);
        magentaButton.addActionListener(this);
        orangeButton.addActionListener(this);
        pinkButton.addActionListener(this);
        whiteButton.addActionListener(this);
        yellowButton.addActionListener(this);

        redButton.setActionCommand( "red" );
        grnButton.setActionCommand( "green" );
        grnButton.setActionCommand( "black" );
        grnButton.setActionCommand( "blue" );
        grnButton.setActionCommand( "cyan" );
        grnButton.setActionCommand( "magenta" );
        grnButton.setActionCommand( "orange" );
        grnButton.setActionCommand( "pink" );
        grnButton.setActionCommand( "white" );
        grnButton.setActionCommand( "yellow" );

        add(redButton);
        add(grnButton);
        add(blackButton);
        add(blueButton);
        add(cyanButton);
        add(magentaButton);
        add(orangeButton);
        add(pinkButton);
        add(whiteButton);
        add(yellowButton);
    }

    public void actionPerformed( ActionEvent evt) {
        if (evt.getActionCommand().equals("red")) {
            setBackground(Color.red);
        } else if (evt.getActionCommand().equals("green")) {
            setBackground(Color.green);
        } else if (evt.getActionCommand().equals("black")) {
            setBackground(Color.black);
        } else if (evt.getActionCommand().equals("blue")) {
            setBackground(Color.blue);
        } else if (evt.getActionCommand().equals("cyan")) {
            setBackground(Color.cyan);
        } else if (evt.getActionCommand().equals("magenta")) {
            setBackground(Color.magenta);
        } else if (evt.getActionCommand().equals("orange")) {
            setBackground(Color.orange);
        } else if (evt.getActionCommand().equals("pink")) {
            setBackground(Color.pink);
        } else if (evt.getActionCommand().equals("white")) {
            setBackground(Color.white);
        } else if (evt.getActionCommand().equals("yellow")) {
            setBackground(Color.yellow);
        }
    }

    public static void main(String[] args) {

        ElevenColors demo = new ElevenColors();
        WindowQuitter wquit = new WindowQuitter();
        demo.setSize(200, 150);
        demo.addWindowListener( wquit );
        demo.setVisible(true);
    }
}
class WindowQuitter extends WindowAdapter {
    public void windowClosing( WindowEvent e ) {
        System.exit ( 0 );
    }
}
