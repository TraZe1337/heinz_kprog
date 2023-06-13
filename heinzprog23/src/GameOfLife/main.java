package GameOfLife;


public class main {
    public static void main(String[] args) {
      //Environment environment = new Environment();

        DesktopBackground desktop = new DesktopBackground(); // Hauptfenster erzeugen
        desktop.addChild (new EnvironmentView(desktop), 100, 100); // Ein Kinderfenster einfügen

        //TODO: counter in title rein - Samil //done
        //TODO: Thread -> mehrere Instanzen - Samil // done
        //TODO: Farben ändern (ROT/Grün) - Stefan - done
        //TODO: Titel ändern - Stefan - done
        //TODO: Run -> Laufen - Stefan - done
        //TODO: Zellen Tot zu lebendig machen mit Klick - Stefan
        //TODO: Modus Setzen: Zellenstatus switchen - Stefan - done
        //TODO: Modus Malen: sollen alle Zellen bei Überstreichen mit der Maus lebendig werden. - Filippo
        //TODO: Pop-up: Farben ändern - Tarik
        //TODO: Muster (Gleiter, ...) - Stefan
    }


}

