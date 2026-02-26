class KlemmWert extends Wert {
    public synchronized int get() {
        try {
            wait();
        }
        catch (InterruptedException ie) {
        }
        notify();
        System.out.println("Wert verbraucht!");
        return wert;
    }
    public synchronized void put (int w) {
        wert = w;
        System.out.println("Wert erzeugt!");
        notify();
        try {
            wait();
        }
        catch (InterruptedException ie) {
        }
    }
}