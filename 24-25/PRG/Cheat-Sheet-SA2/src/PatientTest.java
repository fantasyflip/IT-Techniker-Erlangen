public class PatientTest {
    public static void main(String[] args) {
        // Patient ist eine abstrakte Klasse. Eine Instanziierung wie
        // Patient p1  = new Patient();
        // würde also nicht funktionieren. Allerdings lässt sich ein Array der Elternklasse anlegen.
        // In diesen Array können dann alle Subklassen der Elternklasse gespeichert werden.
        // In diesem Beispiel können "Kassenpatient" und "Privatpatient" in einem Array von Patienten
        // gespeichert werden, da sie beide von der Klasse "Patient" abstammen.
        Patient[] patienten = new Patient[3];

        patienten[0] = new Privatpatient("Meier", "Hans", 45);
        patienten[1] = new Kassenpatient("Müller", "Peter", 23, true);
        patienten[2] = new Kassenpatient("Müller", "Daniela", 51, false);

        // Da in der Elternklasse definiert ist, dass es eine Methode "toString" gibt kann diese Methode
        // auch auf den im Array aus Patienten gespeicherten Objekten ausgeführt werden. Je nachdem ob
        // das betroffene Objekt dann ein "Kassenpatient" oder ein "Privatpatient" ist, wird die
        // entsprechende Version der Methode "toString" ausgeführt. Der Aufruf der Methode
        // "getFamilienversichert", die nur in "Kassenpatient" definiert wurde, würde dementsprechend
        // nicht funktionieren.
        for(int i = 0; i < patienten.length; i++){
            // Hier steht eigentlich:
            // System.out.println(patienten[i].toString());
            // Der Methodenaufruf ".toString()" kann hier allerdings ignoriert werden.
            System.out.println(patienten[i]);
            // System.out.println(patienten[i].getFamilienversichert()); // Funktioniert nicht!
        }

        // Konsole:
        // Meier, Hans, 45, 0
        // Müller, Peter, 23, 0, familienversichert
        // Müller, Daniela, 51, 0, nicht familienversichert

        System.out.println(patienten[0].getAnzahl()); // Konsole: 3

        Kassenpatient kp1 = new Kassenpatient("Mustermann", "Max", 34, false);

        // Ausführen der Methode "getName" aus der Elternklasse
        System.out.println(kp1.getName()); // Konsole: Mustermann
        // Ausführen der, in "Kassenpatient" überladenen, Methode "getName"
        System.out.println(kp1.getName("Name:")); // Konsole: Name: Mustermann

        // Aufruf der Default-Methode aus dem Interface "Person"
        System.out.println(kp1.getIdentitaet()); // Konsole: Mustermann, Max

        // Aufruf der statischen Methode aus dem Interface "Person"
        Person.printHello(); // Konsole: Hello World!

    }
}