public class Verbrenner extends Fahrzeug{
    // Definition von privaten Variablen
    private int displacement;
    private int cylinderCount;
    private String fuelType;

    // Konstruktor der Verbrenner-Klasse
    public Verbrenner(String make, String model, int horsepower, int displacement, int cylinderCount) {
        // Zuerst muss IMMER der Konstruktor der Vater-Klasse ausgeführt werden! Ein parameterloser Konstruktor muss
        // nicht zwingend genannt werden. Er wird automatisch aufgerufen, sollte nichts anderes in der Tochter-Klasse
        // definiert sein,
        super();

        // Da der Konstruktor der Tochter-Klasse "Verbrenner" auch Parameter annimmt, die der Vater-Klasse zugehörig
        // sind, sollten diese auch entsprechend gesetzt werden. Da die Variablen der Vater-Klasse allerdings private
        // sind, können sie nicht direkt (super.make = make) gesetzt werden, sondern müssen über die Set-Methoden
        // gesetzt werden
        super.setMake(make);
        super.setModel(model);
        super.setHorsepower(horsepower);

        // Anschließend werden die privaten Variablen der Tochter-Klasse gesetzt
        this.displacement = displacement;
        this.cylinderCount = cylinderCount;
    }

    // Get-Methoden → siehe Fahrzeug.java
    public int getDisplacement() {
        return displacement;
    }

    public int getCylinderCount() {
        return cylinderCount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getDisplacementPerCylinder() {
        return displacement / cylinderCount;
    }

    // Set-Methoden → siehe Fahrzeug.java
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setCylinderCount(int cylinderCount) {
        this.cylinderCount = cylinderCount;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Überschreibung einer Methode der Vater-Klasse:
    // Wenn ein Vater-Objekt eine Methode besitzt, die in einer Tochter-Klasse anders behandelt werden muss,
    // kann diese überschrieben werden. Dazu muss eine Methode mit dem gleichen Methoden-Kopf erstellt werden.

    public void printDataSheet(){
        // Innerhalb einer Methode kann die Methode des Vater-Objekts mit super.<Methode>() aufgerufen werden.
        // Das beschränkt sich nicht auf überschriebene Methoden. In diesem Fall macht das allerdings hier Sinn:
        // Die Methode erweitert das Basis-Data-Sheet aus dem Vater-Objekt um Informationen aus dem Tochter-Objekt.

        // Ohne den Super-Aufruf müsste der gesamte Inhalt der gleichnamigen Methode in Fahrzeug.java eingefügt werden.
        // Man spart sich also Code-Zeilen
        super.printDataSheet();
        System.out.println("Hubraum: "+ displacement + " ccm");
        System.out.println("Zylinder: "+ cylinderCount + " (" + getDisplacementPerCylinder() + " ccm)");
        System.out.println("Kraftstoff: "+ fuelType);
    }
}
