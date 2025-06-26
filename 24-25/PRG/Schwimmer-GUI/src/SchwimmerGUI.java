import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SchwimmerGUI extends JFrame {
    // Anlegen der Instanzvariablen
    private JTextField lastName, firstName, className;
    private Schwimmer[] participants = new Schwimmer[100];
    private int participantIndex = 0;
    private JTextArea participantsArea;
    private JButton saveButton, resetButton;

    public SchwimmerGUI() {
        super("Schulmeisterschaft Schwimmen");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Layout für zwei Spalten
        setLayout(new BorderLayout());

        // Linke Spalte mit Eingaben
        JPanel inputPanel = new JPanel(new GridLayout(7, 1));

        Font fontHeader = new Font("Courier", Font.ITALIC, 20);
        JLabel heading = new JLabel("Teilnehmerin / Teilnehmer", JLabel.CENTER);
        heading.setFont(fontHeader);
        inputPanel.add(heading);

        // Nachname
        JPanel lastNamePanel = new JPanel();
        lastNamePanel.add(new JLabel("Nachname:"));
        lastName = new JTextField(20);
        lastNamePanel.add(lastName);
        inputPanel.add(lastNamePanel);

        // Vorname
        JPanel firstNamePanel = new JPanel();
        firstNamePanel.add(new JLabel("Vorname:"));
        firstName = new JTextField(20);
        firstNamePanel.add(firstName);
        inputPanel.add(firstNamePanel);

        // Klasse
        JPanel classPanel = new JPanel();
        classPanel.add(new JLabel("Klasse:"));
        className = new JTextField(3);
        classPanel.add(className);
        inputPanel.add(classPanel);

        // Speichern
        saveButton = new JButton("Speichern");
        saveButton.setEnabled(false);
        // ActionListener für speichern
        saveButton.addActionListener(e -> {
            String last = lastName.getText().trim();
            String first = firstName.getText().trim();
            String klasse = className.getText().trim();

            if (!last.isEmpty() && !first.isEmpty() && !klasse.isEmpty()) {
                if (participantIndex < participants.length) {
                    participants[participantIndex++] = new Schwimmer(first, last, klasse);
                    updateParticipantsArea();
                    resetFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Maximale Teilnehmerzahl erreicht!");
                }
            }
        });
        inputPanel.add(saveButton);

        // Eingaben löschen
        resetButton = new JButton("Eingaben löschen");
        // ActionListener für zurücksetzen
        resetButton.addActionListener(e -> {
            resetFields();
            saveButton.setEnabled(false);
        });
        inputPanel.add(resetButton);

        // Teilnehmer zurücksetzen
        JButton resetParticipantsButton = new JButton("Teilnehmer zurücksetzen");
        resetParticipantsButton.addActionListener(e -> {
            resetParticipants();
            updateParticipantsArea();
        });
        inputPanel.add(resetParticipantsButton);

        add(inputPanel, BorderLayout.CENTER);

        // Rechte Spalte: Teilnehmerliste
        participantsArea = new JTextArea();
        participantsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(participantsArea);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        add(scrollPane, BorderLayout.EAST);







        // DocumentListener zur Validierung der Eingaben
        DocumentListener inputListener = new DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateInput(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateInput(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateInput(); }

            private void validateInput() {
                boolean ready = !lastName.getText().trim().isEmpty()
                        && !firstName.getText().trim().isEmpty()
                        && !className.getText().trim().isEmpty();
                saveButton.setEnabled(ready);
            }
        };

        lastName.getDocument().addDocumentListener(inputListener);
        firstName.getDocument().addDocumentListener(inputListener);
        className.getDocument().addDocumentListener(inputListener);
    }

    private void resetFields() {
        lastName.setText("");
        firstName.setText("");
        className.setText("");
    }

    private void resetParticipants() {
        participants = new Schwimmer[100];
        participantIndex = 0;
        participantsArea.setText("");
    }

    private void updateParticipantsArea() {
        String text = "";
        for (int i = 0; i < participantIndex; i++) {
            text += (i + 1) + ". " + participants[i] + "\n";
        }
        participantsArea.setText(text);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SchwimmerGUI().setVisible(true));
    }
}
