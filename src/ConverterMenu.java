import javax.swing.*;

public class ConverterMenu extends JFrame{
    private JComboBox<Converter> cbConversors;
    private JButton btnConfirm;
    private JPanel mainPanel;

    public ConverterMenu() {
        cbConversors.addItem(new ConverterTemperature());
        mainPanel.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

        btnConfirm.addActionListener(l -> {
            this.dispose();
            JFrame frame = (JFrame) cbConversors.getSelectedItem();
            frame.setVisible(true);
        });
    }
}
