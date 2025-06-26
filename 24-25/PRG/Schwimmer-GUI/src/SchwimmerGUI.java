import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SchwimmerGUI extends JFrame {
    // Textfeld Instanzvariablen anlegen
    JTextField lastName, firstName, className;

    // Array für Teilnehmer anlegen
    private Schwimmer[] participants = new Schwimmer[100];
    private int participantIndex = 0;

    // Konstruktor der GUI
    public SchwimmerGUI() {
        // JFrame initialisieren
        super("Schulmeisterschaft Schwimmen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout setzen
        setLayout(new GridLayout(6,1));

        // GUI Komponenten erstellen und hinzufügen
        // Schriftart für Überschrift
        Font fontHeader = new Font("Courier", Font.ITALIC,20);
        // Überschrift
        JLabel heading = new JLabel("Teilnehmerin / Teilnehmer", JLabel.CENTER);
        // Setze Schriftart für Überschrift
        heading.setFont(fontHeader);
        // Füge Überschrift zur GUI hinzu
        add(heading);

        // Panels für Eingabefelder erstellen und hinzufügen
        // Panel erstellen
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

        // Buttons erstellen und hinzufügen
        JButton saveButton = new JButton("Speichern");
        // ActionListener für den Speichern-Button
        saveButton.addActionListener(e -> {
            // Speichern der Eingaben in das Array
            String last = lastName.getText();
            String first = firstName.getText();
            String classInfo = className.getText();

            // Überprüfen, ob der Array voll ist
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

        // Button zum Zurücksetzen der Eingabefelder
        JButton resetButton = new JButton("Eingaben löschen");
        resetButton.addActionListener(e -> {
            resetFields();
        });
        add(resetButton);

        // Überprüfen, ob die Eingabefelder leer sind
        DocumentListener inputListener = new DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { checkFields(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { checkFields(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { checkFields(); } // rarely used

            // Methode zum Überprüfen der Eingabefelder
            private void checkFields() {
                boolean enabled = !lastName.getText().trim().isEmpty()
                        && !firstName.getText().trim().isEmpty()
                        && !className.getText().trim().isEmpty();
                // Aktiviere oder deaktiviere den Speichern-Button basierend auf den Eingabefeldern
                saveButton.setEnabled(enabled);
            }
        };

        lastName.getDocument().addDocumentListener(inputListener);
        firstName.getDocument().addDocumentListener(inputListener);
        className.getDocument().addDocumentListener(inputListener);

        // Deaktiviere den Speichern-Button initial
        saveButton.setEnabled(false);


    }

    // Methode zum Zurücksetzen der Eingabefelder
    private void resetFields() {
        lastName.setText("");
        firstName.setText("");
        className.setText("");
    }

    // Main-Methode zum Starten der GUI
    public static void main(String[] args) {
        SchwimmerGUI gui = new SchwimmerGUI();
        gui.setVisible(true);
    }
}
