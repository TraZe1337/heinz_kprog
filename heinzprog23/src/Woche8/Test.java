package Woche8;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {

  public static void main (String[] args) { //
    if (args.length <= 0) {
      System.err.println ("Aufruf: java Test <KlassenName>");
      System.exit(1);
    }
    Object tester = createTestObject (args[0]); // Objekt erzeugen
    runTests (tester); // Tests darauf durchfuehren
  } // end main


  public static Object createTestObject (String name) { // liefert Objekt zu name
    Object ret = null;
    try {
      System.out.println ("Laden von: " + name);
      Class testclass = Class.forName (name); // Klasse laden
      System.out.println ("--");
      System.out.println ("Instanzieren von: " + name);
      ret = testclass.newInstance(); // Klasse instanzieren
      System.out.println ("--");
    } catch (ClassNotFoundException e) {
      System.err.println ("Kann Klasse nicht laden: " + name);
    } catch (InstantiationException e) {
      System.err.println ("Fehler beim Instanzieren: " + name);
    } catch (IllegalAccessException e) {
      System.err.println ("Unerlaubter Zugriff auf: " + name);
    }
    return ret;
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


}
