//Notwendige Imports
import javax.swing.*; // Für JFrame etc.
import javax.swing.event.DocumentEvent; // Zum Erstellen des Dokument-Listeners
import javax.swing.event.DocumentListener; // Zum Erstellen des Dokument-Listeners
import java.awt.*; // Datentypen wie JTextField

public class GUI extends JFrame {
    private JTextField name; //Instanzvariablen für Textfelder
    private JTextArea participantsArea;
    private JButton saveButton, resetButton;
    private String [] participants = new String[100];
    private int participantIndex = 0;

    public GUI(){
        super("Test-GUI"); // Setzt den Wert der Titelzeile
        setSize(700, 300); // Setzt die feste größe des GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Legt fest, dass das Programm beendet wird, wenn das Fenster über das X geschlossen wird.
        setResizable(false); // Legt fest, dass das Fenster nicht in der Größe geändert werden kann

        // Layout für Anordnung von links nach rechts (Standard-Layout
        setLayout(new FlowLayout());

        // Layout für ein gleichmäßiges Gitter
        setLayout(new GridLayout());

        // Layout für 5 Bereiche: NORTH, SOUTH, EAST, WEST, CENTER
        setLayout(new BorderLayout());

        // TODO: Weitere Layouts?

        // Layouts sind kombinierbar

        // Panel für linke Spalte
        JPanel inputPanel = new JPanel(new GridLayout(7,2)); // Neues Panel mit 7 Zeilen und 2 Spalten

        // Label generieren
        Font fontHeader = new Font("Courier", Font.ITALIC, 20); // Schriftstil erstellen
        JLabel heading = new JLabel("Teilnehmer", JLabel.CENTER); // Zentrierter Text
        heading.setFont(fontHeader); // Schriftstil anwenden
        inputPanel.add(heading); // Label in Panel einbinden

        // Name Label und Textfeld
        JPanel lastNamePanel = new JPanel(); // Ohne Angabe des Layouts -> FlowLayout
        lastNamePanel.add(new JLabel("Name")); // Label erstellen und in Panel aufnehmen
        name = new JTextField(20); // Textfeld erstellen mit einer Breite von 20 (nicht Zeichenlimit!)
        lastNamePanel.add(name); // Textfeld zum Panel hinzufügen
        inputPanel.add(lastNamePanel); // Name-Panel in Input-Panel aufnehmen

        // Speichern Button
        saveButton = new JButton("Speichern"); // Button anlegen und beschriften
        saveButton.setEnabled(false); // Button aktivieren oder deaktivieren
        // ActionListener um Aktion auszuführen beim triggern des Buttons
        saveButton.addActionListener(e -> {
            String nameString = name.getText().trim(); // Input aus Textfeld erhalten und Leerzeichen entfernen

            if(!nameString.isEmpty()){
                participants[participantIndex++] = nameString; // Namen in Array abspeichern und Index um eins erhöhen
                name.setText(""); // Feld leeren nach dem Speichern

                // Anzeige-Bereich aktualisieren
                String displayText = "";
                for(int i = 0; i < participantIndex; i++){
                    displayText += participants[i] + "\n";
                }
                participantsArea.setText(displayText);
            }
        });
        inputPanel.add(saveButton); // Button in Panel aufnehmen

        // Dokument überwachen, um auf korrekte Eingabe zu prüfen und nur dann den Speichern-Button zu aktivieren
        DocumentListener inputListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validateInput();} // Reagiert auf inserts
            public void removeUpdate(DocumentEvent e) { validateInput();} // Reagiert auf entfernen
            public void changedUpdate(DocumentEvent e) { validateInput();} // Reagiert auf Änderungen

            public void validateInput(){
                boolean validInput = !name.getText().trim().isEmpty(); // Prüfen, ob der Input leer ist oder nicht
                saveButton.setEnabled(validInput);
            }
        };

        name.getDocument().addDocumentListener(inputListener); // Document-Listener auf Textfeld binden um Events zu überwachen und entsprechend zu reagieren

        // Reset-Button
        resetButton = new JButton("Eingaben löschen"); // Button anlegen und beschriften
        resetButton.addActionListener(e -> {
            name.setText(""); // Textfeld-Inhalt leeren
        });
        inputPanel.add(resetButton); // Button in Panel aufnehmen


        add(inputPanel, BorderLayout.CENTER); // inputPanel in GUI aufnehmen

        participantsArea = new JTextArea(); // Textfeld anlegen
        participantsArea.setEditable(false); // Nicht editierbar machen
        JScrollPane participantsScroll = new JScrollPane(participantsArea); // Scroll-Fläche anlegen, da unbekannt ist wie lang das Textfeld einmal sein wird
        participantsScroll.setPreferredSize(new Dimension(400, 300)); // Startgröße des Scroll-Felds festlegen
        add(participantsScroll, BorderLayout.EAST); // Scroll-Bereich rechts von Input-Panel anzeigen


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true)); // GUI starten
    }
}
