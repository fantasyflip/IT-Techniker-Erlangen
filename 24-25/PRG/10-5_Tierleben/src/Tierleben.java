public class Tierleben {
//    public static void gibAus(Object tier){
//        System.out.println("Objekt: " + tier);
//    }
//
//    public static void gibAus(Katze tier){
//        System.out.println("Katze: " + tier);
//    }

    public static <T> void gibAus(T tier){
        System.out.println("Unbekannt: " + tier);
    }

    public static <T extends Haustier> void gibAus(T tier){
        System.out.println("Haustier: " + tier);
    }

    public static void main(String[] args) {
        gibAus("Amoebe"); // wird von der ersten generischen Methoden bearbeitet
        gibAus(new Katze()); // wird von der ersten generischen Methoden bearbeitet
        gibAus(new Hauskatze()); // wird von der zweiten generischen Methoden bearbeitet, da diese Methode spezifischer ist.
        gibAus(new Wildkatze()); // wird von der ersten generischen Methoden bearbeitet
    }
}

// Auswirkung von generischen Methoden auf das Überladen von Methoden:
// Generische Methoden mit unbeschränktem Typenparamter können alle möglichen Typen abfangen (Fallback).
// Ansonsten wird aus den verfügbaren Überladungen – ob generisch oder nicht – die spezifischste Methode gewählt.
// Normale, nicht generische, Methoden haben Vorrang vor generischen.
