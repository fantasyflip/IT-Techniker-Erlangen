public class Test {
    // Diese Methode verwendet keinen generischen Datentyp für die Übergabe des Parameters.
    // Da bei generischen Datentypen die Vererbung allerdings irrelevant ist, kann diese Methode
    // niemals aufgerufen werden. Das liegt daran, dass es keine Werkstatt vom Typ "Auto"
    // geben kann, da "Auto" abstrakt ist. Es kann also nur "BMW" oder "Mercedes"
    // sein. Hätte die Methode "Werkstatt<BMW> werkstatt" als Parameter könnte die Methode
    // aufgerufen werden. Allerdings nicht mit einer Werkstatt vom Typ "Mercedes".
    // Um das zu lösen gibt es zwei Möglichkeiten:
    // 1. Methode mit generischem Datentyp
    // 2. Methode mit einer Wildcard
    public static boolean gleicheLeistung(Werkstatt<Auto> werkstatt) {
        return werkstatt.getHebeBuehne1().getLeistung() == werkstatt.getHebeBuehne2().getLeistung();
    }

    // Auch Methoden können generische Datentypen verwenden. Diese Methode kann sowohl
    // eine Werkstatt von BMW, als auch eine von Mercedes verarbeiten.
    public static <T extends Auto> void printHebebuehne1(Werkstatt<T> werkstatt){
        System.out.println(werkstatt.getHebeBuehne1().toString());
    }

    // Alternativ kan auch mit einer Wildcard gearbeitet werden. Damit wird die doppelte
    // Prüfung des korrekten generischen Datentyps vermieden. Es wird nur bei der Instanziierung
    // der generischen Klasse geprüft.
    public static void printHebebuehne2(Werkstatt<?> werkstatt){
        System.out.println(werkstatt.getHebeBuehne2().toString());
    }

    public static void main(String[] args) {

        // Erstellen einer Werkstatt. Es wird angenommen, dass nur Autos vom gleichen Typen in einer Werkstatt behandelt werden
        BMW a = new BMW(340, true);
        BMW b = new BMW(130, false);

        // In den </> Klammern wird der generischen Klasse der Datentyp übergeben
        Werkstatt<BMW> w = new Werkstatt<>(a,b);

        // Da nur Autos des gleichen Typs in eine Werkstatt dürfen, wäre folgender Aufruf nicht möglich.
        //  Mercedes a = new Mercedes(44, false);
        //  BMW b = new BMW(22, true);
        //  Werkstatt<BMW> w = new Werkstatt<>(a, b);

        w.printWerkstatt();
        // Konsole:
        // Werkstatt
        // Hebebuehne 1: Auto mit 340 PS
        // Hebebuehne 2: Auto mit 130 PS

        printHebebuehne1(w); // Konsole: Auto mit 340 PS
        printHebebuehne2(w); // Konsole: Auto mit 130 PS
    }
}
