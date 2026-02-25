import java.util.concurrent.Semaphore;
import java.io.*;

public class Schwimmer extends Thread {
    private Semaphore semSchwimmen;
    private Trainingsbuch trainingsbuch;
    private String name;

    public Schwimmer (String name, Semaphore semSchwimmen, Trainingsbuch trainingsbuch) {
        this.name = name;
        this.semSchwimmen = semSchwimmen;
        this.trainingsbuch = trainingsbuch;
    }

    public void run() {
        try {
            System.out.println(name + " wartet auf freie Bahn...");
            semSchwimmen.acquire();
            System.out.println(name + " schwimmt...");
            Thread.sleep((long)(Math.random() * 5000)); // Simuliere Schwimmzeit
            System.out.println(name + " ist fertig.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semSchwimmen.release();
        }

        try {
            System.out.println(name + " möchte sein Training ins Buch eintragen...");
            trainingsbuch.writeEntry(name);
            System.out.println(name + " trägt sein Training ins Buch ein...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
