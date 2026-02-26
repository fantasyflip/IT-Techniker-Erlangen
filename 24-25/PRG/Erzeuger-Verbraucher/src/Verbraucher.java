class Verbraucher extends Thread {
    Wert w;
    public Verbraucher (Wert w) {
        this.w = w;
    }
    public void run() {
        int v;
        for (int i = 0; i < 5; i++) {
            v = w.get();
            try {
                sleep((int)(Math.random() * 100));
            }
            catch (InterruptedException e) {
            }
        }
    }
}