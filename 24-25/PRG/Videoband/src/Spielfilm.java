public class Spielfilm extends Videoband
{
    String  regisseur;     // Name des Regisseurs
    String  bewertung;     // G, PG, R, oder X

    // Konstruktor
    public Spielfilm( String ttl, int len, String reg, String bew )
    {
        super( ttl, len ); // den Konstruktor der Superklasse verwenden
        regisseur = reg;   // initialisieren, was in Spielfilm neu ist
        bewertung = bew;
    }

}