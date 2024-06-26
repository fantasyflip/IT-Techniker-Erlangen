#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

void task1(); // Bubblesort
void task2(); // 1D-Array sortieren
void task3(); // 2D-Array sortieren
void task4(); // 3D-Textarray umsortieren
void task5a(); // Dynamischer int
void task5b(); // Dynamischer int array
void task5c(); // Dynamischer 2D int array
void task6(); // String suchen
void task7(); // Speicher-Adressen
void task8(); // Dezimal-zu-Irgendetwas
void task9(); // String vertauschen

//Funktionen zu Task1: Bubblesort
void doubleBubbleSort(double *items, int length);
void printDoubleArray(double *items, int length);

//Funktionen zu Task2: 1D-Array sortieren
void printSentence(char *sentence, int length);
void charBubbleSort(char *items, int length);
void charArrayInvert(char *items, int length);

//Funktionen zu Task3: 2D-Array sortieren
void printWords(char **items, int length);
void stringBubbleSort(char **items, int length);

// Funktionen zu Task4: 3D-Textarray umsortieren
#define IND_MAX 4
#define LEN_MAX 15
void printNames(char names[IND_MAX][IND_MAX][LEN_MAX]);
void exchangeNames(char names[IND_MAX][IND_MAX][LEN_MAX]);

//Funktionen zu Task8: Dezimal-zu-Irgendetwas
#define TARGET_BASE 16
void convertToBase(int number, int base, char* result);

int main()
{
//    task1();
//    task2();
//    task3();
//    task4();
//    task5a();
//    task5b();
//    task5c();
//    task6();
//    task7();
//    task8();
    task9();

    printf("\n\n");
    return 0;
}

// Task1: Bubblesort
void task1(){
    // srand initialisieren
    srand(time(NULL));

    int itemCount = 20;
    double items[itemCount];

    // array mit zufälligen doubles füllen
    for(int i = 0; i < itemCount; i++){
        items[i] = (rand() % 100) * (rand() * 0.001);
    }

    // array ausgeben
    printDoubleArray(items, itemCount);

    // array sortieren
    doubleBubbleSort(items, itemCount);

    // array ausgeben
    printDoubleArray(items, itemCount);


}

void printDoubleArray(double *items, int length){
    for(int i = 0; i < length; i++){
       printf("%.2f\t",items[i]);
    }
    printf("\n");
}

void doubleBubbleSort(double *items, int length){
    int runs = 0;
    int swaps = 0;
    // wiederholen solange im vorherigen durchlauf ein swap stattgefunden hat
    do {
       runs++;
       swaps = 0;
       // array durchgehen
        for(int i = 0; i < length-1; i++){
           // element und folgeelement vergleichen und bei bedarf tauschen -> swap hochzählen
           if(items[i] > items[i+1]){
               double temp = items[i];
               items[i] = items[i+1];
               items[i+1] = temp;
               swaps++;
           }
        }
    } while(swaps != 0);

    printf("\nSortiert nach %d Durchlaeufen!\n\n", runs);
}

// Task2: 1D-Array sortieren
void task2(){
    char sentence[] = "Heute ist ein schoener Tag. Die Luft ist frisch und klar. Es ist nicht zu warum und nicht zu kalt.";
    // Länge des Satzes berechnen
    int length = sizeof(sentence)/sizeof(sentence[0]);

    // Satz ausgeben
    printSentence(sentence, length);

    // Buchstaben sortieren
    charBubbleSort(sentence, length);

    // Buchstabenfolge ausgeben
    printf("Aufsteigend:\n");
    printSentence(sentence, length);

    // Buchstabenfolge invertieren
    charArrayInvert(sentence, length);

    // Buchstabenfolge ausgeben
    printf("Absteigend:\n");
    printSentence(sentence, length);

}

void printSentence(char *sentence, int length){
    for(int i = 0; i < length; i++){
        printf("%c", sentence[i]);
    }
    printf("\n");
}

void charBubbleSort(char *items, int length){
    int runs = 0;
    int swaps = 0;
    // wiederholen solange im vorherigen durchlauf ein swap stattgefunden hat
    do {
        runs++;
        swaps = 0;
        // array durchgehen
        for(int i = 0; i < length-1; i++){
           // element und folgeelement vergleichen und bei bedarf tauschen -> swap hochzählen
           if(items[i] > items[i+1]){
               char temp = items[i];
               items[i] = items[i+1];
               items[i+1] = temp;
               swaps++;
           }
        }
    } while(swaps != 0);

    printf("\nSortiert nach %d Durchlaeufen!\n\n", runs);
}

void charArrayInvert(char *items, int length){
    int start = 0;
    int end = length - 1;
    char temp;

    // Elemente von vorne nach hinten tauschen
    // Abbrechen, wenn die Zähler sich überschneiden
    while (start < end) {
        // Element an pos. start mit Element an pos. end tauschen
        temp = items[start];
        items[start] = items[end];
        items[end] = temp;

        // Jeweils einen Schritt weiter in die Mitte
        start++;
        end--;
    }
}

// Task3: 2D-Array sortieren
void task3(){
    char *words[] = {"Zeppelin", "Anton", "Hugo", "Xaver", "Alfred", "Eva", "Anna", "Anne", NULL};

    // Anzahl der Wörter erhalten
    int wordCount = 0;
    while (words[wordCount] != NULL) {
        wordCount++;
    }

    // Wörter ausgeben
    printWords(words, wordCount);

    // Wörter sortieren
    stringBubbleSort(words, wordCount);

    //Wörter ausgeben
    printf("\n");
    printWords(words, wordCount);

}

void printWords(char **items, int length){
    for(int i = 0; i < length; i++) {
        printf("%d.\t%s\n", i + 1, items[i]);
    }
}

void stringBubbleSort(char **items, int length){
    int swaps;
    // Solange im letzten Vorgang ein Swap gemacht wurde wird wiederholt
    do {
        swaps = 0;
        // Alle Wörter durchgehen
        for(int i = 0; i < length-1; i++){
           // Wortpaar auswählen
            char *word1 = items[i];
            char *word2 = items[i+1];

            // Wortpaar Buchstabe für Buchstabe vergleichen
            int needsSwap = 0;
            for(int j = 0; (word1[j] != '\0') && (word2[j] != '\0'); j++){
               // Buchstabe ist größer -> Swap
               if (word1[j] > word2[j]){
                   needsSwap = 1;
                   break;
               } else if (word1[j] < word2[j]) {
                   // Buchstabe ist kleiner -> Kein Swap
                   break;
               }
               // Buchstaben sind identisch -> Nächster Buchstabe
            }

            // Elemente im Wort-Array tauschen
            if(needsSwap == 1){
               char *temp = items[i];
               items[i] = items[i+1];
               items[i+1] = temp;
               swaps++;
            }
        }
    } while(swaps != 0);
}

// Task4: 3D-Textarray umsortieren
void task4(){
    char names[IND_MAX][IND_MAX][LEN_MAX]={
     "Peter","Paul","Eva","Adelheid",
     "Sepp","Anna","Karlheinz","Christina",
     "Magdalena","Maria","Klaus","Thomas",
     "Michael","Ernst","Timo","Toni"};

    // Namen ausgeben
    printNames(names);

    // Position der Namen tauschen
    exchangeNames(names);
    printf("\n");
    // Namen ausgeben
    printNames(names);
}

void printNames(char names[IND_MAX][IND_MAX][LEN_MAX]){
    for(int i = 0; i < IND_MAX; i++){
        for(int j = 0; j < IND_MAX; j++){
            printf("%-12s\t",names[i][j]);
        }
        printf("\n");
    }
}

void exchangeNames(char names[IND_MAX][IND_MAX][LEN_MAX]){
    for(int i = 0; i < IND_MAX; i++){
        // j = i + 1 ---- Damit die Namen nicht wieder zurück getauscht werden in einem spätern Durchlauf
        for(int j = i + 1; j < IND_MAX; j++){
            // Dreieckstausch der Namen
            char temp[LEN_MAX];
            strcpy(temp, names[i][j]);
            strcpy(names[i][j], names[j][i]);
            strcpy(names[j][i], temp);
        }
    }
}

// Task5a: Dynamischer int
void task5a(){
    // Speicher für int reservieren
    int * number = calloc(1, sizeof(int));

    // Fehler bei der Reservierung abfangen
    if(number == NULL){
        printf("Speicher konnte nicht angefordert werden.");
        exit(1);
    }

    srand(time(NULL));

    // Zufallszal zwischen 1 und 10
    *number = (rand() % 10) + 1;

    printf("Zufallszahl: %d", *number);

    // Speicher freigeben
    free(number);
}

// Task5b: Dynmischer int array
void task5b(){
    int arrayLength = 8;
    // Speicher für Array reservieren
    int * numbers = calloc(arrayLength, sizeof(int));

    // Fehler bei der Reservierung abfangen
    if(numbers == NULL){
        printf("Speicher konnte nicht angefordert werden.");
        exit(1);
    }

    srand(time(NULL));

    // Array mit Zufallszahlen füllen
    for(int i = 0; i < arrayLength; i++){
        numbers[i] = (rand() % 10) + 1;
    }

    // Array ausgeben
    for(int i = 0; i < arrayLength; i++){
        printf("%d\n", numbers[i]);
    }

    // Speicher freigeben
    free(numbers);
}

// Task5c: Dynamischer 2D int array
void task5c() {
    int rows = 8;
    int cols = 5;

    // Speicher reservieren
    int **field = calloc(rows, sizeof(int*));
    // Fehler abfangen
    if(field == NULL){
        printf("Speicher konnte nicht angefordert werden.");
        exit(1);
    }

    // Speicher für Spalten in Zeilen reservieren und ggf. Fehler abfangen
    for(int i = 0; i < rows; i++){
        field[i] = calloc(cols, sizeof(int));
        if(field[i] == NULL){
            printf("Speicher konnte nicht angefordert werden.");
            exit(1);
        }
    }

    srand(time(NULL));

    // 2D Array mit Zufallszahlen reservieren
    for(int i = 0; i < rows; i ++){
        for(int j = 0; j < cols; j++){
            field[i][j] = (rand() % 10) + 1;
        }
    }

    // 2D Array ausgeben
    for(int i = 0; i < rows; i ++){
        for(int j = 0; j < cols; j++){
            printf("%-3d", field[i][j]);
        }
        printf("\n");
    }

    // Speicher für jede Spalte freigeben
    for(int i = 0; i < rows; i++){
        free(field[i]);
    }
    // Speicher für Zeilen freigeben
    free(field);
}

// Task6: String suchen
void task6(){
    char text[] = "Der String Hallo Welt wird oft verwendet, um Hallo Welt auszugeben. Hallo Welt ist super!";
    char searchString[] = "Hallo Welt";

    // textlänge berechnen
    int textLength = sizeof(text)/sizeof(char)-1;
    int searchLength = sizeof(searchString)/sizeof(char)-1;
    // maximale anzahl von vorkommnissen
    int maxOccurences = textLength / searchLength;

    // Vorkommnisse Startwerte und Anzahl
    int occurences[maxOccurences];
    int occurenceCount = 0;

    // Text durchgehen
    for(int i = 0; i < textLength; i++){
        // Wenn Anfangsbuchstabe passt
        if(text[i] == searchString[0]){
            // Kompletten searchString mit folgendem Text-Abschnittabgleichen
            for(int j = 0; j < searchLength; j++){
               if(text[i+j]!=searchString[j]){
                   // Bei unterschieden Abgleich beenden
                   break;
               } else if(j == searchLength - 1){
                   // Wenn identisch Startwert speichern und Anzahl erhöhen
                   occurences[occurenceCount] = i;
                   occurenceCount++;
               }
            }
        }
    }

    // Guide-String genauso lang wie text
    char guideString[textLength + 1];

    // Guide-String mit Leerzeichen füllen und Terminator setzen
    for(int i = 0; i < textLength; i++){
        guideString[i] = ' ';
    }
    guideString[textLength] = '\0';

    // Occurence Pointer passend setzen
    for(int i = 0; i < occurenceCount; i++){
        guideString[occurences[i]] = '^';
        guideString[occurences[i]+searchLength-1] = '^';
    }

    // Text und Guide-String ausgeben
    printf("%s\n", text);
    printf("%s\n", guideString);
}

// Task7: Speicher-Adressen
void task7(){
    // a)
    int zahlen[20];

    for(int i = 0; i < 20; i++){
        zahlen[i] = i;
    }

    // b)
    for(int i = 0; i < 20; i++){
        printf("Adresse fuer Index %d:\t %p\n", i, &zahlen[i]);
    }

    // c)
    int *adressen[20];
    for(int i = 0; i < 20; i++){
        adressen[i] = &zahlen[i];
    }

    printf("\n\n");
    // d)
    for(int i = 0; i < 20; i++){
        printf("Adresse der Adresse am Index %d: %p\n", i, &adressen[i]);
    }
}

// Task8: Dezimal-zu-Irgendetwas
void task8(){
    int number;
    char result[33];  // Ein zusätzlicher Platz für die Nullterminierung

    printf("Geben Sie eine Dezimalzahl ein: ");
    scanf("%d", &number);

    convertToBase(number, TARGET_BASE, result);

    printf("Dezimalzahl: %d\n", number);
    printf("Zahl im Basis-%d-System: %s\n", TARGET_BASE, result);
}

void convertToBase(int number, int base, char* result) {
    char digits[] = "0123456789ABCDEF";
    int index = 31;  // Maximal 32 Stellen für Binärdarstellung
    result[32] = '\0';  // Nullterminierung

    // Wenn die Zahl 0 ist
    if (number == 0) {
        result[31] = '0';
        return;
    }

    while (number > 0) {
        result[index--] = digits[number % base];
        number /= base;
    }

    // Verschiebe das Ergebnis nach vorne, falls erforderlich
    for (int i = index + 1; i < 32; i++) {
        result[i - (index + 1)] = result[i];
    }
    result[32 - (index + 1)] = '\0';  // Nullterminierung des verschobenen Strings
}

// Task9: String vertauschen
void task9(){
    char string[] = "12345678901234567890";

    // index, länge und offset definieren
    int index = 0;
    int length = sizeof(string)/sizeof(string[0])-1;
    int offset = 3;

    // string ausgeben
    printf("Startstring: %s\n", string);

    // Fußgesteuerte while schleife
    do {
        // dreieckstausch
        char temp = string[index];
        string[index] = string[index + offset];
        string [index + offset] = temp;

        // index um 2*offset erhöhen damit immer einzelne paare getauscht werden und nicht im Folgedurchlauf wieder eine Zahl aus dem vorherigen Durchlauf vertauscht wird
        index = index + 2*offset;

        // Schleife beenden wenn das nächste Tauschelement außerhalb des Arrays liegt
    } while (index+3 <= length);

    printf("Endstring: %s\n", string);
}
