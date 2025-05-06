import java.util.Random;

// Abstract: Es kann keine Instanz der Klasse Patient erstellt werden.
// Lediglich von der Klasse Patient abstammende Klassen wie "Kassenpatient" oder
// "Privatpatient" können instanziiert werden. Patient legt lediglich die Grundstruktur fest.
// Das macht Sinn, weil ein Patient immer entweder privatversichert oder kassenversichert ist.
// Allerdings teilen sowohl private als auch Kassenpatienten viele Eigenschaften. Deshalb sammelt man diese
// Eigenschaften in der Grundklasse Patient.
// Damit die nicht instanziiert werden kann, macht man sie abstrakt.

// Implements: Das Interface "Person" wird auf die Klasse Patient angewandt. Die Klasse "Patient" muss somit
// alle Methoden aus dem Interface "Person" enthalten. Da "Patient" abstract ist, würde kein Fehler auftreten,
// wenn eine Methode aus dem Interface nicht implementiert wäre. Dafür wird dann aber in den Subklassen erzwungen,
// dass die entsprechende Methode definiert ist. Vorteil eines Interface ist die Mehrfachvererbung.
// Eine abstrakte Klasse kann zwar mehrere Kindklassen haben, aber immer nur eine Elternklasse.
// Interfaces hingegen können mehrfach auf Klassen angewandt werden.
// Somit ist es hier möglich sowohl das Interface "Person" als auch das Interface "Mensch" auf die
// Klasse "Patient" anzuwenden.

// PraxisVollException ist eine Kindklasse von Exception und NICHT von RuntimeException.
// Das bedeutet, dass diese Ausnahme explizit in der Methodensignatur deklariert werden muss und
// vom aufrufenden Code entweder gefangen oder weiter geworfen werden muss.

// UngueltigerNameException ist eine Kindklasse von RuntimeException.
// Das bedeutet, dass diese Ausnahme eine "unchecked exception" ist und nicht explizit
// in der Methodensignatur deklariert werden muss, aber sie kann dennoch gefangen werden.

abstract class Patient implements Person, Mensch {
    private String name;
    private String vorname;
    private int patientNr;
    private int alter;
    // Static: Die Variable ist unabhängig von der Instanz und ist für jede Instanz der Klasse Patient gleich.
    // Das bedeutet egal auf welcher Instanz von "Patient" die Variable "anzahl" verwendet wird,
    // befindet sich immer der gleiche Wert dahinter. Hier macht das Sinn, da hier eine allgemeine Information
    // gespeichert werden soll, die unabhängig vom eigentlichen Patienten ist. Es wird gespeichert
    // wie viele Patienten instanziiert wurden.
    private static int anzahl;

    // Dies ist der Konstruktor der abstrakten Klasse Patient.
    // Er ist für die Initialisierung der grundlegenden Patientendaten zuständig.

    // WICHTIG: Dieser Konstruktor deklariert explizit, dass er eine 'PraxisVollException' werfen kann.
    // Da 'PraxisVollException' eine checked exception ist, MUSS sie hier deklariert werden, damit der Compiler weiß,
    // dass diese Ausnahme auftreten kann.
    // Die 'UngueltigerNameException' ist eine unchecked exception, daher muss sie nicht explizit mit 'throws'
    // deklariert werden. Zur Klarheit wird es hier dennoch gemacht.

    // Deklaration mit 'throws' ist hier eine gute Praxis, um den Aufrufer zu informieren,
    // dass diese Fehler auftreten können.
    public Patient(String name, String vorname, int alter) throws PraxisVollException, UngueltigerNameException {
        // Dieser Block prüft, ob die maximale Anzahl von Patienten (hier 6) erreicht ist.
        // Wenn ja, wird eine 'PraxisVollException' geworfen.
        // Da 'PraxisVollException' eine checked exception ist, MUSS der Code, der diesen Konstruktor aufruft,
        // diese Ausnahme behandeln (entweder abfangen oder weiterwerfen).
        // Das Werfen einer Ausnahme unterbricht die normale Ausführung des Konstruktors.
        // Der Code nach dem 'throw' wird nicht ausgeführt, wenn die Bedingung erfüllt ist.
        if(anzahl >= 6){
            throw new PraxisVollException("Maximale Patientenanzahl erreicht");
        } else {
            // Dieser Block prüft die Gültigkeit des übergebenen Namens.
            // Wenn der Name null oder leer ist, wird eine 'UngueltigerNameException' geworfen.
            // Da 'UngueltigerNameException' eine unchecked exception ist, MUSS der Aufrufer sie nicht behandeln,
            // aber er KANN es tun, wie im 'main'-Methodenbeispiel gezeigt.
            if (name == null || name.trim().isEmpty()) {
                throw new UngueltigerNameException("Der Name darf nicht leer sein.");
            }
            // Dieser Block prüft, ob der Name Zahlen enthält.
            // Wenn ja, wird ebenfalls eine 'UngueltigerNameException' geworfen.
            else if (name.matches(".*\\d+.*")) {
                throw new UngueltigerNameException("Der Name darf keine Zahlen enthalten.");
            }
            // Wenn keine der Fehlerbedingungen erfüllt ist, wird der Name zugewiesen.
            else {
                this.name = name;
            }
            // Wenn keine Ausnahmen geworfen wurden, wird der Rest des Konstruktors ausgeführt.
            this.vorname = vorname;
            this.alter = alter;
            anzahl++; // Die Anzahl der Patienten wird nur erhöht, wenn der Konstruktor erfolgreich durchläuft (keine Ausnahme geworfen wurde).
            setPatientNr();
        }
    }

    public String getName(){
        return this.name;
    }

    public String getVorname(){
        return this.vorname;
    }

    public int getAlter(){
        return this.alter;
    }

    public int getPatientNr(){
        return this.patientNr;
    }

    public static int getAnzahl(){
        return anzahl;
    }

    public void setPatientNr(){
        this.patientNr = (int)((Math.random() * 100) + 1)*42;
        // this.patientNr = r.nextInt((9999 - 1000) + 1) + 1000;
    }

    // Jede Klasse stammt von der Klasse "Object" ab,
    // hat also prinzipiell immer ein "extends Object" an der Klassendefinition.
    // Die Klasse "Object" hat eine Methode "toString", die hier in diesem Fall überschrieben wird.
    // Durch das Überschreiben wird beim Aufruf "Patient.toString()" nicht mehr die ursprüngliche Methode
    // der Klasse "Object" verwendet, sondern die hier überschriebene Variante. Genauso kann diese und alle
    // anderen Methoden auch in Klassen, die von Patient abstammen überschrieben werden. Es gilt prinzipiell,
    // dass die erste verfügbare Variante der Methode verwendet wird.
    public String toString(){
        return this.name + ", " + this.vorname + ", " + this.alter + ", " + this.patientNr;
    }

    // Auch Methoden können abstract sein. Damit wird nur vorgegeben, dass die Methode in der
    // Subklasse existieren muss. Es gibt also in "Kassenpatient" und "Privatpatient" zwingend eine
    // Methode "printAbrechnung". Dort muss für diese Methode dann auch Syntax definiert sein.
    // Damit eine Methode abstract sein kann, muss die Klasse auch abstract sein.
    public abstract void printAbrechnung();
}

