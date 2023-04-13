package src;

import java.util.List;
/**
 * @author tarik kalkan
 * version 2 03.01.2023
 */
public class Spieler extends Bruch {

    private int pos_x;
    private int pos_y;
    private Farbe farbe;
    private List<Richtung> erlaubte_richtungen;
    private double Punktestand;
    public Spieler(int pos_x, int pos_y, Farbe farbe) {
        super(0, 0);
        this.farbe = farbe;
        this.pos_y = pos_y;
        this.pos_x = pos_x;
        setSpieler(true);
        if(this.farbe == Farbe.WEISS){
            this.erlaubte_richtungen = List.of(Richtung.OBEN, Richtung.LINKS, Richtung.UNTEN, Richtung.RECHTS, Richtung.OBEN_RECHTS );
        } else {
            this.erlaubte_richtungen = List.of(Richtung.OBEN, Richtung.LINKS, Richtung.UNTEN, Richtung.RECHTS, Richtung.UNTEN_LINKS );
        }
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public List<Richtung> getErlaubte_richtungen() {
        return erlaubte_richtungen;
    }

    @Override
    public String toString() {
        return this.farbe.name();
    }

    public void increasePunkeStand(Bruch bruch){
        Punktestand = Punktestand + bruch.getBruchwert();
    }

    public double getPunktestand() {
        return Punktestand;
    }
}
