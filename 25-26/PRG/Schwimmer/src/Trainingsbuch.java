import java.io.*;
import java.util.*;

public class Trainingsbuch {
    private BufferedWriter bw;

    public Trainingsbuch (String dateiName) throws IOException {
        bw = new BufferedWriter(new FileWriter(dateiName, true)); // Anhängen an bestehende Datei
    }

    public synchronized void writeEntry(String schwimmerName) throws IOException {
        String entry = String.format("%s: %s\n", schwimmerName, new Date().toString());
        bw.write(entry);
    }

    public void schließen() throws IOException {
        bw.close();
    }
}
