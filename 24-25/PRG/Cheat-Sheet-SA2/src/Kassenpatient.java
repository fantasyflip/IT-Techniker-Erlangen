public class Kassenpatient extends Patient {
    boolean familienversichert;

    public Kassenpatient(String name, String vorname, int alter, boolean familienversichert) {
        // Mit "super(...)" kann der Konstruktor von der Elternklasse aufgerufen werden.
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
}