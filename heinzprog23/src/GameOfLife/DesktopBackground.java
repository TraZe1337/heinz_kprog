package GameOfLife;

import javax.swing.*;
public class DesktopBackground extends JFrame { // Klasse fuer Haupt-Fenster
    private JDesktopPane desk; // Ersatz fuer Standard-ContentPane
    public DesktopBackground() { // Konstruktor
        desk = new JDesktopPane(); // neue DesktopPane
        desk.setDesktopManager (new DefaultDesktopManager()); // mit neuem Manager
        setContentPane (desk); // als neue ContentPane
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600); setLocation(250, 340);
        setTitle("DesktopFrameTest");
        setVisible(true);
    } // end Konstruktor
    public void addChild (JInternalFrame child, int x, int y) { // Hinzufuegen
        child.setLocation (x, y); // Ort und
        child.setSize (200, 150); // Groesse setzen
        child.setDefaultCloseOperation (JInternalFrame.DISPOSE_ON_CLOSE);// Schiessoperation
        desk.add (child); // Kindfenster einfuegen
        child.setVisible (true); // und sichtbar machen
    }// end addChild
    public static void main (String[] args) {
        DesktopBackground desktop = new DesktopBackground(); // Hauptfenster erzeugen
        desktop.addChild (new EnvironmentView (desktop), 10, 10); // Ein Kindfenster einfuegen
    } // end main
} // end class DesktopFrameTest