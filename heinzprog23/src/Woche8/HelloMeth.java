package Woche8;

interface HelloMeth { // Interface
  public void hello();
}
class CA implements HelloMeth { // Implementierung A
  public void hello() {
    System.out.println ("hello CA");
  }
}
class CB implements HelloMeth { // Implementierung B
  public void hello() {
    System.out.println ("hello CB");
  }
}
class CC { // keine Implementierung
  public void hello() {
    System.out.println ("hello CC");
  }
}
class CD { // keine Implementierung
  public void hallo() {
    System.out.println ("hallo CD");
  }
}
