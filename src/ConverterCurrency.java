import utils.TextFilter;

import javax.swing.*;

public class ConverterCurrency extends Converter{
    private JPanel mainPanel;
    private JPanel valuesConversor;
    private JComboBox cbToType;
    private JButton btnCalculate;
    private JTextField tfInputValue;
    private JComboBox cbFromType;
    private JLabel lblOutput;

    public ConverterCurrency(String title) {
        super(title);

        for (CurrencyEnum currency:
                CurrencyEnum.values()) {
            cbFromType.addItem(currency);
            cbToType.addItem(currency);
        }

        btnCalculate.addActionListener(l -> {
            calculate();
        });

        tfInputValue.setDocument(new TextFilter());

        mainPanel.setVisible(true);
        setContentPane(mainPanel);
        pack();
    }

    public ConverterCurrency() {
        this("Conversor de moeda");
    }

    public void calculate() {
        Double output = 0.0;
        Double input;
        try {
            input = Double.parseDouble(tfInputValue.getText());
        }catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um valor válido!");
            return;
        }

        if(cbFromType.getSelectedItem().equals(cbToType.getSelectedItem())){
            output = Double.parseDouble(tfInputValue.getText());
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.REAL){
            if(cbToType.getSelectedItem() == CurrencyEnum.EURO){
                output = input * 0.18390078;
            }else if(cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 0.19456501;
            }else if(cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.16308199;
            }else if(cbToType.getSelectedItem() == CurrencyEnum.YEN) {
                output = input * 26.492881;
            }else {
                output = input * 257.17976;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.EURO) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 5.4403689;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 1.0580281;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.88715297;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.YEN) {
                output = input * 144.10891;
            } else {
                output = input * 1398.7773;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.DOLAR) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 5.141664;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 0.94520729;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.83876177;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.YEN) {
                output = input * 136.22885;
            } else {
                output = input * 1322.2537;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.LIBRA) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 6.1298439;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 1.1267623;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 1.1921553;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.YEN) {
                output = input * 162.42438;
            } else {
                output = input * 1576.665;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.YEN) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 0.037719207;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 0.0069383654;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 0.0073407472;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.0061577868;
            } else {
                output = input * 9.7080198;
            }
        } else {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 0.003884434;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 0.00071478827;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 0.00075614085;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.00063432039;
            } else {
                output = input * 0.10300666;
            }
        }
        lblOutput.setText(String.format("%.2f", output));
    }
}
