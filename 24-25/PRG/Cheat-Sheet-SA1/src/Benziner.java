public class Benziner extends Verbrenner  {
    // Definition privater Variablen
    private String fuelSpecification;
    private int octaneRating;

    // Benutzerdefinierter Konstruktor mit Parametern -> siehe Verbrenner.java
    public Benziner(String make, String model, int horsepower, int displacement, int cylinderCount, String fuelSpecification, int octaneRating) {
        // Es wird nun der Konstruktor der Vater-Klasse "Verbrenner" aufgerufen. In dessen Konstruktor werden allerdings
        // auch Attribute der, aus aktueller Sicht, Großvaterklasse "Fahrzeug" gesetzt. Daher benötigt der Konstruktor
        // der Klasse "Benziner" als Parameter sowohl die Werte für die Attribute der Klasse "Verbrenner" als auch der Klasse "Fahrzeug"
        super(make, model, horsepower, displacement, cylinderCount);

        // Da ein Benzinmotor immer Benzin als Treibstoff braucht, kann das entsprechende Attribut der Vater-Klasse "Verbrenner"
        // im Konstruktor gesetzt werden
        super.setFuelType("Benzin");

        this.fuelSpecification = fuelSpecification;
        this.octaneRating = octaneRating;
    }

    // Get-Methoden -> siehe Fahrzeug.java
    public String getFuelSpecification() {
        return fuelSpecification;
    }

    public int getOctaneRating() {
        return octaneRating;
    }

    // Set-Methoden -> siehe Fahrzeug.java
    public void setFuelSpecification(String fuelSpecification) {
        this.fuelSpecification = fuelSpecification;
    }

    public void setOctaneRating(int octaneRating) {
        this.octaneRating = octaneRating;
    }

    // Erneutes Überschreiben einer Methode der Vater-Klasse: Die Methode "printDataSheet" wurde in der Klasse "Fahrzeug" definiert
    // und anschließend in "Verbrenner" überschrieben. Beim Überschreiben wurde allerdings die Methode der Vater-Klasse mit verwendet
    // um nicht unnötig Code zu duplizieren. Das Gleiche kann in der Tochter-Klasse "Benziner" der Tochter-Klasse "Verbrenner" gemacht
    // werden. Dabei wird nicht die Methode der Klasse "Fahrzeug" überschrieben, sondern die Methode der Klasse "Verbrenner". Beim
    // Überschreiben kann mittels "super" die überschriebene Methode aus "Verbrenner" verwendet werden.
    public void printDataSheet(){
        // Aufruf der Methode aus der Vater-Klasse "Verbrenner"
        super.printDataSheet();
        System.out.println("Kraftstoff Spezifikation: " + fuelSpecification);
        System.out.println("Oktanzahl : " + octaneRating);
    }
}
