#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void task1(); // Bubblesort
void task2(); // 1D-Array sortieren

//Funktionen zu Task1: Bubblesort
void doubleBubbleSort(double *items, int length);
void printDoubleArray(double *items, int length);

//Funktionen zu Task2: 1D-Array sortieren
void printSentence(char *sentence, int length);
void charBubbleSort(char *items, int length);
void charArrayInvert(char *items, int length);

int main()
{
    task2();

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
