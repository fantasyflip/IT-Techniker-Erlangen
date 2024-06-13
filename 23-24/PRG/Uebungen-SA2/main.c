#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void task1();

//Funktion
void bubbleSort(double *items, int length);
void printDoubleArray(double *items, int length);

int main()
{
    task1();

    printf("\n\n");
    return 0;
}

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
    bubbleSort(items, itemCount);

    // array ausgeben
    printDoubleArray(items, itemCount);


}

void printDoubleArray(double *items, int length){
    for(int i = 0; i < length; i++){
       printf("%.2f\t",items[i]);
    }
    printf("\n");
}

void bubbleSort(double *items, int length){
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
