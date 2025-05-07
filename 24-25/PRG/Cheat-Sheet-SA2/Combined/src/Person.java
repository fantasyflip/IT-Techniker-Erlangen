// Ein Interface gibt Methoden vor, die eine Klasse haben muss, die das entsprechende
// Interface implementiert. Der Inhalt der Methoden des Interfaces werden dann erst
// in der Klasse definiert. Da Methoden aus einem Interface immer public und abstract
// sind kann auf diese Schlüsselwörter verzichtet werden. In einem Interface können
// keine Instanzvariablen definiert werden! Definiert Variablen sind immer Konstanten
// und erhalten die Schlüsselwörter "final", "static" und "public".

public interface Person {
    String getName();
    String getVorname();
    // In einem Interface können Default-Methoden definiert werden. Damit können
    // Standardimplementierungen bereits im Interface hinterlegt werden. Die Methode
    // muss dazu mit dem Schlüsselwort default versehen werden.
    default String getIdentitaet(){
        return getName() + ", " + getVorname();
    }

    // Außerdem können statische Methoden definiert werden. Diese Methoden können ohne
    // ein instanziiertes Objekt aufgerufen werden.
    static void printHello(){
        System.out.println("Hello World!");
    }
}
