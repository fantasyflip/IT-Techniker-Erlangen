// Diese Klasse ist eine benutzerdefinierte Ausnahme (Exception).
// Sie wird verwendet, um einen bestimmten Fehlerzustand in der Anwendung zu signalisieren:
// Dass der abzuhebende Betrag den Kontostand übersteigt.
// Sie erbt von der Standard-Java-Klasse `RuntimeException`, was bedeutet, dass es sich um eine
// nicht-überprüfte Ausnahme handelt (unchecked exception). Das bedeutet, dass Methoden, die diese
// Ausnahme werfen könnten, dies nicht explizit in ihrer Signatur deklarieren müssen (`throws ExceedWithdrawl`).
// Aufrufende Methoden sind nicht gezwungen, diese Ausnahme abzufangen oder weiterzuwerfen,
// obwohl sie es tun können, wenn sie den Fehler behandeln möchten.
// RuntimeExceptions werden oft für Programmierfehler oder unerwartete Zustände verwendet,
// die zur Laufzeit auftreten können.
// Eine Runtime Exception bricht einen try-Block nicht ab.
public class ExceedWithdrawl extends RuntimeException {
    public ExceedWithdrawl(String message) {
        super(message);
    }
}
