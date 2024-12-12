abstract class Haustiere {
    String name;
    double futtervorrat;
    int    anzahlTage; // gibt die Anzahl Tage aus, die der Futtervorrat reicht

    public Haustiere(String name, double futtervorrat){
        this.name = name;
        this.futtervorrat = futtervorrat;
    }

    public void fuettern(){
        sprich();
        if(futtervorrat > 0){
            friss();
        }
    }

    public abstract void sprich();
    public abstract void friss();

    public void anzeigen(){
        System.out.println("Der Vorrat fuer" + name + " reicht " + anzahlTage + " Tage");
    }
}
