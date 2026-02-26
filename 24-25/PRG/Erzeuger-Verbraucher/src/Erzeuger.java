class Erzeuger extends Thread {
    Wert w;
    public Erzeuger (Wert w) {
        this.w = w;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            w.put(i);
            try {
                sleep((int)(Math.random() * 100));
            }
            catch (InterruptedException e) {
            }
        }
    }
}