#include <stdio.h>
#include <stdlib.h>
// stdlib.h für calloc, malloc, realloc, free
//Free: Deallocates the memory previously allocated
//malloc: Allocates the requested memory and returns a pointer to it.
//calloc: Allocates the requested memory and returns a pointer to it.
//reallocAttempts to resize the memory block pointed to by ptr that was previously allocated with a call to malloc or calloc.
void cleanup1(int ***array, int x, int i);
void cleanup2(int ***array, int x, int i, int y);


void cleanup1(int ***array, int x, int i){
    for(int j = 0; j < i; j++){
        free(array[j]);
    }
    free(array);
}

void cleanup2(int ***array, int x, int i, int y){
    for(int j= 0; j < i; j++){
        for(int k= 0; k < y; k++){
            free(array[j][k]);
        }
        free(array[j]);
    }
    free(array);
}

int main()
{
    int x = 3;
    int y = 4;
    int z = 5;

    int ***array_3d = (int ***)malloc(x * sizeof(int **)); // Allokierung des 3 Dimensional arrays
    if(array_3d == NULL){
        printf("Speicher ist voll !! Allokierung ist nicht möglich.");
            return 42;
    }
    for (int i = 0; i < y; i++) {
        array_3d[i] = (int **)malloc(y * sizeof(int *));
        if(array_3d[i] == NULL){
            printf("Speicher ist voll !! Allokierung ist nicht möglich.");
            //free(array_3d); //Speicher freigeben
            // Schreibe Funktion, die alle Teilarrays array_3d[i] von Index i: 0 bis i -1 freigibt
            // und Array array_3d
            cleanup1(array_3d, x, i);

        }
        for (int j = 0; j < z; j++) {
            array_3d[i][j] = (int *)malloc(z * sizeof(int));
            if(array_3d[i][j] == NULL){
                printf("Speicher ist voll !! Allokierung ist nicht möglich.");
                //free(array_3d); //Speicher freigeben
                // Schreibe Funktion, die alle Teilarrays array_3d[i][j] von Index j: 0 bis j-1 freigibt
                // und alle Teilarrays array_3d[i] mit Index i: 0 bis y-1 freigibt
                // und Array array_3d freigibt
                cleanup2(array_3d,x,i,y);
            }
        }
    }
    // Arbeiten mit dem 3D-Array
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            for (int k = 0; k < z; k++) {
                array_3d[i][j][k] = i * 100 + j * 10 + k;
                // Hier Wird das 3D-Array eindeutig mit Werten füllen
                // so wird berechnen i*100, j*10 und k bleibt unverändert
                //Bsp: Angenommen array_3d[1][0][3]
                // 1*100 +0*10 +3 = 103
            }
        }
    }
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            for (int k = 0; k < z; k++) {
                printf("array[%d][%d][%d] = %d\n", i, j, k, array_3d[i][j][k]);
            }
        }
    }
    //free(array_3d);
    return 0;
}
