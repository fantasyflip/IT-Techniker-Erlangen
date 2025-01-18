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

        //j)
        Tennisspieler schmid = new Tennisspieler("G. Schmid", 45, maier);
        Tennisspieler berger = new Tennisspieler("I. Berger", 36, schmid);

        // Beim erstellen von maier wird die startNummer von maier auf 1 gesetzt und die folgeNummer in der gesammten Klasse Tennisspieler auf 2 erhöht.
        // Beim erstellen von schmid wird die startNummer von schmid auf 2 gesetzt und die folgeNummer in der gesamten Klasse Tennisspieler auf 3 erhöht.
        // Beim erstellen von berger wird die startNummer von berger auf 3 gesetzt und die folgeNummer in der gesamten Klasse Tennisspieler auf 4 erhöht.

    }
}
