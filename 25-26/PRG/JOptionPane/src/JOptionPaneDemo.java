import javax.swing.JOptionPane;

public class JOptionPaneDemo {

    public static void main(String[] args) {
        // --- 1️⃣ MESSAGE DIALOG ---
        // Displays a simple message box with information for the user.
        JOptionPane.showMessageDialog(
                null,
                "Willkommen zur OptionPane Demo!",
                "Message Dialog",
                JOptionPane.INFORMATION_MESSAGE
        );

        // --- 2️⃣ INPUT DIALOG ---
        // Asks the user to input a value (e.g., their name).
        String name = JOptionPane.showInputDialog(
                null,
                "Wie heißt du?",
                "Input Dialog",
                JOptionPane.QUESTION_MESSAGE
        );

        // If user cancels or closes the dialog, name will be null
        if (name == null || name.isEmpty()) {
            name = "Fremder";
        }

        // --- 3️⃣ CONFIRM DIALOG ---
        // Asks the user a Yes/No/Cancel type question.
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Möchtest du fortfahren, " + name + "?",
                "Confirm Dialog",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Handle the user’s response
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Toll, lass uns weiter machen!",
                    "Response",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else if (confirm == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Okay, bis zum nächsten Mal.",
                    "Response",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Aktion abgebrochen!",
                    "Response",
                    JOptionPane.PLAIN_MESSAGE
            );
        }

        // --- 4️⃣ OPTION DIALOG ---
        // Lets you define custom button labels and behavior.
        Object[] options = {"Speichern", "Nicht speichern", "Abbrechen"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Möchtest du deinen Fortschritt speichern?",
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
        // Notify the user that the demo is complete.
        JOptionPane.showMessageDialog(
                null,
                "Demo beendet. Vielen Dank fürs Teilnehmen, " + name + ".",
                "Goodbye",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
