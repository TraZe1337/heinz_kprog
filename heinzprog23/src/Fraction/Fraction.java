package Fraction;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;


public final class Fraction extends Number implements Comparable<Fraction>, Cloneable,
    Serializable {

  public static final long serialVersionUID = -5403983242734219454L;


  public final static Fraction NaN = new Fraction(0, 0);
  //public final static Fraction ZERO = new Fraction(0, 1);
  public static final Fraction FIFTY_THREE = new Fraction(53, 1);

  private final BigInteger numerator;
  private final BigInteger denominator;


  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }


  public Fraction(BigInteger num, BigInteger denom) {

    switch (denom.signum()) {
      case 0:
        num = ZERO;
        break;
      case -1:
        num = num.negate();
        denom = denom.negate();
      case 1:
        BigInteger gcd = num.gcd(denom);
        num = num.divide(gcd);
        denom = denom.divide(gcd);
    }
    numerator = num;
    denominator = denom;
  }

  public Fraction(long numerator, long denominator) {
    this(valueOf(numerator), valueOf(denominator));
  }

  public Fraction(String numerator, String denominator) {
    this(new BigInteger(numerator), new BigInteger(denominator));
  }

  public Fraction add(Fraction r) {
    if (this.numerator.equals(BigInteger.ZERO)) {
      return r;
    }

    return new Fraction(
        this.numerator.multiply(r.denominator).add(r.numerator.multiply(this.denominator)),
        this.denominator.multiply(r.denominator)
    );
  }

  public Fraction subtract(Fraction r) {
    return new Fraction(
        this.numerator.multiply(r.denominator).subtract(r.numerator.multiply(this.denominator)),
        this.denominator.multiply(r.denominator)
    );
  }

  public Fraction multiply(Fraction r) {
    return new Fraction(this.numerator.multiply(r.numerator),
        this.denominator.multiply(r.denominator));
  }

  public Fraction divide(Fraction r) {
    return new Fraction(this.numerator.multiply(r.denominator),
        this.denominator.multiply(r.numerator));
  }

  boolean isInteger() {
    return this.numerator.remainder(this.denominator).equals(BigInteger.ZERO);
  }


  @Override
  public String toString() {
    return denominator.signum() == 0 ? "NaN" : numerator
        + (denominator.equals(ONE) ? "" : "/" + denominator);
  }

  @Override
  public int compareTo(Fraction o) {
    if (this.equals(NaN) && o.equals(NaN)) {
      return 0;
    }
    if (this.equals(NaN)) {
      return 1;
    }
    if (o.equals(NaN)) {
      return -1;
    }
    return numerator.multiply(o.denominator).compareTo(o.numerator.multiply(denominator));
  }

  @Override
  public int intValue() {
    return numerator.divide(denominator).intValue();
  }

  @Override
  public long longValue() {
    return numerator.divide(denominator).longValue();
  }

  @Override
  public float floatValue() {
    return BigDecimal.valueOf(doubleValue()).floatValue();
  }

  @Override
  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }

  public static void main(String[] args) {
    Fraction[] L = {
        new Fraction(17, 91), new Fraction(78, 85), new Fraction(19, 51),
        new Fraction(23, 38), new Fraction(29, 33), new Fraction(77, 29),
        new Fraction(95, 23), new Fraction(77, 19), new Fraction(1, 17),
        new Fraction(11, 13), new Fraction(13, 11), new Fraction(15, 2),
        new Fraction(1, 7), new Fraction(55, 1)};

    System.out.println("Fractrain ... ");
    System.out.println("Unsere " + L.length + " Fractions: ");
    System.out.println(Arrays.toString(L));
    System.out.println();

    Fraction b = new Fraction(8, 1);
    Fraction max = b;
    int maxpos = 1;
    System.out.println("Die List der ersten b-Zahlen: ");
    for (int i = 1; i <= 19200; i++) {
      if (i <= 3825 || i == 8000 || i == 19200) {
        System.out.println(i + " " + b);
      }
      for (Fraction f : L) {
        Fraction z = b.multiply(f);
        if (z.isInteger()) {
          b = z;
          break;
        }
      }
      if (i <= 800 && b.compareTo(max) > 0) {
        max = b;
        maxpos = i;
      }
    }

  }

  public class BubbleComparables {

    public void bubbleSort(Comparable[] comps) {
      boolean sorted;
      do {
        sorted = true;
        for (int i = 0; i < comps.length - 1; i++) {
          if (comps[i].compareTo(comps[i + 1]) > 0) {
            Comparable tmp = comps[i];
            comps[i] = comps[i + 1];
            comps[i + 1] = tmp;
            sorted = false;
          }
        }
      } while (!sorted);
    }
  }

}





