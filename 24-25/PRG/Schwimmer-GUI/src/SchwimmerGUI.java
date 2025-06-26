import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SchwimmerGUI extends JFrame {
    JTextField lastName, firstName, className;
    private Schwimmer[] participants = new Schwimmer[100];
    private int participantIndex = 0;
    public SchwimmerGUI() {
        super("Schulmeisterschaft Schwimmen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6,1));

        Font fontHeader = new Font("Courier", Font.ITALIC,20);
        JLabel heading = new JLabel("Teilnehmerin / Teilnehmer", JLabel.CENTER);
        heading.setFont(fontHeader);
        add(heading);

        JPanel lastNamePanel = new JPanel();
        JLabel lastNameLabel = new JLabel("Nachname:");
        lastName = new JTextField(20);
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastName);
        add(lastNamePanel);

        JPanel firstNamePanel = new JPanel();
        JLabel firstNameLabel = new JLabel("Vorname:");
        firstName = new JTextField(20);
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstName);
        add(firstNamePanel);

        JPanel classNamePanel = new JPanel();
        JLabel classNameLabel = new JLabel("Klasse:");
        className = new JTextField(3);
        classNamePanel.add(classNameLabel);
        classNamePanel.add(className);
        add(classNamePanel);

        JButton saveButton = new JButton("Speichern");
        saveButton.addActionListener(e -> {
            String last = lastName.getText();
            String first = firstName.getText();
            String classInfo = className.getText();

            if (participantIndex < participants.length) {
                participants[participantIndex] = new Schwimmer(first, last, classInfo);
                participantIndex++;

                JOptionPane.showMessageDialog(this, "Gespeichert:\n" + first + " " + last + "\nKlasse: " + classInfo);
                resetFields();
            } else {
                JOptionPane.showMessageDialog(this, "Maximale Teilnehmerzahl erreicht!");
            }
        });
        add(saveButton);

        JButton resetButton = new JButton("Eingaben löschen");
        resetButton.addActionListener(e -> {
            resetFields();
        });
        add(resetButton);

        DocumentListener inputListener = new DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { checkFields(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { checkFields(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { checkFields(); } // rarely used

            private void checkFields() {
                boolean enabled = !lastName.getText().trim().isEmpty()
                        && !firstName.getText().trim().isEmpty()
                        && !className.getText().trim().isEmpty();
                saveButton.setEnabled(enabled);
            }
        };

        lastName.getDocument().addDocumentListener(inputListener);
        firstName.getDocument().addDocumentListener(inputListener);
        className.getDocument().addDocumentListener(inputListener);

        saveButton.setEnabled(false);


    }

    private void resetFields() {
        lastName.setText("");
        firstName.setText("");
        className.setText("");
    }

    public static void main(String[] args) {
        SchwimmerGUI gui = new SchwimmerGUI();
        gui.setVisible(true);
    }
}
