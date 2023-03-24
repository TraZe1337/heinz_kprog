package Fraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.Test;

public class Fractiontests {

  Fraction[] i = {
      new Fraction(17, 91), new Fraction(78, 85), new Fraction(19, 51),
      new Fraction(23, 38), new Fraction(29, 33), new Fraction(77, 29),
      new Fraction(95, 23), new Fraction(77, 19), new Fraction(1, 17),
      new Fraction(11, 13), new Fraction(13, 11), new Fraction(15, 2),
      new Fraction(1, 7), new Fraction(55, 1)};


  /**
   * Testing the add() Method. 1. Testing if the Value of adding 2 Fractions with each other equals
   * our expected solution.
   */
  @Test
  public void testAdd() {
    assertEquals(new Fraction(8543, 7735).intValue(), i[0].add(i[1]).intValue());
  }

  /**
   * Testing the subtract() Method. 1. Testing if the Value of subtracting 2 Fractions with each
   * other equals our expected solution.
   */
  @Test
  public void testSubtract() {
    assertEquals(new Fraction(5653, 7735).intValue(), i[1].subtract(i[0]).intValue());
  }

  /**
   * Testing the multiply() Method. 1. Testing if the Value of multiplying 2 Fractions with each
   * other equals our expected solution.
   */
  @Test
  public void testMultiply() {
    assertEquals(new Fraction(6, 35).intValue(), i[0].multiply(i[1]).intValue());
    assertEquals(new Fraction(-3, 4).intValue(), new Fraction(-5,2).multiply(new Fraction(3,10)).intValue());
    assertEquals(new Fraction(3, 4).intValue(), new Fraction(-5,2).multiply(new Fraction(-3,10)).intValue());
    //assertEquals(new Fraction(5));

  }

  /**
   * Testing the divide() Method. 1. Testing if the Value of dividing 2 Fractions with each other
   * equals our expected solution.
   */
  @Test
  public void testDivide() {
    Fraction j = new Fraction(13, 5);
    assertEquals(j.intValue(), i[1].divide(i[2]).intValue());
  }

  /**
   * Testing the isInteger() Method. 1. Testing if the Value of a Fraction is a Integer or not.
   */
  @Test
  public void isIntegerTest() {
    assertFalse(i[1].isInteger());
    assertFalse(new Fraction("4124125134124124", "5235235235235235235").isInteger());
    assertTrue(new Fraction(12, 3).isInteger());
    assertFalse(new Fraction(13, 3).isInteger());
  }

  /**
   * Testing the toString() Method. 1.Testing that the Object of the toString() Method is in fact a
   * String. 2.Testing for the Result of the toString() Method.
   */
  @Test
  public void testToString() {
    String string = " ";
    assertInstanceOf(string.getClass(), i[0].toString());
    assertEquals("17/91", i[0].toString());
  }

  /**
   * Testing the getNumerator() Method. 1. Testing the function of the getNumerator() Method.
   */
  @Test
  public void numeratorTest() {
    Fraction a = new Fraction(142, 412);
    assertEquals(78, i[1].getNumerator().intValue());
    assertEquals(142, a.getNumerator().intValue());

  }

  /**
   * Testing the getDenominator() Method. 1. Testing the function of the getDenominator() Method.
   */
  @Test
  public void denominatorTest() {
    assertEquals(91, i[0].getDenominator().intValue());
    assertEquals(85, i[1].getDenominator().intValue());
    assertEquals(51, i[2].getDenominator().intValue());
    assertEquals(38, i[3].getDenominator().intValue());

  }

  /**
   * Testing the longValue() Method.
   */
  @Test
  public void longValueTest() {
    Fraction a = new Fraction(5135150, 10);
    assertEquals(513515, a.longValue(), 1);
    assertNotEquals(4142124, a.longValue(), 2);
  }

  /**
   * Testing the floatValue() Method.
   */
  @Test
  public void floatValueTest() {
    Fraction l = new Fraction(1, 2);
    assertEquals(0.5, l.floatValue(), 1);
    assertNotEquals(1.2, l.longValue(), 1);
  }

  /**
   * Testing the doubleValue() Method.
   */
  @Test
  public void doubleValueTest() {
    assertEquals(7.5, i[11].doubleValue(), 1);
    assertNotEquals(1.2, i[11].doubleValue(), 1);
  }


  /**
   * Testing the longValue() Method. 1.Comparing 2 Fractions with each other. 1 is expected because
   * Fraction 1 is smaller than Fraction 2. 1.Comparing 2 Fractions with each other. -1 is expected
   * because Fraction 2 is smaller than Fraction 1.
   */
  @Test
  public void compareToTest() {
    Fraction f = new Fraction(-523525, -52352);
    Fraction x = new Fraction(4124124, 43252);
    assertEquals(1, f.compareTo(x));
    assertEquals(-1, x.compareTo(f));
  }

  /**
   * Tests whether fractions can become negative and are calculated properly
   */
  @Test
  public void negativeFractionsTest() {
    Fraction k = new Fraction(-384, 7);
    Fraction j = new Fraction(-6528,637);
    Fraction l = new Fraction(-17, 4992);
    assertEquals(k.intValue(), i[12].subtract(i[13]).intValue());
    assertEquals(j.intValue(), i[0].multiply(k).intValue());
    assertEquals(l.intValue(), i[0].divide(k).intValue());
  }

  /**
   * Tests whether fractions can be divided by zero, and throws an exception if they can.
   * There was an error in the program because this was possible.
   */
  @Test
  public void exceptionTest() {
    Fraction f = new Fraction(14, 29);
    Fraction zero = new Fraction(0, 0);
    assertThrows(NullPointerException.class, () -> {
      f.divide(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      f.divide(zero);
    });

  }
}
