package MaxxiMax;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author tarik kalkan
 * version 1 01.01.2023
 */
public final class MyIO {
    private MyIO() {}

    static Scanner sc = new Scanner(System.in);

    public static String promptAndRead(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static int readInt (String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine().trim());
    }

    public static float readFloat (String prompt) {
        System.out.print(prompt);
        return Float.parseFloat(sc.nextLine().trim());
    }

    public static double readDouble (String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine().trim());
    }
    public static BigInteger readBigInteger (String prompt) {
        System.out.print(prompt);
        return BigInteger.valueOf(Long.parseLong(sc.nextLine().trim()));
    }
    public static BigDecimal readBigDecimal (String prompt) {
        System.out.print(prompt);
        return BigDecimal.valueOf(Long.parseLong(sc.nextLine().trim()));
    }
    public static Richtung promptAndReadRichtung(String prompt) {

        while (true) {
            System.out.print(prompt);
            String eingabe = sc.nextLine();
            if (eingabe.equals("OBEN") || eingabe.equals("UNTEN") || eingabe.equals("RECHTS") || eingabe.equals("LINKS") ||
                    eingabe.equals("OBEN_RECHTS") || eingabe.equals("UNTEN_LINKS")) {
                return Richtung.valueOf(eingabe);
            }
            System.out.println("Eingabe ungültig bitte nochmal eingeben");
        }
    }

    public static void write (String s) {
        System.out.print(s);
    }

    public static void writeln (String s){
        System.out.println(s);
    }

}
