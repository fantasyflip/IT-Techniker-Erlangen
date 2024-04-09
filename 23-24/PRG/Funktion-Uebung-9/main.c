#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//task 2 defines
#define ARRAY_SIZE 10

//task 3 defines
#define OPPONENT 1
#define BOT 2

//task 3 structs
struct Move {
    int row, col;
};

//prototypes
//task 1
float getFloatInput();
int getIntInput();
float multiRecursive(float a, float b, int n, int current);

//task 2
void initRandom();
int getRandomNumber(int min, int max);
void printArray(int arr[], int size);
void mySort(int arr[], int size, int firstIndex);

//task 3
void printField(int array[3][3]);
void printHeader(int field[3][3], int currentPlayer);
void clrscr();
int areMovesLeft(int field[3][3], int size);
int evaluate (int field[3][3]);
int minimax(int field[3][3], int depth, int isMax);
struct Move brain(int field[3][3]);

//functions
//task 1
void task1a(){
    float a = getFloatInput();
    float b = getFloatInput();

    int n = getIntInput();
    float result = 0;

    for(int i = 0; i < n; i++){
        if(i == 0){
            result = a+b;
        } else {
            result = result * (a+b);
        }
    }

    printf("Ergebnis:\t%f\n",result);
}

void task1b(){
    float a = getFloatInput();
    float b = getFloatInput();

    int n = getIntInput();
    float result = multiRecursive(a,b,n,0);


    printf("Ergebnis:\t%f\n",(float)result);
}

float multiRecursive(float a, float b, int n, int current){
    if (current == n) {
        return 1; // End Case - Multiply with 1 and no recursive call.
    } else {
        return (a + b) * multiRecursive(a, b, n, current + 1); // Recursive case
    }
}

float getFloatInput(){
    float inputFloat;
    int castCount = -1;

    printf("Geben Sie eine Zahl ein: ");
    castCount = scanf("%f",&inputFloat);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    if(castCount != 1){
        printf("\n\nUngueltige Eingabe. Bitte erneut versuchen.");


        return getFloatInput();
    }
    return inputFloat;
}

int getIntInput(){
    int inputInt;
    int castCount = -1;

    printf("Geben Sie eine Zahl ein: ");
    castCount = scanf("%d",&inputInt);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    if(castCount != 1){
        printf("\n\nUngueltige Eingabe. Bitte erneut versuchen.");


        return getIntInput();
    }
    return inputInt;
}

//task2
void initRandom() {
    srand(time(NULL));
}

int getRandomNumber(int min, int max) {
    return min + rand() % (max - min + 1);
}


void printArray(int arr[], int size) {
    printf("Array-Inhalt:\n");
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void task2(){
    int array[ARRAY_SIZE];

    initRandom();

    for(int i = 0; i < ARRAY_SIZE; i++){
        array[i]=getRandomNumber(1,100);
    }

    printArray(array,ARRAY_SIZE);

    mySort(array, 0, ARRAY_SIZE - 1);

    printArray(array,ARRAY_SIZE);
}

void mySort(int arr[],int firstIndex, int size ) {
    if(firstIndex < size){
        int compareValue = arr[(firstIndex+size)/2]; //Select middle item
        int i = firstIndex;
        int j = size;
        int temp;

        //while i and j dont meet or pass each other
        //
        //Example-Array: 2 7 1 6 8 5 3 4
        while (i<=j){

            //search for a bigger value to the left, starting at the firstIndex
            //while loop exits when a bigger value than the compareValue was found
            //due to incrementing i every time the value was lower, the bigger item is now at the index of i
            //Example:
            //
            // FirstIndex: 0
            //
            // 2 7 1 6 8 5 3 4
            //       ^
            // Compare Value
            //
            // 1. run: 2 is lower than 6 -> i++ (i is 1)
            // 2. run: 7 is bigger than 6 -> exit while loop -> bigger element is at i = 1 (7)
            //
            //  after first swap:
            //  i is 2
            //
            //   2 4 1 6 8 5 3 7
            //         ^
            //   Compare Value
            //
            //  1. run: 1 is lower than 6 -> i++ (i is 3)
            //  2. run: 6 is not lower than 6 -> exit while loop -> bigger element is at i = 3 (6)
            //
            //      after second swap:
            //      i is 4
            //
            //      2 4 1 3 8 5 6 7
            //                  ^
            //            Compare Value
            //
            //      1. run: 8 is bigger than 6 -> exit while loop -> bigger element is at i = 4 (8)
            //
            //          after third swap:
            //          i is 5 and j is 4 -> main while loop condition is not fulfilled -> exit main while loop
            //
            while(arr[i] < compareValue) i++;
            //search for a smaller value to the right
            //while loop exits when a lower value than the compareValue was found
            //due to decrementing j every time the value was bigger, the lower item is now at the index of j
            //Example:
            //
            // size: 7
            //
            // 2 7 1 6 8 5 3 4
            //       ^
            // Compare Value
            //
            // 1. run: 4 is lower than 6 -> exit while loop -> lower element is at j = 7 (4)
            //
            //  after first swap:
            //  j is 6
            //
            //   2 4 1 6 8 5 3 7
            //         ^
            //   Compare Value
            //
            //  1.run: 3 is lower than 6 -> exit while loop -> lower element is at j = 6 (3)
            //
            //      after second swap:
            //      j is 5
            //
            //      2 4 1 3 8 5 6 7
            //                  ^
            //            Compare Value
            //
            //      1.run: 5 is lower than 6 -> exit while loop -> lower element is at j = 5 (5)
            //
            //          after third swap:
            //          j is 4 and i is 5 -> main while loop condition is not fulfilled -> exit main while loop
            //
            while(arr[j] > compareValue) j--;

            //swap item
            if(i <= j){
                //now we know of an element on the left side that belongs to the right side,
                //and an element on the right side that belongs to the left side
                //simply swap them
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                //increase i by one to continue with the next item on the left side
                i++;
                //decrease j by one to continue with the next item on the right side
                j--;

            }
        }

        //array after main while loop:
        // 2 4 1 3 5 8 6 7

        //recursive calls
        //repeat with items between j and the firstIndex (left subarray)
        //left subarray in example: 2 4 1 3 5
        if(firstIndex < j) mySort(arr, firstIndex, j);
        //repeat with items between i and size (right subarray)
        //right subarray in example: 8 6 7
        if(i < size) mySort(arr, i, size);
    }
}

//task3
void task3(){
    printf("Druecken Sie eine beliebige Taste um Tic-Tac-Toe zu starten...");

    getchar();

    int currentPlayer = 1;
    int winner = -1;
    int field[3][3] = {{0,0,0},{0,0,0},{0,0,0}};
    int coords[2] = {0,0};
    int playerTurn[2]={0,0};
    int useBrain = 1;

    initRandom();

    while(winner == -1){
        int validCoords = 0;
        do {
            printHeader(field, currentPlayer);

            validCoords = 1;

        //get user input (player 1)
        if(currentPlayer == 1){

            if(validCoords == 2){
                printf("\n\nIhre Eingabe ist ungueltig. Bitte versuchen Sie es erneut. Der Wert muss 1, 2 oder 3 sein.\n\n");
            } else if (validCoords == 3){
                printf("\n\nDieses Feld ist bereits belegt. Bitte verwenden Sie andere Werte.\n\n");
            } else {
                printf("\n\nBitte geben Sie die X und Y-Koordinate durch ein Leerzeichen getrennt ein.\n\n");
            }




            scanf("%d %d", &coords[0], &coords[1]);
        } else {
            if(useBrain == 0){
                coords[0] = getRandomNumber(1,3);
                coords[1] = getRandomNumber(1,3);
            } else {
                struct Move botMove = brain(field);

                coords[0] = botMove.col + 1;
                coords[1] = botMove.row +1;
            }
        }





            if(coords[0] > 3 || coords[0] < 0 || coords[1] > 3 || coords[1] < 0){
                validCoords = 2;
            }

            if(field[coords[1]-1][coords[0]-1] != 0){
                validCoords = 3;
            }

        } while(validCoords != 1);



        printf("\nSpieler %d setzt eine Markierung auf %d/%d\n\nDas Spielfeld sieht nun wie folgt aus:\n\n", currentPlayer,coords[0],coords[1]);


        field[coords[1]-1][coords[0]-1] = currentPlayer;

        printField(field);


        playerTurn[currentPlayer-1]++;


        printf("\n--------------------------------------------------------\n");

        if(playerTurn[0]+playerTurn[1] == 9){
            printf("\nDas Spiel ist vorbei. Ergebnis: Unentschieden.");
            winner = 0;
        }

        //Check winning conditions

        //horizontal
        for(int i = 0; i < 3; i++){
            int counter = 0;
            for(int j = 0; j < 3; j++){
                if(field[i][j] == currentPlayer){
                    counter++;
                }

            }

            if(counter == 3){
                winner = currentPlayer;
                printf("\nDas Spiel ist vorbei. Spieler %d hat durch eine horizontale Linie gewonnen!\n", winner);
            } else {
                counter = 0;
            }
        }

        //vertical
        for(int i = 0; i < 3; i++){
            int counter = 0;
            for(int j = 0; j < 3; j++){
                if(field[j][i] == currentPlayer){
                    counter++;
                }

            }

            if(counter == 3){
                winner = currentPlayer;
                printf("\nDas Spiel ist vorbei. Spieler %d hat durch eine vertikale Linie gewonnen!\n", winner);
            } else {
                counter = 0;
            }
        }

        //diagonal
        //top left - bottom right
        int diagonalCounter = 0;
        for(int i = 0; i < 3; i++){
            if(field[i][i]==currentPlayer){
                diagonalCounter++;
            }

        }


        if(diagonalCounter == 3){
            winner = currentPlayer;
            printf("\nDas Spiel ist vorbei. Spieler %d hat durch eine Diagonale Linie von oben links nach unten rechts gewonnen!\n", winner);
        }


        //top right - bottom left
        if(field[2][0] == currentPlayer && field[1][1] == currentPlayer && field[0][2] == currentPlayer){
            winner = currentPlayer;
            printf("\nDas Spiel ist vorbei. Spieler %d hat durch eine Diagonale Linie von oben rechts nach unten links gewonnen!\n", winner);
        }


        if(currentPlayer == 1){
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }
}

void printField(int array[3][3]){
    printf("\n    1   2   3\n");
    printf("\n---------------\n");
    for(int i = 0; i < 3; i++){
        printf("%d |",i+1);
        for(int j = 0; j < 3; j++){
            if(array[i][j] == 1){
                printf(" O ");
            } else if (array[i][j] == 2){
                printf(" X ");
            } else {
                printf("   ");
            }
            if(j < 2){
                printf("|");
            }
        }
        if(i < 2){
            printf("\n  |-----------\n");
        } else {
            printf("\n");
        }

    }
}

void printHeader(int field[3][3], int currentPlayer){
    clrscr();

    printf("Willkommen bei Tic Tac Toe\n\nSpieler 1:\tO\nComputer:\tX\n\n");
    printf("\n--------------------------------------------------------\n\n");
    printField(field);
    printf("\n--------------------------------------------------------\n");
    printf("Spieler %d ist am Zug.", currentPlayer);
}

void clrscr()
{
    system("@cls||clear");
}

int areMovesLeft(int field[3][3], int size){
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            if(field[i][j] == 0){
                return 1; //true
            }
        }
    }
    return 0; //false
}

int evaluate (int field[3][3]){
    //check if win in horizontal for either players
    for(int row = 0; row < 3; row++){
        //if row is full with same values
        if(field[row][0] == field[row][1] && field[row][1] == field[row][2]){
            //if bot(2) wins return 10, if player wins return -10
            if(field[row][0] == 2){
                return +10;
            } else if(field[row][0] == 1){
                return -10;
            }
        }
    }

    //check if win in vertical for either players
    for(int col = 0; col < 3; col++){
        //if row is full with same values
        if(field[0][col] == field[1][col] && field[1][col] == field[2][col]){
            //if bot(2) wins return 10, if player wins return -10
            if(field[0][col] == BOT){
                return +10;
            } else if(field[0][col] == OPPONENT){
                return -10;
            }
        }
    }

    //check if win in diagonal for either player
    //top left - bottom right
    if(field[0][0] == field[1][1] && field[1][1] == field[2][2]){
        //if bot(2) wins return 10, if player wins return -10
        if(field[0][0] == BOT){
            return +10;
        } else if(field[0][0] == OPPONENT){
            return -10;
        }
    }

    //top right - bottom left
    if(field[0][2] == field[1][1] && field[1][1] == field[2][0]){
        //if bot(2) wins return 10, if player wins return -10
        if(field[0][2] == BOT){
            return +10;
        } else if(field[0][2] == OPPONENT){
            return -10;
        }
    }

    //if its anything else its a draw -> return 0
    return 0;
}

int minimax(int field[3][3], int depth, int isMax){
    int score = evaluate(field);

    //if max wins return score
    if(score == 10){
        return score;
    }

    //if min wins return score
    if(score == -10){
        return score;
    }

    //if no moves are left over return 0
    if(areMovesLeft(field,3) == 0){
        return 0;
    }

    //if its maximizer move
    if(isMax == 1){
        int best = -1000;
        //run through all positions
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                //check if position is empty
                if(field[i][j]==0){
                    //set player in empty field
                    field[i][j] = BOT;

                    //recursive brain call choosing maximising
                    int minimaxBest = minimax(field, depth + 1, 0);

                    if(minimaxBest > best){
                        best = minimaxBest;
                    }

                    //undo move to keep field clean
                    field[i][j] = 0;
                }
            }
        }
        return best;
    }
    //if its minimizer move
    else {
        int best = 1000;
        //run through all positions
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                //check if position is empty
                if(field[i][j]==0){
                    //set player in empty field
                    field[i][j] = OPPONENT;

                    //recursive brain call choosing maximising
                    int minimaxBest = minimax(field, depth + 1, 1);

                    if(minimaxBest < best){
                        best = minimaxBest;
                    }

                    //undo move to keep field clean
                    field[i][j] = 0;
                }
            }
        }
        return best;
    }

}

struct Move brain(int field[3][3]){
    int bestRating = -1000;
    struct Move bestMove;
    bestMove.row = -1;
    bestMove.col = -1;

    //go through all empty positions
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            //check if position is empty
            if(field[i][j]==0){
                //set player in empty field
                field[i][j] = BOT;

                //get rating for the move
                int moveRating = minimax(field, 0, 0);

                //undo move
                field[i][j] = 0;

                //if the moveRating is better than the bestRating set bestMove and update bestRating
                if(moveRating > bestRating){
                    bestMove.row = i;
                    bestMove.col = j;
                    bestRating = moveRating;
                }
            }
        }
    }

    return bestMove;
}

int main()
{
    printf("Aufgabe 1:\na) - Iterativ:\n\n");
    task1a();
    printf("\n\nAufgabe 1:\nb) - Rekursiv:\n\n");
    task1b();
    printf("\n\nAufgabe 2:\n");
    task2();
    printf("\n\nAufgabe 3:\n");
    task3();

    return 0;
}
