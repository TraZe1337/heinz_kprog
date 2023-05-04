package ListAufgabe;

import java.util.ArrayList;

public class Umfuelllisten {

  int a;
  int b;
  int c;
  int d;
  int e;

  public static void main(String[] args) {

    new Umfuelllisten(3, 2, 3, 2, 3);
  }

  public Umfuelllisten(int a, int b, int c, int d, int e) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
    int firstArray[] = new int[a];
    int secondArray[] = new int[b];
    int thirdArray[] = new int[c];
    int fourthArray[] = new int[d];
    int fifthArray[] = new int[e];

    System.out.println("Kapazitäten sind: ( " + firstArray.length + " " + secondArray.length + " " +
        thirdArray.length + " " + fourthArray.length + " " + fifthArray.length + " )");
    System.out.println("Fünftupel sind: ");

    boolean run = true;
    while (run) {
      int max = firstArray.length;
      for (int i = 0; i <= max; i++) {
        System.out.println("( " + a + " " + b + " " + c + " " + d + " " + e + " )");
        secondArray[i] = 1;
      }
      run = false;

    }

  }

  //TODO: Behälter 1 ist zu Beginn voll Wasser, die anderen sind leer.

  //TODO: 1  2; 1  4; 2  3; 3  5; 4  2; 5  4.


}
