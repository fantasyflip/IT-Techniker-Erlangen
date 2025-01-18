public class Tennisspieler {
    public String name;
    public int alter;

    // e)
    Tennisspieler(String name, int alter) {
        this.name = name;
        this.alter = alter;
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
}

// f)
// Instanzvariablen: Variablen, die zu einer konkreten Instanz einer Klasse gehören.
//                      Jede Instanz hat eine eigene Kopie dieser Variable.
// Klassenvariablen: Variablen, die zu einer Klasse gehören und nicht zu einer Instanz.
//                      Alle Instanzen verwenden die gleiche Variante der Variable. Definiert mit 'static'
