public class HaustiereTest {
    public static void main(String[] args) {
        Katze katze1 = new Katze("Minka", 5.0);
        Hund hund1 = new Hund("Strolchi", 5.0);

        katze1.sprich();
        do {
            katze1.friss();

        } while (katze1.futtervorrat != 0.0);
        katze1.anzeigen();

        hund1.sprich();
        do {
            hund1.friss();

        } while (hund1.futtervorrat != 0.0);
        hund1.anzeigen();
    }
}
