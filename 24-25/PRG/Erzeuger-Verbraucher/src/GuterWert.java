class GuterWert extends Wert {
    private boolean verfuegbar = false;
    public synchronized int get() {
        if (!verfuegbar)
            try {
                wait();
            }
            catch (InterruptedException ie) {
            }
        verfuegbar = false;
        notify();
        System.out.println("Verbraucher get: " + wert);
        return wert;
    }
    public synchronized void put (int w) {
        if (verfuegbar)
            try {
                wait();
            }
            catch (InterruptedException ie) {
            }
        wert = w;
        System.out.println("Erzeuger    put: " + wert);
        verfuegbar = true;
        notify();
    }
}