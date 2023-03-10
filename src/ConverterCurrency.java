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
            }else if(cbToType.getSelectedItem() == CurrencyEnum.PESO_ARGENTINO) {
                output = input * 38.713134;
            }else {
                output = input * 153.69487;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.EURO) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 5.4403689;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 1.0580281;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.88715297;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.PESO_ARGENTINO) {
                output = input * 213.79302;
            } else {
                output = input * 848.8106;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.DOLAR) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 5.141664;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 0.94520729;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.83876177;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.PESO_ARGENTINO) {
                output = input * 200.44822;
            } else {
                output = input * 795.66031;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.LIBRA) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 6.1298439;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 1.1267623;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 1.1921553;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.PESO_ARGENTINO) {
                output = input * 242.18976;
            } else {
                output = input * 961.31824;
            }
        } else if(cbFromType.getSelectedItem() == CurrencyEnum.PESO_ARGENTINO) {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 0.025829298;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 0.0046763516;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 0.0049913706;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.0041285088;
            } else {
                output = input * 3.9666584;
            }
        } else {
            if (cbToType.getSelectedItem() == CurrencyEnum.REAL) {
                output = input * 0.0065143548;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.EURO) {
                output = input * 0.0011804863;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.DOLAR) {
                output = input * 0.0012606818;
            } else if (cbToType.getSelectedItem() == CurrencyEnum.LIBRA) {
                output = input * 0.0010421158;
            } else {
                output = input * 0.2527137;
            }
        }
        lblOutput.setText(String.format("%.2f", output));
    }
}
