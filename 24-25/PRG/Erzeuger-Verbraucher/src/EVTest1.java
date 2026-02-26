public class EVTest1 {
    public static void main (String args[]) {
        SchlechterWert  w = new SchlechterWert();
        Erzeuger        e = new Erzeuger(w);
        Verbraucher     v = new Verbraucher(w);
        e.start();
        v.start();
    }
}