import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Sprint {
    public static void main (String[] args) throws Exception {
        String schwimmerNamen[] = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy", "Karl", "Leo", "Mallory", "Nina", "Oscar"};
        int anzahlBahnen = 3;
        String path = "sprint_zeiten.txt";
        Zeitenbuch zeitenbuch = new Zeitenbuch(path);

        for (String name : schwimmerNamen) {
            zeitenbuch.writeTime(name, anzahlBahnen);
        }
        zeitenbuch.schließen();

        System.out.println("Alle Zeiten wurden ins Sprint-Zeitenbuch eingetragen.");

        Pattern qualificationPattern = Pattern.compile("\\b42\\b");
        int countQualified = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
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
