public class Hund extends Haustiere {
    public Hund(String name, double futtervorrat) {
        super(name, futtervorrat);
    }

    public void sprich(){
        System.out.println("Wuff");
    }

    public void friss(){
        System.out.println(super.name + ": " + super.futtervorrat);
        futtervorrat = futtervorrat - 1.0;
        super.anzahlTage++;
    }
}
