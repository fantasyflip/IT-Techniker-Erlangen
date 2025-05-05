// Diese Klasse ist eine benutzerdefinierte Ausnahme (Exception).
// Sie wird verwendet, um einen bestimmten Fehlerzustand in der Anwendung zu signalisieren:
// dass ein ungültiger Name für einen Patienten eingegeben wurde.
// Sie erbt von der Standard-Java-Klasse `RuntimeException`, was bedeutet, dass es sich um eine
// nicht-überprüfte Ausnahme handelt (unchecked exception). Das bedeutet, dass Methoden, die diese
// Ausnahme werfen könnten, dies nicht explizit in ihrer Signatur deklarieren müssen (`throws UngueltigerNameException`).
// Aufrufende Methoden sind nicht gezwungen, diese Ausnahme abzufangen oder weiterzuwerfen,
// obwohl sie es tun können, wenn sie den Fehler behandeln möchten. RuntimeExceptions werden oft für
// Programmierfehler oder unerwartete Zustände verwendet, die zur Laufzeit auftreten können.
public class UngueltigerNameException extends RuntimeException{

    // Dies ist der Konstruktor, der eine Fehlermeldung entgegennimmt.
    // Die übergebene Nachricht wird an den Konstruktor der übergeordneten Klasse `RuntimeException`
    // weitergegeben, wo sie gespeichert und über die Methode `getMessage()` abgerufen werden kann.
    // Diese Nachricht beschreibt den spezifischen Grund für den ungültigen Namen.
    public UngueltigerNameException(String message){
        super(message);
    }

}