package heinzprog;

public class SevenColumnPrimes extends Thread {

  private int zaehler;


  public static void main(String[] args) {
    for (int i = 0; i < 7; i++) {
      SevenColumnPrimes thread = new SevenColumnPrimes(i);
      thread.start();
    }
  }


  public SevenColumnPrimes(int zaehler) {
    this.zaehler = zaehler;
  }

  @Override
  public void run() {
    int n = 7351;
    for (int i = 2; i <= n; i++) {
      boolean primzahl = true;
      for (int f = 2; f < i; f++) {
        if (i % f == 0) {
          primzahl = false;
          break;
        }
      }
      if (primzahl) {
        for (int x = 0; x <= zaehler; x++) {
          System.out.print("    ");
        }
        System.out.println(i);

      }
    }
  }
}
