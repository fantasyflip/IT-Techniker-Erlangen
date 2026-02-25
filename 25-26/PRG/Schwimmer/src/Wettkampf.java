import java.util.concurrent.Semaphore;

public class Wettkampf {
    public static void main(String[] args) throws Exception {
        int anzahlSchwimmer = 15;
        Semaphore semSchwimmen = new Semaphore(3); // 3 Bahnen
        Trainingsbuch trainingsbuch = new Trainingsbuch("trainingsbuch.txt");
        String schwimmerNamen[] = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy", "Karl", "Leo", "Mallory", "Nina", "Oscar"};
        Schwimmer[] schwimmer = new Schwimmer[15];

        for(int i = 0; i < anzahlSchwimmer; i++) {
            schwimmer[i] = new Schwimmer(schwimmerNamen[i], semSchwimmen, trainingsbuch);
            schwimmer[i].start();
        }
        for(int i = 0; i < anzahlSchwimmer; i++) {
            schwimmer[i].join();
        }
        trainingsbuch.schließen();
    }
}
