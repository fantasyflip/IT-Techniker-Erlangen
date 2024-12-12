public class Katze extends Haustiere {
    public Katze(String name, double futtervorrat) {
        super(name, futtervorrat);
    }

    public void sprich(){
        System.out.println("Miau");
    }

    public void friss(){
        System.out.println(super.name + ": " + super.futtervorrat);
        futtervorrat = futtervorrat - 0.5;
        super.anzahlTage++;
    }
}
