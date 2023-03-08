import utils.TextFilter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Format;
import java.util.Formatter;

public class ConverterTemperature extends Converter {
    private JPanel mainPanel;
    private JPanel valuesPanel;
    private JComboBox cbFromType;
    private JComboBox cbToType;
    private JLabel lblOutput;
    private JButton btnCalculate;
    private JTextField tfValueOne;

    public ConverterTemperature(String title) {
        super(title);
        TemperatureEnum[] temperatures = TemperatureEnum.values();
        for (TemperatureEnum temperature:
             temperatures) {
            cbFromType.addItem(temperature);
            cbToType.addItem(temperature);
        }

        btnCalculate.addActionListener(l -> {
            calculate();
        });

        tfValueOne.setDocument(new TextFilter());

        mainPanel.setVisible(true);
        setContentPane(mainPanel);
        pack();
    }

    public ConverterTemperature() {
        this("Conversor de temperatura");
    }

    public void calculate() {
        Double output = 0.0;
        Double input = Double.parseDouble(tfValueOne.getText());

        if(cbFromType.getSelectedItem().equals(cbToType.getSelectedItem())){
            output = Double.parseDouble(tfValueOne.getText());
        }else if(cbFromType.getSelectedItem() == TemperatureEnum.CELSIUS){
            if(cbToType.getSelectedItem() == TemperatureEnum.FAHRENHEIT){
                output = ((input * 9/5 )+ 32);
            }else {
                output = input + 273.15;
            }
        }else if(cbFromType.getSelectedItem() == TemperatureEnum.FAHRENHEIT){
            if(cbToType.getSelectedItem() == TemperatureEnum.CELSIUS){
                output = (input - 32) * 5/9;
            }else {
                output = (input - 32) * 5/9 + 273.15;
            }
        }else{
            if(cbToType.getSelectedItem() == TemperatureEnum.CELSIUS){
                output = input - 273.15;
            }else {
                output = (input - 273.15) * 9/5 + 32;
            }
        }
        lblOutput.setText(String.format("%.2f", output));
    }
}
