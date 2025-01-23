class AutoTest {
    public static void main(String[] args) {
        Fahrzeug f;
        Auto a = new Auto();
        f = a;
        f.fahre();
    }

    // a)
    // Es wird die fahre Methode von Auto aufgerufen, da das Auto a nur einer Referenz von Fahrzeug zugewiesen wird.
    // Ausgabe auf der Konsole:
    //
    // Das Auto faehrt
}