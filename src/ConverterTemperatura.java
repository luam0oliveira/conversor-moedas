import javax.swing.*;

public class ConverterTemperatura extends Converter {
    private JPanel mainPanel;
    private JPanel valuesPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel lblOutput;
    private JButton btnCalculate;

    public ConverterTemperatura(String title) {
        super(title);

        mainPanel.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
    }

    public ConverterTemperatura() {
        this("Conversor de temperatura");
    }
}
