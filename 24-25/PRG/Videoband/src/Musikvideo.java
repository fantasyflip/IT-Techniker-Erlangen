public class Musikvideo extends Videoband
{
    String kuenstler;
    String kategorie;

    // Konstruktor
    public Musikvideo ( String ttl, int len, String kuenst, String kat )
    {
        super( ttl, len );
        kuenstler = kuenst;
        kategorie = kat;
    }

    public void anzeigen()
    {
        super.anzeigen();
        System.out.println( "Kuenstler:" + kuenstler + " Kategorie: " + kategorie );
    }

}