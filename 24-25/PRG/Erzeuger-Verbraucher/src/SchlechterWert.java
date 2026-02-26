class SchlechterWert extends Wert {
    public synchronized int get() {
        System.out.println("Verbraucher get: " + wert);
        return wert;
    }
    public synchronized void put (int w) {
        wert = w;
        System.out.println("Erzeuger    put: " + wert);
    }
}