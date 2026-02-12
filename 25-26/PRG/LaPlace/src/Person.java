import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

// Die Klasse Person stellt einen Teilnehmer des Experiments dar
class Person extends Thread {
    private final int id;
    private final Semaphore semaphore;
    private static final String DATEI_PFAD = "laplace.txt";

    public Person(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        Random random = new Random();

        // Jede Person soll 10x würfeln 
        // Ein Experiment besteht aus jeweils drei Würfen
        for (int i = 0; i < 10; i++) {
            int w1 = random.nextInt(6) + 1;
            int w2 = random.nextInt(6) + 1;
            int w3 = random.nextInt(6) + 1;
            String zeile = w1 + "," + w2 + "," + w3;

            try {
                // Semaphore sperren, um exklusiven Zugriff auf die Datei zu erhalten 
                semaphore.acquire();

                // Schreiben der Ergebniszeile in die Datei (Anhängen aktiviert) 
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATEI_PFAD, true))) {
                    writer.write(zeile);
                    writer.newLine();
                }

            } catch (InterruptedException | IOException e) {
                System.err.println("Fehler bei Person " + id + ": " + e.getMessage());
            } finally {
                // Semaphore wieder freigeben, damit die nächste Person schreiben kann 
                semaphore.release();
            }
        }
    }
}