import java.util.concurrent.Semaphore;

// Wettkampf-Szenario:
// Es starten 15 Schwimmer-Threads, wobei maximal 3 gleichzeitig schwimmen dürfen.
public class Wettkampf {
    public static void main(String[] args) throws Exception {
        // Gemeinsame Ressourcen und Teilnehmerliste vorbereiten
        int anzahlSchwimmer = 15;
        // Kritischer Abschnitt (Semaphore/Threads):
        // Der Semaphore-Zähler (3) begrenzt die Anzahl gleichzeitig schwimmender Threads.
        Semaphore semSchwimmen = new Semaphore(3); // 3 Bahnen
        Trainingsbuch trainingsbuch = new Trainingsbuch("trainingsbuch.txt");
        String schwimmerNamen[] = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy", "Karl", "Leo", "Mallory", "Nina", "Oscar"};
        Schwimmer[] schwimmer = new Schwimmer[15];

        // Alle Schwimmer erzeugen und parallel starten
        for(int i = 0; i < anzahlSchwimmer; i++) {
            schwimmer[i] = new Schwimmer(schwimmerNamen[i], semSchwimmen, trainingsbuch);
            // start() startet einen neuen Thread; run() läuft damit parallel.
            schwimmer[i].start();
        }
        // Auf das Ende aller Schwimmer warten
        for(int i = 0; i < anzahlSchwimmer; i++) {
            // join() ist Synchronisation im Hauptthread: Weiter erst, wenn Thread i fertig ist.
            schwimmer[i].join();
        }
        // Trainingsbuch am Ende sauber schließen
        trainingsbuch.schließen();
    }
}
