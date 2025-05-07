// Durch das "final" wird festgelegt, dass die Klasse "Papagei" nicht weiter vererbt
// werden kann. Eine Klassendefinition wie
// public class GruenSchnabelPapagei extends Papagei {...}
// wäre also nicht möglich.
// Ebenso können auch Methoden vom überschreiben geschützt werden, indem sie in der
// Elternklasse mit einem "final" versehen werden, können sie in Subklassen nicht
// überschrieben werden.
// Zur Info: "final" sorgt bei Variablen dafür, dass die Werte zu Konstanten werden.
public final class Papagei extends Vogel {
    private String farbe;

    public Papagei(String name, double schnelligkeit, String farbe) {
        super(name, schnelligkeit);
        this.farbe = farbe;
    }

    public void fressen() {
        System.out.println("Der Papagei frisst Körner.");
    }

    public void schlafen() {
        System.out.println("Der Papagei schläft im Nest.");
    }


    // Methodenüberladung
    public void sprechen() {
        System.out.println("Der Papagei spricht!");
    }

    public void sprechen(String satz) {
        System.out.println("Der Papagei sagt: " + satz);
    }

    public String toString() {
        return super.toString() + " - Farbe: " + farbe;
    }
}
