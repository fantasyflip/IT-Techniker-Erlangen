class Sandwich extends Vesper {
    Brot b = new Brot();
    Wurst w = new Wurst();
    Salat s = new Salat();

    Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();

        // a)
        // Ausgabe auf der Konsole:
        //
        // Mahlzeit()
        // Mittagessen()
        // Vesper()
        // Brot()
        // Wurst()
        // Salat()
        // Sandwich()
    }
}
