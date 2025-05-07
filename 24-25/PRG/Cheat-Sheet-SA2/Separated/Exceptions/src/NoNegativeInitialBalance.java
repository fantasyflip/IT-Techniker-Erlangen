// Diese Klasse ist eine benutzerdefinierte Ausnahme (Exception).
// Sie wird verwendet, um einen bestimmten Fehlerzustand in der Anwendung zu signalisieren:
// Dass ein negativer Startbetrag übergeben wurde.
// Sie erbt von der Standard-Java-Klasse `Exception`, was bedeutet, dass es sich um eine
// überprüfte Ausnahme handelt (checked exception). Das bedeutet, dass Methoden, die diese
// Ausnahme werfen könnten, dies in ihrer Signatur deklarieren müssen (`throws NoNegativeInitialBalance`)
// und aufrufende Methoden diese Ausnahme entweder abfangen (`catch`) oder ebenfalls weiterwerfen müssen.
// Wird eine Checked Exception geworfen, wird der try-Block an dieser Stelle beendet.
public class NoNegativeInitialBalance extends Exception {
    public NoNegativeInitialBalance(String message) {
        super(message);
    }
}
