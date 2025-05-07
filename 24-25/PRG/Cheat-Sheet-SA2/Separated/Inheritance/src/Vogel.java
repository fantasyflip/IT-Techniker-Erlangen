// Implements: Das Interface "Tier" wird auf die Klasse "Vogel" angewandt. Die
// Klasse "Vogel" muss somit alle Methoden aus dem Interface "Tier" enthalten.
// Da "Vogel" abstract ist, würde kein Fehler auftreten, wenn eine Methode aus
// dem Interface nicht implementiert wäre. Dafür wird dann aber in den Subklassen
// erzwungen, dass die entsprechende Methode definiert ist. Vorteil eines Interface
// ist die Mehrfachvererbung. Eine abstrakte Klasse kann zwar mehrere Kindklassen
// haben, aber immer nur eine Elternklasse. Interfaces hingegen können mehrfach auf
// Klassen angewandt werden. Somit ist es hier möglich sowohl das Interface "Tier"
// als auch das Interface "KannFliegen" und "HatFluegel" auf die Klasse "Vogel"
// anzuwenden.

// Auch diese Klasse ist abstrakt, da sie in diesem Fall zu unspezifisch ist.
public abstract class Vogel extends Lebewesen implements Tier, KannFliegen, HatFluegel {

    // Static: Die Variable ist unabhängig von der Instanz und ist für jede Instanz der
    // Klasse Vogel gleich. Das bedeutet egal auf welcher Instanz von "Vogel" die
    // Variable "anzahl" verwendet wird, befindet sich immer der gleiche Wert dahinter.
    // Es wird gespeichert wie viele Vögel instanziiert wurden.
    private static int anzahl;
    private double schnelligkeit;

    public Vogel(String name, double schnelligkeit){
        // Mit "super" wird die Elternklasse angesprochen. In diesem Fall der Konstruktor
        // der Klasse "Lebewesen"
        super(name);
        this.schnelligkeit = schnelligkeit;
        anzahl++;
    }

    // Überladung einer Methode: Die Methode "bewegen" existiert bereits in der
    // Elternklasse "Lebewesen". Dort allerdings mit einem anderen Methodenkopf.
    // In der Elternklasse nimmt die Methode keine Parameter an.
    // Hier schon. Somit wird die Methode hier nicht überschrieben, sondern überladen.
    // Ein Objekt von "Vogel" kann dadurch beide Varianten aufrufen und verwenden.
    // Siehe PatientTest.
    public void bewegen(String richtung) {
        System.out.println("Das Lebewesen bewegt sich " + richtung + ".");
    }

    public void fliegen() {
        System.out.println("Der Vogel fliegt durch die Luft.");
    }

    public void ausbreiten(){
        System.out.println("Fluegel werden ausgebreitet.");
    }

    // Hier wird die Methode "toString" aus der Klasse "Lebewesen" überschrieben.
    public String toString(){
        // Hier wird mit "super" die Methode von der Elternklasse aufgerufen.
        return super.toString() + " (" + schnelligkeit + " km/h)";
    }

    public void sterben() {
        System.out.println("Der Vogel fällt vom Himmel");
    }

    public int getAnzahl(){
        return anzahl;
    }

}
