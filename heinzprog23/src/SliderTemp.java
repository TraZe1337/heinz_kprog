import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTemp extends JFrame implements ChangeListener {

  JSlider celsiusSlider;
  JSlider fahrenheitSlider;
  JTextField degreeCelsius;
  JTextField degreeFahrenheit;

  public SliderTemp() {
    setTitle("Temperature Converter");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    celsiusSlider = new JSlider(SwingConstants.HORIZONTAL, -100, 100, 20);
    celsiusSlider.setMajorTickSpacing(20);
    celsiusSlider.setMinorTickSpacing(50);
    celsiusSlider.setPaintTicks(true);
    celsiusSlider.setPaintLabels(true);
    celsiusSlider.setPreferredSize(new Dimension(300, 50));
    celsiusSlider.addChangeListener(this);
    celsiusSlider.setName("celsiusSlider");

    degreeCelsius = new JTextField(4);
    degreeCelsius.setText(celsiusSlider.getValue() + " ");

    fahrenheitSlider = new JSlider(SwingConstants.HORIZONTAL, -20, 140, 40);
    fahrenheitSlider.setMajorTickSpacing(20);
    fahrenheitSlider.setMinorTickSpacing(50);
    fahrenheitSlider.setPaintTicks(true);
    fahrenheitSlider.setPaintLabels(true);
    fahrenheitSlider.setPreferredSize(new Dimension(300, 50));
    fahrenheitSlider.addChangeListener(this);
    fahrenheitSlider.setName("fahrenheitSlider");

    degreeFahrenheit = new JTextField(4);
    degreeFahrenheit.setText(fahrenheitSlider.getValue() + " ");

    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(celsiusSlider);
    getContentPane().add(degreeCelsius);
    getContentPane().add(fahrenheitSlider);
    getContentPane().add(degreeFahrenheit);
    degreeCelsius.setEditable(false);
    degreeFahrenheit.setEditable(false);
  }

  public static void main(String[] args) {
    SliderTemp tempConverter = new SliderTemp();
    tempConverter.setSize(400, 150);
    tempConverter.setResizable(false);
    tempConverter.setVisible(true);
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    JSlider data;
    data = (JSlider) e.getSource();
    if (!data.getValueIsAdjusting() && data.getName().equals("celsiusSlider")) {
      degreeCelsius.setText(data.getValue() + " ");
      degreeFahrenheit.setText(data.getValue() * 1.8 + 32 + " ");
      fahrenheitSlider.setValue((int) (data.getValue() * 1.8 + 32));
    }
    if (data.getName().equals("fahrenheitSlider")) {
      degreeFahrenheit.setText(data.getValue() + " ");
      degreeCelsius.setText((data.getValue() - 32) * 5 / 9 + " ");
      celsiusSlider.setValue((data.getValue() - 32) * 5 / 9);
    }
  }
}
