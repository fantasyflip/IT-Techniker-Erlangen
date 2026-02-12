import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    void main() {
        // Pfad zur Datei, die eingelesen werden soll
        String filePath = "laplace.txt";

        // Der Reguläre Ausdruck:
        // ^ steht für den Zeilenanfang
        // 6,6,6 ist der gesuchte Text
        // $ steht für das Zeilenende (stellt sicher, dass nichts anderes in der Zeile steht)
        String regex = "^6,6,6$";

        // Das Pattern-Objekt vorkompilieren, um die Performance bei vielen Zeilen zu steigern
        Pattern pattern = Pattern.compile(regex);

        // Zähler für die Treffer
        int count = 0;

        // Try-with-Resources: Öffnet den Reader und schließt ihn automatisch am Ende (auch bei Fehlern)
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Die Datei Zeile für Zeile durchgehen, bis das Ende erreicht ist (null)
            while ((line = reader.readLine()) != null) {
                // Prüfen, ob die aktuelle Zeile exakt dem Muster "6,6,6" entspricht
                if (pattern.matcher(line).matches()) {
                    count++; // Wenn ja, Zähler um 1 erhöhen
                }
            }
        } catch (IOException e) {
            // Falls die Datei nicht existiert oder nicht lesbar ist
            IO.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }

        // Endergebnis auf der Konsole ausgeben
        IO.println("Anzahl der Zeilen mit 6,6,6: " + count);
    }
}