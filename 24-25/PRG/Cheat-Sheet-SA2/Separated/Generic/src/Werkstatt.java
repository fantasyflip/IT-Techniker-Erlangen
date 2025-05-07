// Generische Klassen ermöglichen es allgemeine Klassendefinitionen zu erstellen. Dazu wird innerhalb
// der Klasse kein konkreter Datentyp verwendet, sondern ein Platzhalter. In diesem Fall ist der
// Platzhalter "T". Bei der Instanziierung wird der gewünschte Datentyp dann als Parameter in
// </>-Klammern übergeben. In diesem Fall soll eine Werkstatt als Klasse definiert werden. In
// eine Werkstatt dürfen nur Autos des gleichen Typs. Außerdem wird durch das "extends Auto" festgelegt,
// dass der übergebene Datentyp "Auto" oder eine Kindklasse davon sein muss. Da "Auto" abstract ist, muss es eine Kindklasse sein.
public class Werkstatt<T extends Auto> {

    private T hebeBuehne1, hebeBuehne2;

    public Werkstatt(T hebeBuehne1, T hebeBuehne2) {
        this.hebeBuehne1 = hebeBuehne1;
        this.hebeBuehne2 = hebeBuehne2;
    }

    public T getHebeBuehne1(){
        return this.hebeBuehne1;
    }

    public T getHebeBuehne2(){
        return this.hebeBuehne2;
    }

    public void printWerkstatt(){
        System.out.println("Werkstatt");
        System.out.println("Hebebuehne 1: " + this.hebeBuehne1);
        System.out.println("Hebebuehne 2: " + this.hebeBuehne2);
    }
}
