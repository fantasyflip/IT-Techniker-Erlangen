public class PatientTest {
    public static void main(String[] args) {
        // Patient ist eine abstrakte Klasse. Eine Instanziierung wie
        // Patient p1  = new Patient();
        // würde also nicht funktionieren. Allerdings lässt sich ein Array der Elternklasse anlegen.
        // In diesen Array können dann alle Subklassen der Elternklasse gespeichert werden.
        // In diesem Beispiel können "Kassenpatient" und "Privatpatient" in einem Array von Patienten
        // gespeichert werden, da sie beide von der Klasse "Patient" abstammen.
        Patient[] patienten = new Patient[6];

        // Der 'try'-Block umschließt Code, der potenziell eine Ausnahme (Exception) auslösen kann.
        // In diesem Fall kann der Konstruktor der Klasse "Patient" Exceptions werfen.
        // Da die Exceptions in den Klassen "Kassenpatient" und "Privatpatient" nicht behandelt werden,
        // werden die Exceptions weiter geworfen und müssen teilweise an dieser Stelle nun behandelt werden.
        // Nur teilweise ein Muss da eine Exception von RuntimeException abstammt. Siehe Patient.
        try {
            patienten[0] = new Privatpatient("Meier", "Hans", 45);
            patienten[1] = new Kassenpatient("Müller", "Peter", 23, true);

            // Wenn die folgenden Zeilen ausgeführt werden würden, würde das eine "PraxisVollException" werfen,
            // da in "Patient" definiert ist, dass ab 6 Patienten die Praxis voll ist.
            // patienten[2] = new Kassenpatient("Müller", "Daniela", 51, false);
            // patienten[3] = new Kassenpatient("Müller", "Daniela", 51, false);
            // patienten[4] = new Kassenpatient("Müller", "Daniela", 51, false);
            // patienten[5] = new Kassenpatient("Müller", "Daniela", 51, false);

            // Wenn die folgende Zeile ausgeführt werden würde, würde das eine "UngueltigerNameException" werfen,
            // da in "Patient" definiert ist, dass ein Name keine Zahl enthalten darf
            // patienten[2] = new Kassenpatient("Müller02", "Daniela", 51, false);
        }

        // Die Reihenfolge der 'catch'-Blöcke ist wichtig: Spezifischere Ausnahmen sollten zuerst gefangen werden,
        // gefolgt von allgemeineren Ausnahmen. In diesem Fall sind beide Ausnahmen spezifisch und werden einzeln abgefangen.
        // Alternativ könnte man auch beide Exceptions allgemein abfangen, indem man mit der Elternklasse "Exception" arbeitet.

        // Der erste 'catch'-Block fängt spezifisch die 'UngueltigerNameException' ab.
        // Wenn eine 'UngueltigerNameException' im 'try'-Block geworfen wird, wird der Code in diesem 'catch'-Block ausgeführt.
        catch (UngueltigerNameException e) {
            // Hier wird die Fehlermeldung der Ausnahme auf der Konsole ausgegeben.
            System.out.println("Fehler: " + e.getMessage());
        }

        // Der zweite 'catch'-Block fängt spezifisch die 'PraxisVollException' ab.
        // Wenn eine 'PraxisVollException' im 'try'-Block geworfen wird (und keine 'UngueltigerNameException' zuvor gefangen wurde),
        // wird der Code in diesem 'catch'-Block ausgeführt.
        catch (PraxisVollException e) {
            // Auch hier wird die Fehlermeldung der Ausnahme auf der Konsole ausgegeben.
            e.printStackTrace();
        }

        // Allgemeines Abfangen jedes Fehlers
        catch (Exception e) {
            e.printStackTrace();
        }

        // Nach dem 'try-catch'-Block wird die Programmausführung fortgesetzt, unabhängig davon,
        // ob eine Ausnahme aufgetreten ist oder nicht (solange sie gefangen wurde).
        // Wenn eine Ausnahme auftritt und gefangen wird, wird der Rest des 'try'-Blocks übersprungen,
        // aber der Code nach dem 'catch'-Block wird ausgeführt.


        // Da in der Elternklasse definiert ist, dass es eine Methode "toString" gibt kann diese Methode
        // auch auf den im Array aus Patienten gespeicherten Objekten ausgeführt werden. Je nachdem ob
        // das betroffene Objekt dann ein "Kassenpatient" oder ein "Privatpatient" ist, wird die
        // entsprechende Version der Methode "toString" ausgeführt. Der Aufruf der Methode
        // "getFamilienversichert", die nur in "Kassenpatient" definiert wurde, würde dementsprechend
        // nicht funktionieren.
        for(int i = 0; i < patienten.length; i++){
            // Überspringen von leeren Zellen des Arrays
            if(patienten[i]== null) break;
            // Hier steht eigentlich:
            // System.out.println(patienten[i].toString());
            // Der Methodenaufruf ".toString()" kann hier allerdings ignoriert werden.
            System.out.println(patienten[i]);
            // System.out.println(patienten[i].getFamilienversichert()); // Funktioniert nicht!
        }

        // Konsole:
        // Meier, Hans, 45, 0
        // Müller, Peter, 23, 0, familienversichert

        System.out.println(patienten[0].getAnzahl()); // Konsole: 2

        try {
            Kassenpatient kp1 = new Kassenpatient("Mustermann", "Max", 34, false);

            // Ausführen der Methode "getName" aus der Elternklasse
            System.out.println(kp1.getName()); // Konsole: Mustermann
            // Ausführen der, in "Kassenpatient" überladenen, Methode "getName"
            System.out.println(kp1.getName("Herr")); // Konsole: Name: Mustermann

            // Aufruf der Default-Methode aus dem Interface "Person"
            System.out.println(kp1.getIdentitaet()); // Konsole: Mustermann, Max

        } catch (UngueltigerNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        } catch (PraxisVollException e) {
            e.printStackTrace();
        }


        // Aufruf der statischen Methode aus dem Interface "Person"
        Person.printHello(); // Konsole: Hello World!


        try {
            // Erstellen eines Zweibettzimmers. Es wird angenommen, dass nur gleiche Patiententypen gemeinsam in ein Zimmer dürfen
            Kassenpatient kpA = new Kassenpatient("Schmidt", "Andreas", 44, false);
            Kassenpatient kpB = new Kassenpatient("Hartmann", "Fixi", 22, true);

            // In den </> Klammern wird der generischen Klasse der Datentyp übergeben
            ZweiBettZimmer<Kassenpatient> zimmer1 = new ZweiBettZimmer<>(kpA, kpB);

            // Da nur Patienten des gleichen Typs in ein Zimmer dürfen, wäre folgender Aufruf nicht möglich
            //  Kassenpatient kpA = new Kassenpatient("Schmidt", "Andreas", 44, false);
            //  Privatpatient ppA = new Kassenpatient("Hartmann", "Fixi", 22);
            //  ZweiBettZimmer<Kassenpatient> zimmer1 = new ZweiBettZimmer<>(kpA, ppA);

            zimmer1.printBelegung();
            // Konsole:
            // Zimmerbelegung:
            // Fensterseite: Schmidt, Andreas, 44, 3528, nicht familienversichert
            // Wandseite: Hartmann, Fixi, 22, 294, familienversichert

            printFensterbett(zimmer1); // Konsole: Schmidt, Andreas, 44, 2394, nicht familienversichert

            printWandbett(zimmer1); // Konsole: Hartmann, Fixi, 22, 630, familienversichert
        }
        catch (PraxisVollException e){
            e.printStackTrace();
        }

    }

    // Diese Methode verwendet keinen generischen Datentyp für die Übergabe des Parameters.
    // Da bei generischen Datentypen die Vererbung allerdings irrelevant ist, kann diese Methode
    // niemals aufgerufen werden. Das liegt daran, dass es kein ZweiBettZimmer vom Typ "Patient"
    // geben kann, da "Patient" abstrakt ist. Es kann also nur "Kassenpatient" oder "Privatpatient"
    // sein. Hätte die Methode "ZweiBettZimmer<Privatpatient> bett" als Parameter könnte die Methode
    // aufgerufen werden. Allerdings nicht mit einem ZweiBettZimmer vom Typ "Kassenpatient".
    // Um das zu lösen gibt es zwei Möglichkeiten:
    // 1. Methode mit generischem Datentyp
    // 2. Methode mit einer Wildcard
    public static boolean gleicherName(ZweiBettZimmer<Patient> bett){
        return bett.getFensterSeite().getName().equals(bett.getWandSeite().getName());
    }

    // Auch Methoden können generische Datentypen verwenden. Diese Methode kann sowohl
    // ein Zweibettzimmer mit Privatpatienten, als auch eins mit Kassenpatienten verarbeiten.
    public static <T extends Patient> void printFensterbett(ZweiBettZimmer<T> bett){
        System.out.println(bett.getFensterSeite().toString());
    }

    // Alternativ kan auch mit einer Wildcard gearbeitet werden. Damit wird die doppelte
    // Prüfung des korrekten generischen Datentyps vermieden. Es wird nur bei der Instanziierung
    // der generischen Klasse geprüft.
    public static void printWandbett(ZweiBettZimmer<?> bett){
        System.out.println(bett.getWandSeite().toString());
    }
}
