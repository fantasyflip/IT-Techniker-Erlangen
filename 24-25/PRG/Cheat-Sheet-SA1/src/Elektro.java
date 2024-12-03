public class Elektro extends Fahrzeug {
    // Definition privater Variablen
    private int engineCount;
    private int batterySize;

    // Benutzerdefinierter Konstruktor mit Parametern
    public Elektro(String make, String model, int horsepower, int engineCount, int batterySize) {
        // Parameterloser Vater-Konstruktor -> siehe Konstruktor in Verbrenner.java
        super();

        super.setMake(make);
        super.setModel(model);
        super.setHorsepower(horsepower);

        this.engineCount = engineCount;
        this.batterySize = batterySize;
    }

    // Get-Methoden -> siehe Fahrzeug.java
    public int getEngineCount() {
        return engineCount;
    }

    public int getBatterySize() {
        return batterySize;
    }

    // Set-Methoden -> siehe Fahrzeug.java
    public void setEngineCount(int engineCount) {
        this.engineCount = engineCount;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    // Überschreibung einer Methode der Vater-Klasse -> siehe Verbrenner.java
    public void printDataSheet(){
        super.printDataSheet();
        System.out.println("Motorenanzahl: " + engineCount);
        System.out.println("Batteriegröße: " + batterySize);
    }
}
