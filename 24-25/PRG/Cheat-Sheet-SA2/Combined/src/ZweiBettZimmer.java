// Generische Klassen ermöglichen es allgemeine Klassendefinitionen zu erstellen. Dazu
// wird innerhalb der Klasse kein konkreter Datentyp verwendet, sondern ein Platzhalter.
// In diesem Fall ist der Platzhalter "T". Bei der Instanziierung wird der gewünschte
// Datentyp dann als Parameter in </>-Klammern übergeben. In diesem Fall soll ein
// ZweiBettZimmer als Klasse definiert werden. In ein Zimmer dürfen nur Patient des
// gleichen Typs. Außerdem wird durch das "extends Patient" festgelegt,
// dass der übergebene Datentyp "Patient" oder eine Kindklasse davon sein muss.
public class  ZweiBettZimmer<T extends Patient> {
    private T fensterSeite, wandSeite;

    public ZweiBettZimmer(T fensterSeite, T wandSeite) {
        this.fensterSeite = fensterSeite;
        this.wandSeite = wandSeite;
    }

    public T getFensterSeite() {
        return fensterSeite;
    }

    public T getWandSeite() {
        return wandSeite;
    }

    public void printBelegung(){
        System.out.println("Zimmerbelegung:");
        System.out.println("Fensterseite: " + fensterSeite.toString());
        System.out.println("Wandseite: " + wandSeite.toString());
    }
}
