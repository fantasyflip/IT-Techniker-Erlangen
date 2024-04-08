#include <stdio.h>

float getFloatInput();
int getIntInput();
float multiRecursive(float a, float b, int n, int current);

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

int main()
{
    printf("Aufgabe 1:\na) - Iterativ:\n\n");
    task1a();
    printf("\n\nAufgabe 1:\nb) - Rekursiv:\n\n");
    task1b();

    return 0;
}
