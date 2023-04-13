package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPaint extends JFrame    {


    public MyPaint(){
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.setBackground(Color.WHITE);

        cp.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Graphics g = getGraphics();
                g.setColor(Color.red);
                g.fill3DRect(e.getX(),e.getY(),10,0,true);
                
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
            MyPaint myPaint = new MyPaint();
            myPaint.setSize(1000, 1000);
            myPaint.setVisible(true);




}}

