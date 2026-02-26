import java.io.*;
import java.util.*;

// Verwaltet das gemeinsame Trainingsbuch, in das mehrere Threads schreiben können.
public class Trainingsbuch {
    private BufferedWriter bw;

    public Trainingsbuch (String dateiName) throws IOException {
        // Öffnet die Datei im Anhangmodus, damit bestehende Einträge erhalten bleiben
        bw = new BufferedWriter(new FileWriter(dateiName, true)); // Anhängen an bestehende Datei
    }

    public synchronized void writeEntry(String schwimmerName) throws IOException {
        // Kritischer Abschnitt (Threads):
        // synchronized sperrt die Methode auf dem Trainingsbuch-Objekt,
        // sodass immer nur ein Thread gleichzeitig in die Datei schreibt.
        // Erstellt einen Zeitstempel-Eintrag und schreibt ihn thread-sicher in die Datei
        String entry = String.format("%s: %s\n", schwimmerName, new Date().toString());
        bw.write(entry);
    }

    public void schließen() throws IOException {
        // Gibt die Dateiresource frei
        bw.close();
    }
}
