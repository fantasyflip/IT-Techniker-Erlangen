import javax.swing.JOptionPane;

public class JOptionPaneDemo {

    public static void main(String[] args) {
        // --- MESSAGE DIALOG ---
        // Displays a simple message box
        JOptionPane.showMessageDialog(
                null,
                "<html> <div style='color: red; background: blue'>OptionPane Demo</div> </html>",
                "Message Dialog",
                JOptionPane.INFORMATION_MESSAGE
        );

        // --- INPUT DIALOG ---
        // Asks the user to input their name
        String name = JOptionPane.showInputDialog(
                null,
                "Name?",
                "Input Dialog",
                JOptionPane.QUESTION_MESSAGE
        );

        // If user cancels or closes the dialog, name will be null
        if (name == null || name.isEmpty()) {
            name = "Fremder";
        }

        // --- CONFIRM DIALOG ---
        // Asks the user a Yes/No/Cancel type question.
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Weiter, " + name + "?",
                "Confirm Dialog",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Handle the user’s response
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Weiter geht's!",
                    "Response",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else if (confirm == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Bye.",
                    "Response",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Abbruch!",
                    "Response",
                    JOptionPane.PLAIN_MESSAGE
            );
        }

        // --- OPTION DIALOG ---
        // Custom option dialog
        Object[] options = {"Speichern", "Nicht speichern", "Abbrechen"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Fortschritt speichern?",
                "Option Dialog",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,      // no custom icon
                options,   // custom button labels
                options[0] // default selected option
        );

        // Interpret the result of the user's choice
        switch (choice) {
            case 0:
                JOptionPane.showMessageDialog(null, "Fortschritt gespeichert!", "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Fortschritt nicht gespeichert.", "Result", JOptionPane.WARNING_MESSAGE);
                break;
            case 2:
            default:
                JOptionPane.showMessageDialog(null, "Aktion abgebrochen.", "Result", JOptionPane.PLAIN_MESSAGE);
                break;
        }

        // --- END ---
        // Final message before exiting
        JOptionPane.showMessageDialog(
                null,
                "Demo beendet, " + name + ".",
                "Goodbye",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
