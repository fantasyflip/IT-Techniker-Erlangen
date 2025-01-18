// https://gailer-net.de/tutorials/java/Notes/chap52/progExercises52.html

import java.util.Arrays;

public class HaustiereTest {
    public static void main(String[] args) {
//        Katze katze1 = new Katze("Minka", 5.0, "Wohnung");
//        Hund hund1 = new Hund("Strolchi", 5.0, "Kleinhunde");
//
//        katze1.fuettern();
//        katze1.anzeigen();
//
//        hund1.fuettern();
//        hund1.anzeigen();

        Haustiere haustiere [] = new Haustiere[5];

        haustiere[0] = new Katze("Minka", 5.0, "Wohnung", 5);
        haustiere[1] = new Hund("Strolchi", 5.0, "Wohnung",23);
        haustiere[2] = new Katze("Mausi", 4.5, "Garten",12);
        haustiere[3] = new Hund("Bello", 7.0, "Haus",9);
        haustiere[4] = new Katze("Luna", 3.0, "Wohnung",8);

        for(int i = 0; i < haustiere.length; i++) {
            haustiere[i].anzeigen();
        }

//        // sortieren nach namen
//        Arrays.sort(haustiere);
//
//        for(int i = 0; i < haustiere.length; i++) {
//            haustiere[i].anzeigen();
//        }

        String sortBy = "gewicht";

        Arrays.sort(haustiere, (h1, h2) -> {
            switch (sortBy.toLowerCase()) {
                case "name":
                    return h1.name.compareTo(h2.name);
                case "gewicht":
                    return Double.compare(h1.gewicht, h2.gewicht);
                default:
                    throw new IllegalArgumentException("Ungueltiges Sortierkriterium: " + sortBy);
            }
        });

        for(int i = 0; i < haustiere.length; i++) {
            haustiere[i].anzeigen();
        }

    }
}
