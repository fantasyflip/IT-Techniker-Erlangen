import java.io.*;
import java.util.*;
import java.util.Random;

public class Zeitenbuch {
    private BufferedWriter bw;
    private Random rnd = new Random();

    public Zeitenbuch (String dateiName) throws IOException {
        bw = new BufferedWriter(new FileWriter(dateiName, false));
    }

    public synchronized void writeTime(String schwimmerName, int anzahlBahnen) throws IOException {
        int times[] = new int[anzahlBahnen];
        for (int i = 0; i < anzahlBahnen; i++) {
            times[i] = rnd.nextInt(110) + 42; // Generiere zufällige Zeiten zwischen 42 und 151 Sekunden
        }
        String entry = schwimmerName + ": " + Arrays.toString(times) + "\n";
        bw.write(entry);
    }

    public void schließen() throws IOException {
        bw.close();
    }
}
