public class Wellensittich extends Vogel {
    private double schnabellaenge;

    public Wellensittich(String name, double schnelligkeit, double schnabellaenge) {
        super(name, schnelligkeit);
        this.schnabellaenge = schnabellaenge;
    }

    public void fressen() {
        System.out.println("Wellensittich frisst Beeren.");
    }

    public void schlafen() {
        System.out.println("Wellensittich schlaeft.");
    }
}
