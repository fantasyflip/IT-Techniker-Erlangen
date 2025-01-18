abstract class Haustiere implements Comparable<Haustiere> {
    String name;
    double futtervorrat;
    int    anzahlTage; // gibt die Anzahl Tage aus, die der Futtervorrat reicht
    int gewicht;

    public Haustiere(String name, double futtervorrat, int gewicht){
        this.name = name;
        this.futtervorrat = futtervorrat;
        this.gewicht = gewicht;
    }

    public void fuettern(){
        sprich();
        while(futtervorrat > 0){
            friss();
        }
    }

    public abstract void sprich();
    public abstract void friss();

    public void anzeigen(){
        System.out.println("[" + gewicht + "] Der Vorrat fuer " + name + " reicht " + anzahlTage + " Tage");
    }


    // sortieren nach name
    public int compareTo(Haustiere o) {
        return this.name.compareTo(o.name);
    }

    // sortieren nach gewicht
//    public int compareTo(Haustiere o){
//        if(this.gewicht == o.gewicht){
//            return 0;
//        } else if(this.gewicht > o.gewicht){
//            return 1;
//        } else {
//            return -1;
//        }
//    }
}
