package GameOfLife;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Menu extends JFrame {

    JTextField t = new JTextField(15); // Ausgabe-Textfeld
    ActionListener al = new ActionListener() { // AL als anonyme Klasse
        public void actionPerformed(ActionEvent e){ // ... fuer alle MenuItems
            t.setText(((JMenuItem)e.getSource()).getText()); // Ausgabe von Text in t
        }
    };
    JMenu[] menus = { new JMenu("Datei"), new JMenu("Bearbeiten"), new JMenu("Suchen") };
    JMenuItem[] items = {
            new JMenuItem("Neu"), new JMenuItem("Öffnen"),
            new JMenuItem("Schließen"), new JMenuItem("Beenden"),
            new JMenuItem("Rückgängig"), new JMenuItem("Widerrufen"),
            new JMenuItem("Ausschneiden"), new JMenuItem("Kopieren"),
            new JMenuItem("Einfügen"), new JMenuItem("Suchen"),
            new JMenuItem("Ersetzen") };

    public Menu() {
        menus[0].setToolTipText("Operationen auf Dateien"); // Hilfe fuer Menue
        items[4].setToolTipText("Nimm letzten Befehl zurück"); // Hilfe fuer Menue-Eintrag
        for (int i = 0; i < items.length; i++) { // fuer alle Eintraege:
            items[i].addActionListener(al); // registriere AL
            menus[(i<4)?0:(i<9)?1:2].add(items[i]); // add Items in Menue 0|1|2
        }
        JMenuBar mb = new JMenuBar(); // erzeuge Menue-Leiste
        for (int i = 0; i < menus.length; i++) // fuer alle Menues:
            mb.add (menus[i]); // fuege ein in Menue-Leiste
        setJMenuBar (mb); // fuege Menue-Leiste ein
        Container cp = getContentPane(); // Fenter-Container
        cp.setLayout(new FlowLayout()); // setze FlowLayout
        cp.add(t); // fuege Textfeld ein
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocation(250, 340);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Menu();
    }
}
