public class Tennisspieler {
    public String name;
    public int alter;
    // g)
    public Tennisspieler verfolger;
    // g) & n)
    private int startNummer;
    // h)
    public static int folgeNummer = 1;

    // e)
    Tennisspieler(String name, int alter) {
        this.name = name;
        this.alter = alter;

        // i)
        this.startNummer = folgeNummer;
        folgeNummer++;
    }

    // i)
    Tennisspieler(String name, int alter, Tennisspieler verfolger) {
        this.name = name;
        this.alter = alter;
        this.startNummer = folgeNummer;
        this.verfolger = verfolger;
        folgeNummer++;
    }

    // Der Konstruktur ist eine Methode einer gleichnamigen Klasse,
    // die beim instanziieren eines Objekts ausgeführt wird.
    // Sobald ein Konstruktor erstellt wird, der Parameter erwartet
    // funktioniert der Aufruf "Tennisspieler maier = new Tennisspieler();" nicht mehr.

    public int alterDifferenz(int alter){
        // c)
        return Math.abs(alter - this.alter);

        // Im Scope der Methode alterDifferenz wird eine lokale Variable erstellt,
        // die den gleichen Namen wie die Instanzvariable des Objekts trägt.
        // Um zwischen der Instanzvariable und der lokalen Variable zu unterscheiden
        // wird die Instanzvariable mit this. angesprochen. "this" referenziert somit
        // auf das aktuelle Objekt in dem man sich befindet.
    }

    // l)
    public boolean istLetzter(){
        return this.verfolger == null;
    }

    //m
    public String toString () {
        String printText = name + " (" + startNummer + ")";
        if (verfolger != null)
            printText = printText + " liegt vor " + verfolger.toString();
        return printText;
    }

    //n
    public int getStartNummer() {
        return startNummer;
    }

    // Indem man die Variable als private definiert, kann sie von außen weder gelesen, noch geändert werden.
    // Um das Lesen trotzdem zuzulassen kann ein Getter erstellt werden.
}

// f)
// Instanzvariablen: Variablen, die zu einer konkreten Instanz einer Klasse gehören.
//                      Jede Instanz hat eine eigene Kopie dieser Variable.
// Klassenvariablen: Variablen, die zu einer Klasse gehören und nicht zu einer Instanz.
//                      Alle Instanzen verwenden die gleiche Variante der Variable. Definiert mit 'static'


// k)
// Instanzmethoden: Methode einer Instanz. Eine Instanz der Klasse muss existieren um sie aufzurufen
// Klassenmethoden: Method einer Klasse, die keine Instanz benötigt um ausgeführt werden zu können. Definiert mit 'static'