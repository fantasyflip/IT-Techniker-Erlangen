import java.util.concurrent.Semaphore;
import java.io.*;

// Ein Schwimmer läuft als eigener Thread und durchläuft zwei Phasen:
// 1) Schwimmen auf einer begrenzten Anzahl an Bahnen
// 2) Dokumentation des Trainings im gemeinsamen Trainingsbuch
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
        // Schwimmphase: Warten auf freie Bahn, schwimmen und Bahn wieder freigeben
        try {
            System.out.println(name + " wartet auf freie Bahn...");
            // Kritischer Abschnitt (Semaphore/Threads):
            // acquire() reserviert exklusiv eine Bahn. Sind alle Permits belegt,
            // blockiert der Thread, bis ein anderer Thread release() aufruft.
            semSchwimmen.acquire();
            System.out.println(name + " schwimmt...");
            Thread.sleep((long)(Math.random() * 5000)); // Simuliere Schwimmzeit
            System.out.println(name + " ist fertig.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Kritischer Abschnitt (Semaphore/Threads):
            // release() gibt den Permit zuverlässig frei (auch bei Fehlern),
            // damit wartende Threads weiterarbeiten können.
            semSchwimmen.release();
        }

        // Dokumentationsphase: Trainingseintrag thread-sicher im Trainingsbuch speichern
        try {
            System.out.println(name + " möchte sein Training ins Buch eintragen...");
            trainingsbuch.writeEntry(name);
            System.out.println(name + " trägt sein Training ins Buch ein...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
