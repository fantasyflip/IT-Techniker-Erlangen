public class Fahrzeug {
    // private Variablen erstellen
    private String make;
    private String model;
    private int horsepower;

    // An dieser Stelle könnte ein Konstruktor stehen. Der Konstruktor wird ausgeführt, sobald eine neue Instanz eines
    // Objekts erstellt wird. Wenn kein Konstruktor definiert ist, gibt es einen parameterlosen Konstruktor. Das Objekt
    // wird also initialisiert, aber es passiert nichts weiter.

    // Da private Variablen nicht per Punktreferenz (Objekt.attribut) werden Get-Methoden benötigt,
    // die public sind. Dadurch kann ein privater Parameter trotzdem per Punktreferenz abgerufen werden (Objekt.getAttribut())
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    // Set-Methoden sind das Gegenstück von Get-Methoden. Damit lassen sich private Variablen außerhalb des Objekts setzen
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    // Weitere Methoden
    public void printDataSheet(){
        System.out.println("----- Fahrzeug-Info-Blatt -----");
        System.out.println("Marke: " + make);
        System.out.println("Modell: " + model);
        System.out.println("Leistung: " + horsepower);
    }
}
