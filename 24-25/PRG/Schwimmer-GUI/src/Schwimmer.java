public class Schwimmer {
    String vorname;
    String nachname;
    String klasse;

    public Schwimmer(String vorname, String nachname, String klasse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.klasse = klasse;
    }

    public String toString() {
        return vorname + " " + nachname + ", Klasse: " + klasse;
    }
}
