class Hund extends Fuchs {
    Maus m = new Maus();
    Ratte r = new Ratte();

    Hund(){
        System.out.println("Hund");
    }

    public static void main (String [] args){
        new Hund();

        // Ausgabe auf der Konsole:
        //
        // Katze    (Hund kommt vom Fuchs, Fuchs kommt von Katze -> Katze muss zuerst erstellt werden, da oberste Elternklasse)
        // Fuchs    (Hund kommt vom Fuchs -> Fuchs muss vor Hund erstellt werden)
        // Maus     (Maus wird erstellt)
        // Ratte    (Maus existiert bereits -> Ratte kann erstellt werden)
        // Hund     (Konstruktor der Klasse Hund wird ausgeführt -> Instanzvariablen werden initialisiert bevor der Konstruktor ausgeführt wird)
    }
}
