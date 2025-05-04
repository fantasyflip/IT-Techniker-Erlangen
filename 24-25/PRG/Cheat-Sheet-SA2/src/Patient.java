// Abstract: Es kann keine Instanz der Klasse Patient erstellt werden.
// Lediglich von der Klasse Patient abstammende Klassen wie "Kassenpatient" oder
// "Privatpatient" können instanziert werden. Patient legt lediglich die Grundstruktur fest.
// Das macht Sinn, weil ein Patient immer entweder privatversichert oder kassenversichert ist.
// Allerdings teilen sowohl private als auch Kassenpatienten viele Eigenschaften. Deshalb sammelt man diese
// Eigenschaften in der Grundklasse Patient.
// Damit die nicht instanziiert werden kann macht man sie abstrakt.

abstract class Patient {
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

    public Patient(String name, String vorname, int alter) {
        this.name = name;
        this.vorname = vorname;
        this.alter = alter;
        anzahl++;
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
}