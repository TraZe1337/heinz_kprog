package MaxxiMax;

/**
 * @author tarik kalkan
 * version 9 02.01.2023
 */
public class Spielfeld {
    static int y;
    static int x;
    static Bruch[][] spielfeld;

    public Spielfeld(int y, int x) {
        spielfeld = new Bruch[y][x];
        this.y = y;
        this.x = x;

        for (int i = 0; i < y; i++) { //iteration über die matrix
            for (int j = 0; j < x; j++) {
                spielfeld[i][j] = Bruch.generiereBruch();
            }
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(spielfeld[i][j]+ "\t\t"); //ausgabe mit tabs
            }
            System.out.println("");
            System.out.println("");
        }
        return "";
    }

    public void setValueInSpielfeld(int x, int y, Bruch wert) {
        spielfeld[y][x] = wert;
    }

    public Bruch getBruchFromSpielfeld(int x, int y) {
        return this.spielfeld[y][x];
    }
    public void moveSpieler(Spieler spieler, Richtung richtung){
       if(!spieler.getErlaubte_richtungen().contains(richtung)){
           System.out.println("Bewegungsrichtung nicht erlaubt!");
       } else{
           switch(richtung) {
               case OBEN -> {
                   if(spieler.getPos_y() == 0){ // ist der spieler im randbereich?
                       if(getBruchFromSpielfeld(spieler.getPos_x(), y-1).isSpieler()) { // spieler will spieler essen
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(y - 1);
                   } else {
                       if(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y() - 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(spieler.getPos_y() - 1);
                   }
                   spieler.increasePunkeStand(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y()));
               }
               case LINKS -> {
                   if(spieler.getPos_x() == 0){
                       if(getBruchFromSpielfeld(x - 1, spieler.getPos_y()).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(x - 1);
                   } else {
                       if(getBruchFromSpielfeld(spieler.getPos_x() - 1, spieler.getPos_y()).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(spieler.getPos_x() - 1);
                   }
                   spieler.increasePunkeStand(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y()));
               }
               case RECHTS -> {
                   if(spieler.getPos_x() == x - 1){
                       if(getBruchFromSpielfeld(0, spieler.getPos_y()).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(0);
                   } else {
                       if(getBruchFromSpielfeld(spieler.getPos_x() + 1, spieler.getPos_y()).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(spieler.getPos_x() + 1);
                   }
                   spieler.increasePunkeStand(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y()));
               }
               case UNTEN -> {
                   if(spieler.getPos_y() == y - 1){
                       if(getBruchFromSpielfeld(spieler.getPos_x(), 0).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(0);
                   } else {
                       if(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y() + 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(spieler.getPos_y() + 1);
                   }
                   spieler.increasePunkeStand(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y()));
               }
               case UNTEN_LINKS -> {
                   if(spieler.getPos_x() == 0 && spieler.getPos_y() == y - 1){
                       // von ecke zu ecke
                       if(getBruchFromSpielfeld(x - 1, 0).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(x - 1);
                       spieler.setPos_y(0);
                   } else if (spieler.getPos_x() == 0) {
                       // von rand zu rand
                       if(getBruchFromSpielfeld(x - 1, spieler.getPos_y() + 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(spieler.getPos_y() + 1);
                       spieler.setPos_x(x - 1) ;
                   } else if (spieler.getPos_y() == y - 1 ) {
                       // von unten nach oben
                       if(getBruchFromSpielfeld(spieler.getPos_x() - 1, 0).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(spieler.getPos_x() - 1);
                       spieler.setPos_y(0);
                   } else
                   { // normalfall
                       if(getBruchFromSpielfeld(spieler.getPos_x() - 1, spieler.getPos_y() + 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(spieler.getPos_y() + 1);
                       spieler.setPos_x(spieler.getPos_x() - 1);
                   }
                   spieler.increasePunkeStand(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y()));
               }
               case OBEN_RECHTS -> {
                   if(spieler.getPos_x() == x - 1 && spieler.getPos_y() == 0){
                       if(getBruchFromSpielfeld(0, y - 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(0);
                       spieler.setPos_y(y - 1);
                   } else if (spieler.getPos_y() == 0 && spieler.getPos_x() < x - 1) {
                       if(getBruchFromSpielfeld(spieler.getPos_x() + 1, y - 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(y - 1);
                       spieler.setPos_x(spieler.getPos_x() + 1);
                   } else if (spieler.getPos_x() == x - 1 ) {
                       if(getBruchFromSpielfeld(0, spieler.getPos_y() - 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_x(0);
                       spieler.setPos_y(spieler.getPos_y() - 1);
                   } else
                   {
                       if(getBruchFromSpielfeld(spieler.getPos_x() + 1, spieler.getPos_y() - 1).isSpieler()) {
                           System.out.println("Spielzug ungültig. Spielzug wird ausgesetzt!");
                           break;
                       }
                       setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), new Leeres_Feld(0,0));
                       spieler.setPos_y(spieler.getPos_y() - 1);
                       spieler.setPos_x(spieler.getPos_x() + 1);
                   }
                   spieler.increasePunkeStand(getBruchFromSpielfeld(spieler.getPos_x(), spieler.getPos_y()));
               }
           }
           setValueInSpielfeld(spieler.getPos_x(), spieler.getPos_y(), spieler);
       }
    }
}
