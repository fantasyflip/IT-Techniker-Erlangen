import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Sprint-Szenario:
// Für jeden Schwimmer werden zufällige Sprintzeiten erzeugt und gespeichert.
// Anschließend wird ausgewertet, wie viele die Qualifikationszeit erreichen.
public class Sprint {
    public static void main (String[] args) throws Exception {
        // Initialisierung der Eingabedaten und der Ausgabedatei
        String schwimmerNamen[] = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy", "Karl", "Leo", "Mallory", "Nina", "Oscar"};
        int anzahlBahnen = 3;
        String path = "sprint_zeiten.txt";
        Zeitenbuch zeitenbuch = new Zeitenbuch(path);

        // Erzeuge für jeden Schwimmer Zeiten und schreibe sie ins Zeitenbuch
        for (String name : schwimmerNamen) {
            zeitenbuch.writeTime(name, anzahlBahnen);
        }
        zeitenbuch.schließen();

        System.out.println("Alle Zeiten wurden ins Sprint-Zeitenbuch eingetragen.");

        // Kritischer Abschnitt (Regex):
        // \b42\b sucht die Zahl 42 als eigenes Wort, damit z. B. 142 oder 420
        // nicht fälschlich als Treffer gezählt werden.
        Pattern qualificationPattern = Pattern.compile("\\b42\\b");
        int countQualified = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                // Für jede Zeile wird ein Matcher erzeugt; find() prüft,
                // ob die Qualifikationszeit irgendwo in der Zeile vorkommt.
                Matcher m = qualificationPattern.matcher(line);
                if(m.find()){
                    countQualified++;
                }
            }
            System.out.println(countQualified + " Schwimmer haben die Qualifikationszeit von 42 Sekunden erreicht.");
        } catch (FileNotFoundException e) {
            System.err.println("Die Datei " + path + " wurde nicht gefunden.");
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei " + path);
        }

    }
}
