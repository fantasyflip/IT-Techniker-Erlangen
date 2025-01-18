public class TennisspielerTest {
    public static void main(String[] args) {

        Tennisspieler maier;
        maier = new Tennisspieler("Maier", 24);

        // b)
        // Durch die erste Zeile wird die Variable maier vom Typ Tennisspieler definiert.
        // Zu diesem Zeitpunkt ist sie ein Pointer auf null.
        // Erst durch die Initialisierung in der zweiten Zeile wird ein Objekt vom Typ Tennisspieler erstellt.

        // d)
        // Der Zugriff auf die Variablen und Methoden des Objekt erfolgt mittels der Punkt-Notation.
        // Das Alter wird zum Beispiel über maier.alter angesprochen.
        // Die Methode wird über maier.alterDifferenz(5) aufgerufen.
    }
}
