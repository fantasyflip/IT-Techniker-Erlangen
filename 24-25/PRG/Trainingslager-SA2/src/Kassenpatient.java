public class Kassenpatient extends Patient {
    boolean familienversichert;

    public Kassenpatient(String name, String vorname, int alter, boolean familienversichert) {
        super(name, vorname, alter);
        this.familienversichert = familienversichert;
    }

    public String toString(){
         String familie;
         if (familienversichert){
             familie = "familienversichert";
         } else {
             familie = "nicht familienversichert";
         }

         return super.toString() + ", " +  familie;
    }
}
