package Fraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.Before;
import org.junit.Test;

public class fractiontests {

  Fraction[] i = {
      new Fraction(17, 91), new Fraction(78, 85), new Fraction(19, 51),
      new Fraction(23, 38), new Fraction(29, 33), new Fraction(77, 29),
      new Fraction(95, 23), new Fraction(77, 19), new Fraction(1, 17),
      new Fraction(11, 13), new Fraction(13, 11), new Fraction(15, 2),
      new Fraction(1, 7), new Fraction(55, 1)};


  @Before
  public void setup() {

  }

  //TODO : Write Test for negative Fractions.
  //TODO : Write Test for intValue()
  //TODO : Write Test for floatValue()
  //TODO : Write Test for doubleValue()


  /**
   * Testing the add() Method.
   * 1. Testing if the Value of adding 2 Fractions with each other equals our expected solution.
   */
  @Test
  public void TestAdd() {
    assertEquals(new Fraction(8543, 7735).intValue(), i[0].add(i[1]).intValue());
  }

  /**
   * Testing the subtract() Method.
   * 1. Testing if the Value of subtracting 2 Fractions with each other equals our expected solution.
   */
  @Test
  public void TestSubtract() {
    assertEquals(new Fraction(5653, 7735).intValue(), i[1].subtract(i[0]).intValue());
  }

  /**
   * Testing the multiply() Method.
   * 1. Testing if the Value of multiplying 2 Fractions with each other equals our expected solution.
   */
  @Test
  public void TestMultiply() {
    assertEquals(new Fraction(6, 35).intValue(), i[0].multiply(i[1]).intValue());

  }

  /**
   * Testing the divide() Method.
   * 1. Testing if the Value of dividing 2 Fractions with each other equals our expected solution.
   */
  @Test
  public void TestDivide() {
    Fraction j = new Fraction(13, 5);
    assertEquals(j.intValue(), i[1].divide(i[2]).intValue());
  }

  /**
   * Testing the isInteger() Method.
   * 1. Testing if the Value of a Fraction is a Integer or not.
   */
  @Test
  public void IsIntegerTest() {
    assertFalse(i[1].isInteger());
    assertFalse(new Fraction("4124125134124124", "5235235235235235235").isInteger());
    assertTrue(new Fraction(12, 3).isInteger());
    assertFalse(new Fraction(13, 3).isInteger());
  }

  /**
   * Testing the toString() Method.
   * 1.Testing that the Object of the toString() Method is in fact a String.
   * 2.Testing for the Result of the toString() Method.
   */
  @Test
  public void TestToString() {
    String string = " ";
    assertInstanceOf(string.getClass(),i[0].toString());
    assertEquals("17/91", i[0].toString());
  }

  /**
   * Testing the getNumerator() Method.
   * 1. Testing the function of the getNumerator() Method.
   */
  @Test
  public void NumeratorTest() {
    assertEquals(78, i[1].getNumerator().intValue());

  }

  /**
   * Testing the getDenominator() Method.
   * 1. Testing the function of the getDenominator() Method.
   */
  @Test
  public void DenominatorTest() {
    assertEquals(85, i[1].getDenominator().intValue());
  }

  /**
   * Testing the longValue() Method.
   */
  @Test
  public void longValueTest() {


  }


}
