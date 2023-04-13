package src;

import java.io.IOException;

/**
 * @author tarik kalkan
 * version 4 04.01.2023
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Spielfeld spielfeld = new Spielfeld(8, 8);
        Spieler schwarz = new Spieler(4, 5, Farbe.SCHWARZ);
        Spieler weiss = new Spieler(3, 2, Farbe.WEISS);
        spielfeld.setValueInSpielfeld(schwarz.getPos_x(), schwarz.getPos_y(), schwarz);
        spielfeld.setValueInSpielfeld(weiss.getPos_x(), weiss.getPos_y(), weiss);
        while(true){
            spielfeld.toString();
            spielfeld.moveSpieler(schwarz, MyIO.promptAndReadRichtung("SCHWARZ! Mögliche Richtungen : OBEN, UNTEN, LINKS, RECHTS, UNTEN_LINKS \n "));
            System.out.println("PUNKTESTAND - SCHWARZ: " + schwarz.getPunktestand() + " WEISS: " + weiss.getPunktestand());
            if(schwarz.getPunktestand() > 53){
                System.out.println("SCHWARZ! hat GEWONNEN");
                break;
            }
            System.out.println("----------------");
            spielfeld.toString();
            spielfeld.moveSpieler(weiss, MyIO.promptAndReadRichtung("WEISS! Mögliche Richtungen : OBEN, UNTEN, LINKS, RECHTS, OBEN_RECHTS \n "));
            System.out.println("PUNKTESTAND - SCHWARZ: " + schwarz.getPunktestand() + " WEISS: " + weiss.getPunktestand());
            if(weiss.getPunktestand() > 53){
                System.out.println("WEISS! hat GEWONNEN");
                break;
            }
            System.out.println("----------------");
        }

    }
}