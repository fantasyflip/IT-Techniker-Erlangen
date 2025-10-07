import java.io.*;

public class BufferedWriteToFile {

    // Liest alle Zeichen aus br und schreibt sie in bw

    public static void br2bw(BufferedReader br, BufferedWriter bw)

            throws IOException {

        String z;                             // Zeile

        while ((z = br.readLine()) != null) { // lesen, Stromende pruefen,

            bw.write(z);                        // ausgeben und

            bw.newLine();                       // Zeilenwechsel ausgeben

        }

        br.close();

        bw.close();

    }

    // Liest Zeilen von der Tastatur und speichert sie in einer Datei

    public static void main(String[] args) {

        try {

            File datei = new File(args[0]);

            BufferedReader in = new BufferedReader(

                    new InputStreamReader(System.in));

            BufferedWriter out = new BufferedWriter(

                    new FileWriter(datei));

            System.out.println("Geben Sie jetzt den Text ein.");

            System.out.println("(Ende/Speichern mit Ctrl-Z bzw. Strg-Z)");

            System.out.println();

            br2bw(in,out);


            in = new BufferedReader(new FileReader(datei));

            out = new BufferedWriter(new OutputStreamWriter(System.out));

            System.out.println();

            System.out.println("Der in "+ args[0] +" gespeicherte Text:");

            System.out.println();

            br2bw(in,out);

        } catch(ArrayIndexOutOfBoundsException ae) {

            System.out.println("Aufruf:  java BufferedWriteToFile <Datei>");

        } catch(IOException e) {

            System.out.println(e);

        }

    }

}