public class Laden {
    public static void main ( String args[] ){
        Artikel A = new Artikel( "SC123-F", "DUFFY MALT WHISKEY", 10.0, 3, 5.2);
        Sonderposten B = new Sonderposten("SC347-A", "GLEN MORANGIE MALT WHISKEY", 49.0, 15, 3.2 );

        A.anzeigen();
        B.anzeigen();
    }
}
