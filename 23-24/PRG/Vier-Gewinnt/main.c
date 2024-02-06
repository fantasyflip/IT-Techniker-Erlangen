#include <stdio.h>
#include <windows.h>

#define ROWS 6
#define COLS 7

void printField(int field[ROWS][COLS]){

    system("cls");

    //Number Header
    for(int i = 1; i <= COLS; i++){
        printf(" %i",i);
    }

    //Field
    printf("\n|");

    for(int i = 0; i < ROWS; i++){
        for(int j = 0; j < COLS; j++){
            if(field[i][j] == 0){   //empty space
                printf(" |");
            }
            if(field[i][j] == 1){   //red player
                printf("X|");
            }
            if(field[i][j] == 2){   //yellow player
                printf("O|");
            }
        }
        if(i < ROWS -1){
            printf("\n|");
        }
    }

    //Bottom Line
    printf("\n");

    for(int i = 0; i < COLS; i++){
        printf("%c%c",238,238);
    }
    printf("%c",238);
}

int selectCol(){
    int col=-1;

    printf("\n\nSpalte waehlen: ");
    scanf("%d", &col);

    printf("\nSpalte %i wurde gewaehlt.\n", col);
    return (col-1);
}

int main()
{

//    int field[ROWS][COLS];

    //fill field with empty spaces (dynamic depending on constants)
//    for(int i = 0; i < ROWS; i++){
//        for(int j = 0; j < COLS; j++){
//            field[i][j] = 0;
//        }
//    }

    //instructor way of filling field (static, not automatically adjusting)
    int field[ROWS][COLS]={
        0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,
    };

    while(1){
        printField(field);
        int selectedCol = selectCol();

        int freeSpaces=-1;

        for(int i = 0; i < ROWS; i++){
            if(field[i][selectedCol] == 0){
                freeSpaces = i + 1;
            }
        }

        if(freeSpaces == -1){
            printf("Spalte ist voll");
        } else {
            for(int i = 0; i < freeSpaces ; i++){
                field[i][selectedCol] = 1;
                printField(field);

                if(i != freeSpaces-1){
                    field[i][selectedCol] = 0;
                }
            }
        }



    }

    printf("\n\n\n");
    return 0;
}
