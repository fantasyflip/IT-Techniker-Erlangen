#include <stdio.h>
#include <windows.h>
#include <unistd.h>

#define ROWS 6
#define COLS 7

//instructor way of filling field (static, not automatically adjusting)
int field[ROWS][COLS]={
    0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,
    0,0,0,0,0,0,0,
};

void printField(){

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
    int castCount = -1;

    printf("\nSpalte waehlen: ");
    castCount = scanf("%d", &col);

    if(col > COLS || col < 0 || castCount != 1){
        printf("\nUngueltige Eingabe. Bitte erneut versuchen.");

        // Clear the input buffer
        int c;
        while ((c = getchar()) != '\n' && c != EOF);

        return selectCol();
    }

    return (col-1);
}

void makeTurn(int selectedCol, int player){
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
            field[i][selectedCol] = player;
            printField();

            if(i != freeSpaces-1){
                usleep(60000);
                field[i][selectedCol] = 0;
            }
        }
    }
}

int checkFieldFull(){
    int hasFreeSpace = 0;

    for(int i = 0; i < ROWS; i++){
        for(int j = 0; j < COLS; j++){
            if(field[i][j]==0){
                hasFreeSpace = 1;
                j = COLS;
                i = ROWS;
            }
        }
    }

    if(hasFreeSpace == 0){
        return 1;
    } else {
        return 0;
    }
}

int randomNotEmptyCol(){
    //get random Col number
    int randomCol = rand() % COLS;

    int hasFreeSpace = 0;

    for(int i = 0; i < ROWS; i++){
        if(field[i][randomCol] == 0){
            hasFreeSpace = 1;
            i = ROWS;
        }
    }

    if(hasFreeSpace == 0){
        return randomNotEmptyCol();
    }

    return randomCol;

}

int checkVerticalCondition(int player){
    int neighbourCount = 0;
    int hasWon = 0;

    for(int i = 0; i < COLS; i++){
        for(int j = 0; j < ROWS; j++){
            if(field[j][i] == player){
                neighbourCount++;
                if(neighbourCount == 4){
                    hasWon = 1;
                    i = COLS;
                    j = ROWS;
                }
            } else {
                neighbourCount = 0;
            }
        }
        neighbourCount = 0;
    }

    return hasWon;
}

int checkHorizontalCondition(int player){
    int neighbourCount = 0;
    int hasWon = 0;

    for(int i = 0; i < ROWS; i++){
        for(int j = 0; j < COLS; j++){
            if(field[i][j] == player){
                neighbourCount++;
                if(neighbourCount == 4){
                    hasWon = 1;
                    i = COLS;
                    j = ROWS;
                }
            } else {
                neighbourCount = 0;
            }
        }
        neighbourCount = 0;
    }

    return hasWon;
}

int checkDiagBlTrCondition(int player){
    int neighbourCount = 0;
    int hasWon = 0;

    //vertical start positions
    for(int i = (ROWS-1);i> (ROWS-1)-3;i-- ){
        for(int j = 0; j < COLS-1 && i-j >= 0; j++){
            if(field[i-j][j]==player){
                neighbourCount++;
                if(neighbourCount == 4){
                    hasWon = 1;
                    i = 0;
                }
            } else {
                neighbourCount = 0;
            }
        }
        neighbourCount = 0;
    }

    if(hasWon == 0){
        neighbourCount = 0;

        //horizontal start positions
        for(int i = 1; i < COLS-3; i++){
            for(int j = ROWS-1; j >= 0;j--){
                if(field[j][i+(ROWS-1)-j]==player){
                    neighbourCount++;
                    if(neighbourCount == 4){
                        hasWon = 1;
                        i = COLS-3;
                    }
                } else {
                    neighbourCount = 0;
                }
            }
        }
    }

    return hasWon;
}

int checkDiagTlBrCondition(int player){
    int neighbourCount = 0;
    int hasWon = 0;

    //vertical start positions
    for(int i = 0; i < ROWS-3; i++){
        for(int j = 0; j < COLS && i+j < ROWS; j++){
            if(field[i+j][j]==player){
                neighbourCount++;
                if(neighbourCount == 4){
                    hasWon = 1;
                    i = ROWS-3;
                }
            } else {
                neighbourCount = 0;
            }
        }
    }

    if(hasWon == 0){
        //horizontal start positions
        for(int i = 1; i < COLS-3;i++){
            for(int j = 0; j < ROWS; j++){
                if(field[j][i+j-1]==player){
                    neighbourCount++;
                    if(neighbourCount == 4){
                        hasWon = 1;
                        i = COLS-3;
                    }
                } else {
                    neighbourCount = 0;
                }
            }
        }
    }

    return hasWon;
}

int checkWinningConditions(){
    //0 -> niemand gewinnt
    //1 -> player 1 gewinnt
    //2 -> player 2 gewinnt
    int winner = 0;

    int hasWon = 0;
    for(int i = 1; i <=2; i++){
        hasWon = checkVerticalCondition(i);
        if(hasWon == 1){
            winner = i;
            i = 3;
        }

        if(hasWon == 0){
            hasWon = checkHorizontalCondition(i);
            if(hasWon == 1){
                winner = i;
                i = 3;
            }

            if(hasWon == 0){
                hasWon = checkDiagBlTrCondition(i);
                if(hasWon == 1){
                    winner = i;
                    i = 3;
                }

                if(hasWon == 0){
                    hasWon = checkDiagTlBrCondition(i);
                    if(hasWon == 1){
                        winner = i;
                        i = 3;
                    }
                }
            }
        }

    }

    return winner;
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


    int player = 1;
    int isGameOver = 0;
    int winner = 0;


    while(isGameOver == 0){

        printField();

        if(checkFieldFull()==1){
            isGameOver = 1;
            printf("\nSpielfeld ist voll!");
        } else {
            if(player == 1){
                makeTurn(selectCol(),player);
            } else {
                makeTurn(randomNotEmptyCol(),player);
            }


            winner = checkWinningConditions();

            if(winner != 0){
                isGameOver = 1;
                printf("\nSpieler %d hat gewonnen!", winner);
            }


            if(player == 1){
                player = 2;
            } else {
                player = 1;
            }
        }


    }

    printf("\n\n\n");
    return 0;
}
