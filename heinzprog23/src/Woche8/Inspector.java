package Woche8;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.Math;
import java.math.BigInteger;

public class Inspector {

  /**
   * @author Filippo Fiorenza, Stefan Janke, Tarik Kalkan
   */

  public static void main (String[] args){
    BufferedReader in = new BufferedReader (new InputStreamReader(
        new DataInputStream(System.in))); // zum Lesen von Eingaben
    while (true) {
      try {
        System.out.print ("Klassenname oder ende eingeben: ");
        String buf = in.readLine(); // eine Zeile lesen
        if (buf.toLowerCase().startsWith ("end")) { break; } // Abbruch
        Class c = Class.forName (buf); // versuche Klasse zu laden
        Object o = c.newInstance (); // versuche Objekt zu instantiieren
        runTests(o);
        printTables(buf);
      } catch (IOException e) {
        System.out.println(e);
      } catch (ClassNotFoundException e) { // Klasse nicht gefunden
        System.out.println ("Klasse nicht gefunden");
      } catch (ClassCastException e) { // kann nicht gecastet werden
        System.out.println (e);
      } catch (InstantiationException e) { // etwa bei abstrakter Klasse ...
        System.out.println (e);
      } catch (IllegalAccessException e) { // etwa Konstruktor nicht verfügbar
        System.out.println (e);
      }
    }
  }
  public static void runTests (Object tester) { // ruft test-Methoden fuer tester auf
    Class clazz = tester.getClass(); // Klasse bestimmen
    Method[] methods = clazz.getMethods(); // Methoden ermitteln
    int cnt = 0;
    for (Method m : methods) { // alle Methoden anschauen:
      String name = m.getName(); // Name der Methode ermitteln
      if (!name.startsWith("test")) // Methodenname soll mit "test" anfangen
      { continue; } // wenn nicht: naechstes i
      Class[] paras = m.getParameterTypes(); // Parameter ermitteln
      if (paras.length > 0) // Methode soll parameterlos sein
      { continue; } // wenn nicht: naechstes i
      int modifiers = m.getModifiers(); // Modifizierer ermitteln
      if (Modifier.isStatic (modifiers)) // Decodieren, ob Methode static ist
      { continue; } // wenn ja: naechste Methode
      ++cnt; // getestete Methoden zaehlen
      System.out.println ("Aufgerufen wird: " + name);
      try {
        m.invoke (tester, new Object[0]); // Methode aufrufen
      } catch (Exception e) {
        System.err.println (e);
      }
      System.out.println ("--");
    } // end for
    if (cnt <= 0) {
      System.out.println ("Keine Testmethoden gefunden"); // ...
    }
  }

  public static void printTables (String name){
    try {
      Class testclass = Class.forName (name); // Klasse laden
      Method[] methods = testclass.getMethods(); // Methoden laden
      for (Method m : methods) { // fuer alle Methoden:
        Class[] paras = m.getParameterTypes(); // formale Parameter besorgen
        if (paras.length != 1 || paras[0] != Double.TYPE) { // Test ob ein double-Param.
          continue; // wenn nicht: naechste Methode
        }
        if (m.getReturnType() != Double.TYPE) { // Test auf Return-Wert double
          continue; // wenn nicht: naechste Methode
        }
        if (!Modifier.isStatic(m.getModifiers())){ // Test auf statische Methode
          continue;
        }
        System.out.println ("Wertetabelle fuer " + m.getName());
        Object[] actargs = new Object[1];
        for (int j=-10; j<=10; j+=2) { // fuer j in –10 .. 10
          double x = (double)j/10; // x in –1.0 .. 1.0
          System.out.println(" " + x + " -> " + // Ausgabe
              m.invoke (null, actargs)); // Aufruf der Methode
        } // end for j
      } // end for m : methods
    } catch (Exception e) {
      System.err.println(e);
    }
  } // end printTables


}
