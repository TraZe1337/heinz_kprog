package heinzprog;

public class PrimeTree extends Thread {

  private int buffer = -1;

  private PrimeTree left;
  private PrimeTree right;
  private int p;

  public static void main(String[] args) {
    for (int i = 2; i <= 100; i++) {
      PrimeTree primetree = new PrimeTree(i);
      primetree.start();
    }
    PrimeTree lastthread = new PrimeTree(0);
    lastthread.start();
  }


  public PrimeTree(int prime) {
    super();
    p = prime;

  }

  @Override
  public void run() {
    System.out.println(p);
    while (true) {
      int n = receive();
      if (n == 0) {
        if (right != null || left != null) {
          right.send(n);
          left.send(n);
        }
        break;
      }
      if (n % p != 0) {
        if (right != null || left != null) {
          left.send(n);
          right.send(3 * n + 1);
        }
      } else {
        right = new PrimeTree(3 * n + 1);
        left = new PrimeTree(n);
      }
    }
  }

  synchronized void send(int i) {
    try {
      while (buffer >= 0) {
        wait();
      }
      buffer = i;
      notify();
    } catch (InterruptedException e) {
      throw new IllegalArgumentException(" ");
    }
  }

  synchronized int receive() {
    int result = 0;
    try {
      while ((result = buffer) < 0) {
        wait();
      }
      buffer = -1;
      notify();
    } catch (InterruptedException e) {
      throw new IllegalArgumentException(" ");
    }
    return result;
  }
// Läuft unendlich weiter
}
