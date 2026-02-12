import java.util.Scanner;
import java.util.concurrent.Semaphore;

// Die TestKlasse zur Durchführung des Laplace-Experiments
public class LaplaceTestKlasse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Abfrage der Anzahl der Teilnehmer zu Beginn des Experiments
        System.out.print("Geben Sie die Anzahl der Teilnehmer ein: ");
        int anzahlTeilnehmer = scanner.nextInt();

        // Erstellen einer Semaphore mit einem Permit (binäre Semaphore)
        // Dies garantiert, dass immer nur eine Person gleichzeitig schreibt 
        Semaphore schreibSchutz = new Semaphore(1);

        // Erstellen eines Feldes von Personen passender Größe
        Person[] personenFeld = new Person[anzahlTeilnehmer];

        // Initialisierung und Start der Personen (quasi gleichzeitig) 
        for (int i = 0; i < anzahlTeilnehmer; i++) {
            personenFeld[i] = new Person(i + 1, schreibSchutz);
            personenFeld[i].start();
        }

        // Warten, bis alle Personen ihre Arbeit beendet haben
        for (Person p : personenFeld) {
            try {
                p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Das Experiment wurde abgeschlossen. Ergebnisse in laplace.txt gespeichert.");
        scanner.close();
    }
}