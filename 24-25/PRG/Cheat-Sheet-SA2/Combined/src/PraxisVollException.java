// Diese Klasse ist eine benutzerdefinierte Ausnahme (Exception).
// Sie wird verwendet, um einen bestimmten Fehlerzustand in der Anwendung zu
// signalisieren:
// Dass die maximale Anzahl von Patienten in der Praxis erreicht wurde.
// Sie erbt von der Standard-Java-Klasse `Exception`, was bedeutet, dass es sich um eine
// überprüfte Ausnahme handelt (checked exception). Das bedeutet, dass Methoden, die
// diese Ausnahme werfen könnten, dies in ihrer Signatur deklarieren müssen
// (`throws PraxisVollException`)
// und aufrufende Methoden diese Ausnahme entweder abfangen (`catch`) oder ebenfalls
// weiterwerfen müssen.
public class PraxisVollException extends Exception{

    // Dies ist der Standardkonstruktor. Er wird verwendet, wenn die Ausnahme ohne
    // eine spezifische Fehlermeldung erstellt wird.
    public PraxisVollException(){}

    // Dies ist ein überladener Konstruktor, der eine formatierte Fehlermeldung
    // entgegennimmt. Er verwendet die Methode `String.format()` um die übergebenen
    // Argumente in die Nachricht einzufügen. Die formatierte Nachricht wird dann an den
    // Konstruktor der übergeordneten Klasse `Exception` weitergegeben, wo sie
    // gespeichert und über die Methode `getMessage()` abgerufen werden kann.
    public PraxisVollException( String format, Object... args ) {
        super( String.format( format, args ) );
    }
}