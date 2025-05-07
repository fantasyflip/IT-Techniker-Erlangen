
// Auto implementiert das Interface Comparable<T>, um es in einem SortedSet zu verwenden
// Comparable<T> zwingt dann die Klasse dazu eine Methode zu definieren,
// die es ermöglicht zwei Objekte von dieser Klasse miteinander zu vergleichen
public class Auto implements Comparable<Auto>{
    private String marke;
    private int leistung;

    public Auto(String marke, int leistung) {
        this.marke = marke;
        this.leistung = leistung;
    }

    public int compareTo(Auto a){
        // Hier wird einfach auf die compare Methode von "Integer" zurückgegriffen.
        // Zurückgegeben wird 1, 0 oder -1
        return Integer.compare(this.leistung, a.leistung);

        // Alternativ kann auch nach mit einem String verglichen werden
        // return this.marke.compareTo(a.marke);
    }
}
