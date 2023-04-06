import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class IdealWeight extends JFrame implements ActionListener {

  JRadioButton genderM, genderF; // Knöpfe für Geschlecht
  ButtonGroup genderGroup; // ... dazu Knopfgruppe
  JPanel genderPanel; // ... dazu Panel
  JRadioButton heightA, heightB, heightC, heightD, heightE; // Kn. Grösse
  ButtonGroup heightGroup; // ... Gruppe
  JPanel heightPanel; // ... Panel
  JTextField resultText; // Textfeld für Ergebnis
  JLabel resultLabel; // ... dazu Label
  JPanel resultPanel; // ... dazu Panel
  int height;

  public IdealWeight() { // Konstruktor
    setTitle("Your Ideal Weight"); // Fenstertitel
    setDefaultCloseOperation(EXIT_ON_CLOSE); // zum Fensterschliessen

    // Geschlechts-Gruppe
    genderM = new JRadioButton("Male", true); // Knopf M. selekt.
    genderM.setName("male");
    genderM.addActionListener(this);
    genderF = new JRadioButton("Female", false); // Knopf F. nicht s.
    genderF.setName("female");
    genderF.addActionListener(this);
    genderGroup = new ButtonGroup(); // Gruppe def.
    genderGroup.add(genderM);
    genderGroup.add(genderF); // Kn. hinzufuegen
    genderPanel = new JPanel(); // G.-Panel
    genderPanel.setLayout( // Layout
        new BoxLayout(genderPanel, BoxLayout.Y_AXIS)); // ... vertikal
    genderPanel.add(new JLabel("Your Gender")); // Label &
    genderPanel.add(genderM);
    genderPanel.add(genderF); // Knoepfe hinzuf.
    // Hoehen-Gruppe
    heightA = new JRadioButton("60 to 64 inches", true); // ... selektiert
    heightA.setName("heightA");
    heightA.addActionListener(this);
    heightB = new JRadioButton("64 to 68 inches", false); // nicht selektiert
    heightB.setName("heightB");
    heightB.addActionListener(this);
    heightC = new JRadioButton("68 to 72 inches", false); // ...
    heightC.setName("heightC");
    heightC.addActionListener(this);
    heightD = new JRadioButton("72 to 76 inches", false); // ...
    heightD.setName("heightD");
    heightD.addActionListener(this);
    heightE = new JRadioButton("76 to 80 inches", false); // ...
    heightE.setName("heightE");
    heightE.addActionListener(this);
    heightGroup = new ButtonGroup(); // Gruppe def.
    heightGroup.add(heightA);
    heightGroup.add(heightB); // Kn.
    heightGroup.add(heightC);
    heightGroup.add(heightD); // ... hinzufuegen
    heightGroup.add(heightE); // ...
    heightPanel = new JPanel(); // H-Panel
    heightPanel.setLayout( // Layout
        new BoxLayout(heightPanel, BoxLayout.Y_AXIS)); // ... vertikal
    heightPanel.add(new JLabel("Your Height")); // Label &
    heightPanel.add(heightA);
    heightPanel.add(heightB); // Kn. hinzufuegen
    heightPanel.add(heightC);
    heightPanel.add(heightD); // ...
    heightPanel.add(heightE); // ...
    // Ergebnis-Panel
    resultText = new JTextField(7); // Textfeld
    resultText.setEditable(false); // ... nur Ausgabe
    resultText.addActionListener(this);
    resultLabel = new JLabel("Ideal Weight"); // Label def.
    resultPanel = new JPanel(); // Panel def.
    resultPanel.add(resultLabel); // Label hinzufuegen
    resultPanel.add(resultText); // Textfeld ...
    // Gesamt-Fenster
    getContentPane().setLayout(new BorderLayout()); // Layout: Border
    getContentPane().add(genderPanel, BorderLayout.WEST); // G-Panel hinzuf.
    getContentPane().add(heightPanel, BorderLayout.EAST); // H-Panel ...
    getContentPane().add(resultPanel, BorderLayout.SOUTH); // Ergebnis-Panel ..
  }

  public static void main(String[] args) { // main ...
    IdealWeight weightApp = new IdealWeight();
    weightApp.setSize(250, 225);
    weightApp.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JRadioButton data;
    data = (JRadioButton) e.getSource();

    switch (data.getName()) {
      case "heightA" -> {

      }
    }

      switch (data.getName()) {
        case "heightA" -> {
          height = 62;
          if (data.getName().equals("male")) {
            resultText.setText(Math.pow(height, 2) / 30 + "");
          }
          if(data.getName().equals("female")) {
            resultText.setText(Math.pow(height, 2) / 28 + "");
          }
        }
        case "heightB" -> {
          height = 66;
          if (data.getName().equals("male")) {
            resultText.setText(Math.pow(height, 2) / 30 + "");
          }
          if(data.getName().equals("female")) {
            resultText.setText(Math.pow(height, 2) / 28 + "");
          }
        }
        case "heightC" -> {
          height = 70;
          if (data.getName().equals("male")) {
            resultText.setText(Math.pow(height, 2) / 30 + "");
          }
          if(data.getName().equals("female")) {
            resultText.setText(Math.pow(height, 2) / 28 + "");
          }
        }
        case "heightD" -> {
          height = 74;
          if (data.getName().equals("male")) {
            resultText.setText(Math.pow(height, 2) / 30 + "");
          }
          if(data.getName().equals("female")) {
            resultText.setText(Math.pow(height, 2) / 28 + "");
          }
        }
        case "heightE" -> {
          height = 78;
          if (data.getName().equals("male")) {
            resultText.setText(Math.pow(height, 2) / 30 + "");
          }
          if(data.getName().equals("female")) {
            resultText.setText(Math.pow(height, 2) / 28 + "");
          }
        }
      }
    }
    public void calculateWeight() {

    }

}