public class Test {
    public static void main(String[] args) {
        // Der 'try'-Block umschließt Code, der potenziell eine Ausnahme (Exception) auslösen kann.
        // In diesem Fall kann der Konstruktor der Klasse "BankAccount" Exceptions werfen.
        // Wenn eine Exception einer Elternklasse in den Kindklassen nicht behandelt wird,
        // muss sie weiter geworfen werden, damit sie später behandelt werden kann.
        try {
            // Der folgende Block wirft eine Exception vom Typ "ExceedWithdrawl",
            // da mehr abgehoben wird als vorhanden ist.
            BankAccount ba = new BankAccount(20.0);
            ba.withdraw(50.0);

            // Die folgende Zeile wirft eine Exception vom Typ "NoNegativeInitialBalance",
            // da ein negativer Wert dem Konstruktor übergeben wird
            BankAccount ba2 = new BankAccount(-20.0);
        }
        // Die Reihenfolge der 'catch'-Blöcke ist wichtig: Spezifischere Ausnahmen sollten zuerst gefangen werden,
        // gefolgt von allgemeineren Ausnahmen. In diesem Fall sind beide Ausnahmen spezifisch und werden einzeln abgefangen.
        // Alternativ könnte man auch beide Exceptions allgemein abfangen, indem man mit der Elternklasse "Exception" arbeitet.

        // Der erste 'catch'-Block fängt spezifisch die 'NoNegativeInitialBalance' ab.
        // Wenn eine 'NoNegativeInitialBalance' im 'try'-Block geworfen wird, wird der Code in diesem 'catch'-Block ausgeführt.
        catch (NoNegativeInitialBalance e) {
            System.out.println(e); // Konsole: NoNegativeInitialBalance: Ein Konto muss zur Erstellung gedeckt sein.
        }
        catch (ExceedWithdrawl e) {
            System.out.println(e.getMessage()); // Konsole: Fehler: Nicht genügend Guthaben vorhanden! Versucht: 50.0, Verfügbar: 20.0
        }
        // Allgemeines Abfangen jedes Fehlers
        catch (Exception e) {
            e.printStackTrace();
        }

        // Nach dem 'try-catch'-Block wird die Programmausführung fortgesetzt, unabhängig davon,
        // ob eine Ausnahme aufgetreten ist oder nicht (solange sie gefangen wurde).
        // Wenn eine Ausnahme auftritt, die keine "RuntimeException" ist, und gefangen wird,
        // wird der Rest des 'try'-Blocks übersprungen, aber der Code nach dem 'catch'-Block wird ausgeführt.

    }
}
