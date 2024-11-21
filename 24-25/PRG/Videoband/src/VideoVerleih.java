public class VideoVerleih
{
    public static void main ( String args[] )
    {
        Videoband artikelA = new Videoband("Jaws", 120 );
        Videoband artikelB = new Videoband("Star Wars" );

        artikelA.anzeigen();
        artikelB.anzeigen();
    }
}