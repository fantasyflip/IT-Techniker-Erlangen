public class Hund extends Haustiere {
    String kategorie;

    public Hund(String name, double futtervorrat, String kategorie, int gewicht) {
        super(name, futtervorrat, gewicht);
        this.kategorie = kategorie;
    }

    public void sprich(){
        System.out.println("Wuff");
    }

    public void friss(){
        System.out.println(super.name + ": " + super.futtervorrat);
        futtervorrat = futtervorrat - 1.0;
        super.anzahlTage++;
    }

    public void anzeigen(){
        System.out.print("(Kategorie: " + kategorie + ") ");
        super.anzeigen();
    }
}
