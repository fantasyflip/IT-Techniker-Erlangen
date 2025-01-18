public class Tennisspieler {
    public String name;
    public int alter;

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
