import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SplitSentence_Test {
    public static void main(String[] args) {

        // Get sentence from user
        System.out.println("Enter a Sentence to split into unique tokens:");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();


        // Remove all symbols to have truly unique words
        sentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "");

        //  Split sentence into tokens
        StringTokenizer st = new StringTokenizer(sentence, " ");

        // Create TreeSet to store unique words
        TreeSet<String> uniqueWords = new TreeSet<String>();

        // Put all tokens into the TreeSet
        while (st.hasMoreTokens()) {
            uniqueWords.add(st.nextToken());
        }

        // Print the TreeSet
        System.out.println();
        System.out.println("Alle Wörter des Textes, ohne Duplikate:");
        System.out.println();


        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}
