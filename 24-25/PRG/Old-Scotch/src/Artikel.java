//https://www.gailer-net.de/tutorials/java/Notes/chap50/progExercises50.html
public class Artikel {
    String artikelNr;
    String bezeichnung;
    double einkaufspreis;
    int jahre;
    double prozent;

    final double  HANDELSSPANNE = 0.6  ; // 60 Prozent des Einkaufspreises
    final double  MWST          = 0.19 ; // 19 Prozent

    public Artikel(String artikelNr, String bezeichnung, double einkaufspreis, int jahre, double prozent) {
        this.artikelNr = artikelNr;
        this.bezeichnung = bezeichnung;
        this.einkaufspreis = einkaufspreis;
        this.jahre = jahre;
        this.prozent = prozent;
    }

    public void anzeigen(){
        System.out.println(artikelNr + " '" + bezeichnung + "' EK: " + einkaufspreis + " VK: " + berechneVerkaufspreis() + " Lagerzeit: " + 12* jahre + " Monate" );
    }

    public double berechneVerkaufspreis(){
        double preis = einkaufspreis + einkaufspreis * HANDELSSPANNE;
        preis = preis + preis * MWST;
        return preis;
    }
}
