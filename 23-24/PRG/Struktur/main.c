#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// 1D Array mit int-Zahlen
// dynamisch als Array verwalten
// 1. Zeigervariable Typ int* um Inhalt anzusprechen
// 2. maximale mögliche Länge
// 3. Anzahl der Elemente, die bereits gespeichert
//
// Für ein Konglomerat aus Variablen verschiedener Typen gibt es den Datentyp struct


// Definition des Datentyps

struct int_vect_1D {
    int* ptr;   // Speicheradresse, um auf den Inthalt zuzugreifen
    int len;    // momentante Anzahl
    int cap;    // maxmal mögliche Anzahl
};

void createIntVect1D(struct int_vect_1D *ptr);
void deleteIntVect1D(struct int_vect_1D *ptr);
void randomInit(struct int_vect_1D *ptr);
void pirntIntVect1D(struct int_vect_1D *ptr);

int main()
{
    struct int_vect_1D vektor1;

    createIntVect1D(&vektor1);

    randomInit(&vektor1);

    pirntIntVect1D(&vektor1);

    deleteIntVect1D(&vektor1);

    return 0;
}

void createIntVect1D(struct int_vect_1D *ptr){
    ptr->ptr = (int*) calloc(100,sizeof(int));
    if(ptr == NULL){
        printf("Allocation error. Exiting...");
        exit(1);
    }
    ptr->len = 0;
    ptr->cap = 100;
}

void deleteIntVect1D(struct int_vect_1D *ptr){
    if(ptr->ptr != NULL){
        free(ptr->ptr);
        ptr->cap = 0;
        ptr->len = 0;
    }
}

void randomInit(struct int_vect_1D *ptr){

    srand(time(NULL));

    for(int i = 0; i < ptr->cap; i++){
        (ptr->ptr)[i] = rand();
    }

    ptr->len = ptr->cap;
}

void pirntIntVect1D(struct int_vect_1D *ptr){
    for(int i = 0; i < ptr->len; i++){
        printf("%d:\t %d\n", i+1, (ptr->ptr)[i]);
    }
}
