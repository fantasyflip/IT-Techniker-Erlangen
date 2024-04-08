#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//task 2 defines
#define ARRAY_SIZE 10

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
        while (i<=j){

            //search for a bigger value to the right
            while(arr[i] < compareValue) i++;
            //search for a smaller value to the left
            while(arr[j] > compareValue) j--;

            //swap item
            if(i <= j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;

            }
        }

        //recursive calls
        //repeat with items between j and the firstIndex (left subarray)
        if(firstIndex < j) mySort(arr, firstIndex, j);
        //repeat with items between i and size (right subarray)
        if(i < size) mySort(arr, i, size);
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

int main()
{
    printf("Aufgabe 1:\na) - Iterativ:\n\n");
    task1a();
    printf("\n\nAufgabe 1:\nb) - Rekursiv:\n\n");
    task1b();
    printf("\n\nAufgabe 2:\n");
    task2();

    return 0;
}
