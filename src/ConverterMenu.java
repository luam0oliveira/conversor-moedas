import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ConverterMenu extends JFrame{
    private JComboBox<Converter> cbConversors;
    private JButton btnConfirm;
    private JPanel mainPanel;

    public ConverterMenu() {
        cbConversors.addItem(new ConverterTemperature());
        cbConversors.addItem(new ConverterCurrency());
        mainPanel.setVisible(true);

        setSize(new Dimension(400, 150));
        setResizable(false);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                int opt = JOptionPane.showInternalConfirmDialog(null, "Deseja mesmo encerrar?", "Tem certeza?", JOptionPane.YES_NO_OPTION);
                if (opt==0) {
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Menu de conversores");
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
