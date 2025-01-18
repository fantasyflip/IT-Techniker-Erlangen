public class Katze extends Haustiere {
    String haltung;

    public Katze(String name, double futtervorrat, String haltung, int gewicht) {
        super(name, futtervorrat, gewicht);
        this.haltung = haltung;
    }

    public void sprich(){
        System.out.println("Miau");
    }

    public void friss(){
        System.out.println(super.name + ": " + super.futtervorrat);
        futtervorrat = futtervorrat - 0.5;
        super.anzahlTage++;
    }

    public void anzeigen(){
        System.out.print("(Haltung: " + haltung + ") ");
        super.anzeigen();
    }
}
