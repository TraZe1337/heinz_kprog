import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTemp extends JFrame implements ChangeListener {

  JSlider celsiusSlider, fahrenheitSlider;
  JTextField degreeCelsius, degreeFahrenheit;

  public SliderTemp() {
    setTitle("Temperature Converter");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    celsiusSlider = new JSlider(SwingConstants.HORIZONTAL, -100, 100,20);
    fahrenheitSlider = new JSlider(SwingConstants.HORIZONTAL, -20, 150, 40);

    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(celsiusSlider);
    getContentPane().add(degreeCelsius);
    getContentPane().add(fahrenheitSlider);
    getContentPane().add(degreeFahrenheit);
    degreeCelsius.setEditable(false);
    degreeFahrenheit.setEditable(false);
  }

  @Override
  public void stateChanged(ChangeEvent e) {

  }

  public static void main(String[] args){
    SliderTemp tempConverter = new SliderTemp();
    tempConverter.setSize(400, 150);
    tempConverter.setResizable(false);
    tempConverter.setVisible(true);
  }
}
