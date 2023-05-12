package Woche8;

  public class TestQueue {
    static {
      System.out.println ("TestQueue: Statische Initialisierungen");
    }
    public TestQueue() {
      System.out.println ("TestQueue: Konstruktor");
    }
    static void test0() {
      System.out.println ("TestQueue: test0()");
    }
    public void test1() {
      System.out.println ("TestQueue: test1()");
    }
    public void test2() {
      System.out.println ("TestQueue: test2()");
    }
    public void test3(int i) {
      System.out.println ("TestQueue: test3("+i+")");
    }
//...
  }
