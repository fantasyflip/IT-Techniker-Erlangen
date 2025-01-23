public class ElchTest {
    public static void main(String argv[]) {
        AKlasse a = new AKlasse();
        System.out.println("Wert von a ist: " + a.wert);
        System.out.println("Wert von a ist: " + a.wert());
        CKlasse b = new CKlasse();
        System.out.println("Wert von b ist: " + b.wert);
        System.out.println("Wert von b ist: " + b.wert());
        AKlasse c = b;
        System.out.println("Wert von c ist: " + c.wert);
        System.out.println("Wert von c ist: " + c.wert());
    }
}

// b)
// c greift auf wert aus der Klasse AKlasse zu, da c vom Typ AKlasse ist und wert eine Instanzvariable ist
// c greift allerdings auf die Methode wert() aus CKlasse zu, da es sich bei c um das Objekt b handelt,
// das einer Referenz von AKlasse zugewiesen wurde. b ist ein Objekt von CKlasse
// Ausgabe auf der Konsole:
//
// Wert von a ist: 0
// Wert von a ist: 0
// Wert von b ist: 1
// Wert von b ist: 1
// Wert von c ist: 0
// Wert von c ist: 1