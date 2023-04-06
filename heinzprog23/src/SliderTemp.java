import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Java Programm zur Konvertierung von Temperaturen, Celsius zu Fahrenheit und umgekehrt.
 * GUI erstellt mit Swing.
 *
 *  @author Stefan Janke 214 058
 *  @author Filippo Fiorenza 205 194
 *  @author Tarik Bugra Kalkan 205 302
 *
 */
public class SliderTemp extends JFrame implements ChangeListener {

  JSlider celsiusSlider;
  JSlider fahrenheitSlider;
  JLabel celsius;
  JLabel fahrenheit;
  JTextField degreeCelsius;
  JTextField degreeFahrenheit;

  /**
   * Klasse zum Erstellen von Labels, Slider und Textfeldern und deren Eigenschaften.
   */
  public SliderTemp() {
    setTitle("Temperature Converter");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    /*
     * Erstellen von Slider für die Temperatur in Celsius mit Parameter und Eigenschaften.
     * Erstellen von Textfield "Celsius".
     */
    celsius = new JLabel("Celsius");
    celsiusSlider = new JSlider(SwingConstants.HORIZONTAL, -300, 500, 20);
    celsiusSlider.setMajorTickSpacing(100);
    celsiusSlider.setMinorTickSpacing(50);
    celsiusSlider.setPaintTicks(true);
    celsiusSlider.setPaintLabels(true);
    celsiusSlider.setPreferredSize(new Dimension(500, 50));
    celsiusSlider.addChangeListener(this);
    celsiusSlider.setName("celsiusSlider");
    degreeCelsius = new JTextField(4);
    degreeCelsius.setText(celsiusSlider.getValue() + " ");
    /*
     * Erstellen von Slider für die Temperatur in Fahrenheit mit Parameter und Eigenschaften.
     * Erstellen von Textfield "Fahrenheit".
     */
    fahrenheit = new JLabel("Fahrenheit");
    fahrenheitSlider = new JSlider(SwingConstants.HORIZONTAL, -300, 500, 68);
    fahrenheitSlider.setMajorTickSpacing(100);
    fahrenheitSlider.setMinorTickSpacing(50);
    fahrenheitSlider.setPaintTicks(true);
    fahrenheitSlider.setPaintLabels(true);
    fahrenheitSlider.setPreferredSize(new Dimension(500, 50));
    fahrenheitSlider.addChangeListener(this);
    fahrenheitSlider.setName("fahrenheitSlider");
    degreeFahrenheit = new JTextField(4);
    degreeFahrenheit.setText(fahrenheitSlider.getValue() + " ");
    /*
     * Hinzufügen von Labels, Slider und Text fields in das Pane.
     */
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(celsius);
    getContentPane().add(celsiusSlider);
    getContentPane().add(degreeCelsius);
    getContentPane().add(fahrenheit);
    getContentPane().add(fahrenheitSlider);
    getContentPane().add(degreeFahrenheit);
    degreeCelsius.setEditable(false);
    degreeFahrenheit.setEditable(false);
  }

  /**
   * Main zum Erstellen des Fensters mit größe und Eigenschaften.
   */
  public static void main(String[] args) {
    SliderTemp tempConverter = new SliderTemp();
    tempConverter.setSize(650, 150);
    tempConverter.setResizable(false);
    tempConverter.setVisible(true);
  }

  /**
   * Listener für die Slider um die Temperatur umzurechnen und an die Textfelder zu übergeben.
   */
  @Override
  public void stateChanged(ChangeEvent e) {
    JSlider data;
    data = (JSlider) e.getSource();
    if (data.getName().equals("celsiusSlider")) {
      degreeCelsius.setText(data.getValue() + "");
      degreeFahrenheit.setText(data.getValue() * 1.8 + 32 + "");
      fahrenheitSlider.setValue((int) (data.getValue() * 1.8 + 32));
    }
    if (data.getName().equals("fahrenheitSlider")) {
      degreeFahrenheit.setText(data.getValue() + "");
      degreeCelsius.setText((data.getValue() - 32) * 5 / 9 + "");
      celsiusSlider.setValue((data.getValue() - 32) * 5 / 9);
    }
  }
}
