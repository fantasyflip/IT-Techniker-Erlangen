public abstract class Auto {
    private int leistung;

    public Auto(int leistung) {
        this.leistung = leistung;
    }

    public int getLeistung() {
        return leistung;
    }

    public String toString(){
        return "Auto mit " + this.leistung+ " PS";
    }
}
