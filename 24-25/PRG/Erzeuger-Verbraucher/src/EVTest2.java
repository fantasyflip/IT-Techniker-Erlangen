public class EVTest2 {
    public static void main (String args[]) {
        GuterWert   w = new GuterWert();
        Erzeuger    e = new Erzeuger(w);
        Verbraucher v = new Verbraucher(w);
        e.start();
        v.start();
    }
}