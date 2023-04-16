package MaxxiMax;

/**
 * @author tarik kalkan
 * version 3 04.01.2023
 */
// setzt ein Feld auf 0/0 so das man darauf keine punkte mehr sammeln kann
public class Leeres_Feld extends Bruch {

    public Leeres_Feld(int nenner, int zähler) {
        super(0, 0);
    }

    @Override
    public String toString() {
        return "\t";
    }
}
