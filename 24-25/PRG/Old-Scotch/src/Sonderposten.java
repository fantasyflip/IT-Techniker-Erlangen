public class Sonderposten extends Artikel {
    private double rabatt;

    public Sonderposten(String artikelNr, String bezeichnung, double einkaufspreis, int jahre, double prozent){
        super(artikelNr, bezeichnung, einkaufspreis, jahre, prozent);
        if(jahre > 1) {
            this.rabatt = 0.3;
        } else {
            this.rabatt = 0.1;
        }
    }

    public void anzeigen(){
        System.out.println("Sonderposten:");
        System.out.println(artikelNr + " '" + bezeichnung + "' EK: " + einkaufspreis + " VK: " + berechneVerkaufspreis() + " Lagerzeit: " + 12* jahre + " Monate" );
        System.out.println("(VK <alt>: " + super.berechneVerkaufspreis() + " Euro Rabatt: " + rabatt*100 + "%");
    }

    public double berechneVerkaufspreis(){
        double preis = super.berechneVerkaufspreis();
        preis = preis - preis * rabatt;
        return preis;
    }
}
