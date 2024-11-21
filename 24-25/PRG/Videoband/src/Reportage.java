public class Reportage extends Videoband {
    String releaseDate;

    public Reportage(String ttl, String releaseDate) {
        super(ttl);
        this.releaseDate = releaseDate;
    }

    public Reportage(String ttl, int duration, String releaseDate){
        super(ttl, duration);
        this.releaseDate = releaseDate;
    }

    public void anzeigen(){
        super.anzeigen();
        System.out.println("Release: " + releaseDate);
    }

}
