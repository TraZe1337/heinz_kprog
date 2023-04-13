package src;

import java.util.concurrent.ThreadLocalRandom;
/**
 * @author tarik kalkan
 * version 6 05.01.2023
 */
public class Bruch {
    private int nenner;
    private int zähler;
    private double bruchwert;
    private boolean isSpieler;
    public Bruch(int nenner, int zähler) {
        if(nenner != 0 && zähler != 0){
            this.nenner = nenner;
            this.bruchwert = Double.parseDouble(String.valueOf(nenner))/Double.parseDouble(String.valueOf(zähler));
            this.zähler = zähler;
        }
    }

    @Override
    public String toString() {
        return nenner + "/" + zähler;
    }

    public static Bruch generiereBruch(){
            int zähler = ThreadLocalRandom.current().nextInt(50, 999);
            int nenner = ThreadLocalRandom.current().nextInt(10,zähler);
            return nenner % zähler != 0 ? new Bruch(zähler, nenner) : generiereBruch();
    }

    public double getBruchwert() {
        return this.bruchwert;
    }

    public boolean isSpieler() {
        return isSpieler;
    }

    public void setSpieler(boolean spieler) {
        isSpieler = spieler;
    }
}
