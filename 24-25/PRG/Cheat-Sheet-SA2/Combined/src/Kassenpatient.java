public class Kassenpatient extends Patient {
    private boolean familienversichert;

    /**
     * Konstruktor für die Klasse Kassenpatient.
     * Initialisiert einen neuen Kassenpatienten.
     *
     * WICHTIG: Dieser Konstruktor MUSS "throws PraxisVollException" deklarieren,
     * weil der Aufruf des Elternkonstruktors mit "super(name, vorname, alter)"
     * eine PraxisVollException werfen kann. PraxisVollException MUSS behandelt werden: Siehe Patient
     *
     * Der Kassenpatient-Konstruktor wirft die Ausnahme nicht selbst direkt,
     * sondern er muss deklarieren, dass die Ausnahme, die vom "super()"-Aufruf
     * kommen kann, an den Aufrufer des Kassenpatient-Konstruktors weitergegeben wird.
     *
     * @param name Der Name des Patienten.
     * @param vorname Der Vorname des Patienten.
     * @param alter Das Alter des Patienten.
     * @param familienversichert Gibt an, ob der Patient familienversichert ist.
     * @throws PraxisVollException Wird vom Elternkonstruktor geworfen und hier weitergegeben,
     *                              wenn die Praxis voll ist.
     */
    public Kassenpatient(String name, String vorname, int alter, boolean familienversichert) throws PraxisVollException {
        // Mit "super(...)" wird der Konstruktor der Elternklasse aufgerufen.
        // Dieser Aufruf kann eine PraxisVollException werfen, da der Elternkonstruktor dies deklariert.
        // Deshalb muss auch dieser Konstruktor die Ausnahme deklarieren.
        super(name, vorname, alter);

        this.familienversichert = familienversichert;
    }

    // Hier wird erneut die Methode "toString",
    // die bereits in "Patient" die Version aus der Klasse "Object" überschreibt, überschrieben.

    public String toString(){
        String familie;
        if (familienversichert){
            familie = "familienversichert";
        } else {
            familie = "nicht familienversichert";
        }

        // Mit dem Aufruf "super.toString()" wird innerhalb der neuen Version der Methode "toString"
        // die Version aus "Patient" ausgeführt. So müssen gleichbleibende Inhalte nicht erneut geschrieben werden.
        return super.toString() + ", " +  familie;
    }

    public boolean getFamilienversichert(){
        return familienversichert;
    }

    public void printAbrechnung(){
        System.out.println("Abrechnung: " + "XYZ");
    }

    // Überladung einer Methode: Die Methode "getName" existiert bereits in der Elternklasse "Patient".
    // Dort allerdings mit einem anderen Methodenkopf. In der Elternklasse nimmt die Methode keine Parameter an.
    // Hier schon. Somit wird die Methode hier nicht überschrieben, sondern überladen. Ein Objekt von
    // "Kassenpatient" kann dadurch beide Varianten aufrufen und verwenden. Siehe PatientTest.
    public String getName(String prefix){
        return prefix + " " + super.getName();
    }
}