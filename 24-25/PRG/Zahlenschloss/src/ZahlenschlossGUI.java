import javax.swing.*;

public class ZahlenschlossGUI {
    private JTextField keyInputField;
    private JButton buttons[] = new JButton[10];
    private JButton resetButton;
    final String CORRECT_CODE = "187";

    public ZahlenschlossGUI() {


        JFrame frame = new JFrame("Zahlenschloss");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setResizable(false);


        keyInputField = new JTextField(3);
        keyInputField.setEditable(false);
        keyInputField.setHorizontalAlignment(JTextField.CENTER);

        frame.add(keyInputField, "North");

        JPanel numberPanel = new JPanel();



        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(e -> {
                String currentText = keyInputField.getText();
                if (currentText.length() < 3) { // Maximal 3 Ziffern
                    keyInputField.setText(currentText + e.getActionCommand());
                }
                if (keyInputField.getText().equals(CORRECT_CODE)) {
                    JOptionPane.showMessageDialog(frame, "Zahlenschloss geöffnet!");
                } else if (keyInputField.getText().length() == 3) {
                    JOptionPane.showMessageDialog(frame, "Falscher Code! Bitte versuchen Sie es erneut.");
                    keyInputField.setText("");
                }
            });
            numberPanel.add(buttons[i]);
        }


        resetButton = new JButton("Zurücksetzen");
        resetButton.addActionListener(e -> {
            keyInputField.setText("");
        });

        frame.add(resetButton, "South");

        frame.add(numberPanel, "Center");
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ZahlenschlossGUI gui = new ZahlenschlossGUI();
    }
}
