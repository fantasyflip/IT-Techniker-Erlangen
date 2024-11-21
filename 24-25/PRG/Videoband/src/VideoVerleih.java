public class VideoVerleih
{
    public static void main ( String args[] )
    {
        Videoband artikelA = new Videoband("Jaws", 120 );
        Videoband artikelB = new Videoband("Star Wars" );
        Spielfilm artikelSfA = new Spielfilm("Inception",212, "Christopher Nolan", "PG");
        Musikvideo artikelMvA = new Musikvideo("Rap God", 3, "Eminem", "Rap");
        Reportage artikelRA = new Reportage("Putins Bären", 101, "20.10.2023");
        TechnikReportage artikelTRA = new TechnikReportage("Der Fall Boeing", 70, "10.06.2014", "Flugzeuge");

        artikelA.anzeigen();
        artikelB.anzeigen();
        artikelSfA.anzeigen();
        artikelMvA.anzeigen();
        artikelRA.anzeigen();
        artikelTRA.anzeigen();
    }
}