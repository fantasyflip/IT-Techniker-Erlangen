public class Test {
    public static void main(String[] args) {
        // Vogel ist eine abstrakte Klasse. Eine Instanziierung wie
        // Vogel v1  = new Vogel();
        // würde also nicht funktionieren. Allerdings lässt sich ein Array der Elternklasse anlegen.
        // In diesen Array können dann alle Subklassen der Elternklasse gespeichert werden.
        // In diesem Beispiel können "Papagei" und "Wellensittich" in einem Array von "Vogel"
        // gespeichert werden, da sie beide von der Klasse "Vogel" abstammen.
        Vogel[] nest = new Vogel[5];

        nest[0] = new Papagei("Peter", 21.4, "gruen");
        nest[1] = new Wellensittich("Ruediger", 25.0, 4.7);

        // Da in der Elternklasse definiert ist, dass es eine Methode "toString" gibt kann diese Methode
        // auch auf den im Array aus "Vogel" gespeicherten Objekten ausgeführt werden. Je nachdem ob
        // das betroffene Objekt dann ein "Papagei" oder ein "Wellensittich" ist, wird die
        // entsprechende Version der Methode "toString" ausgeführt.
        // Der Aufruf der Methode "sprechen", die nur in "Papagei" definiert wurde,
        // würde dementsprechend nicht funktionieren.
        for(int i = 0; i < nest.length; i++){
            // Überspringen von leeren Zellen des Arrays
            if(nest[i]== null) break;
            // Hier steht eigentlich:
            // System.out.println(nest[i].toString());
            // Der Methodenaufruf ".toString()" kann hier allerdings ignoriert werden.
            System.out.println(nest[i]);
            // System.out.println(nest[i].sprechen()); // Funktioniert nicht!
        }

        // Konsole:
        // Peter (21.4 km/h) - Farbe: gruen
        // Ruediger (25.0 km/h)

        System.out.println(nest[0].getAnzahl()); // Konsole: 2

    }
}
