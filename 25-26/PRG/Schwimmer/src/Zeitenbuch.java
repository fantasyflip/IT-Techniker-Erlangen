import java.io.*;
import java.util.*;
import java.util.Random;

// Verwaltet die Ausgabe von Sprintzeiten für alle Schwimmer.
public class Zeitenbuch {
    private BufferedWriter bw;
    private Random rnd = new Random();

    public Zeitenbuch (String dateiName) throws IOException {
        // Öffnet/überschreibt die Ausgabedatei für einen neuen Durchlauf
        bw = new BufferedWriter(new FileWriter(dateiName, false));
    }

    public synchronized void writeTime(String schwimmerName, int anzahlBahnen) throws IOException {
        // Kritischer Abschnitt (Threads):
        // synchronized verhindert parallele Schreibzugriffe auf denselben Writer.
        // So bleiben Zeilen vollständig und werden nicht ineinander vermischt.
        // Erzeugt pro Bahn eine zufällige Zeit und schreibt alles in eine Zeile
        int times[] = new int[anzahlBahnen];
        for (int i = 0; i < anzahlBahnen; i++) {
            times[i] = rnd.nextInt(110) + 42; // Generiere zufällige Zeiten zwischen 42 und 151 Sekunden
        }
        String entry = schwimmerName + ": " + Arrays.toString(times) + "\n";
        bw.write(entry);
    }

    public void schließen() throws IOException {
        // Gibt die Dateiresource frei
        bw.close();
    }
}
