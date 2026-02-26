public class EVTest3 {
    public static void main (String args[]) {
        KlemmWert   w = new KlemmWert();
        Erzeuger    e = new Erzeuger(w);
        Verbraucher v = new Verbraucher(w);
        e.start();
        v.start();
    }
}