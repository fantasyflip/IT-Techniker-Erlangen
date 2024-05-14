#include <stdio.h>
#include <stdlib.h>

// stdlib.h für calloc, malloc, realloc, free

int main()
{
    // Bisher wurden Arrays statisch deklariert. Dies bedeutet, dass vor der Kompilierung
    // die Größe feststehen musste und nicht mehr veränderbar war.
    // z.B. int zahlen[10]; oder int spielfeld[5][7];

    // Jetzt wird alles dynamisch!

    // Ein Dimensional

    int* adr_zahlen;
    int len;

    printf("Geben Sie die Laenge des Arrays an: ");
    scanf("%d",&len);

    adr_zahlen = (int*)calloc(sizeof(int),len);

    if(adr_zahlen == NULL){
        printf("Fehler beim Anlegen des Arrays zahlen. Beende nun das Programm... \n");
        exit(42);
    }

    adr_zahlen[0]=1;
    adr_zahlen[1]=25;

    printf("%d %d \n",adr_zahlen[0],adr_zahlen[1]);

    free(adr_zahlen);

    // Zwei Dimensional

    int** spielfeld = (int**)calloc(sizeof(int*),6);

    if(spielfeld != NULL){
        for(int i = 0; i < 6; i++){
            spielfeld[i] = (int*)calloc(sizeof(int),7);
            if(spielfeld[i] == NULL){
                printf("Fehler beim Anlegen des Arrays zahlen. Beende nun das Programm... \n");
                exit(42);
            }
        }

    } else {
        printf("Fehler beim Anlegen des Arrays zahlen. Beende nun das Programm... \n");
        exit(42);
    }

    spielfeld[0][1] = 1;

    printf("%d\n", spielfeld[0][1]);

    for(int i = 0; i < 6; i++){
        free(spielfeld[i]);
    }

    free(spielfeld);

    // Drei Dimensional
    int sideLength = 5;

    int*** dice = (int***)calloc(sizeof(int**),sideLength);

    if(dice == NULL){
        printf("Fehler beim Anlegen des Arrays zahlen. Beende nun das Programm... \n");
        exit(42);
    }

    for(int i = 0; i < sideLength; i++){
        dice[i] = (int**)calloc(sizeof(int*),sideLength);

        if(dice[i] == NULL){
            printf("Fehler beim Anlegen des Arrays zahlen. Beende nun das Programm... \n");
            exit(42);
        }

        for(int j = 0; j < sideLength; j++){
            dice[i][j] = (int*)calloc(sizeof(int),sideLength);

            if(dice[i][j] == NULL){
                printf("Fehler beim Anlegen des Arrays zahlen. Beende nun das Programm... \n");
                exit(42);
            }
        }
    }

    dice[0][1][2] = 123;

    printf("%d\n", dice[0][1][2]);

    for(int i = 0; i < sideLength; i++){
        for(int j = 0; j < sideLength; j++){
            free(dice[i][j]);
        }
        free(dice[i]);
    }

    free(dice);

    return 0;
}
