#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <math.h>

//defines for task #4
#define SINGLE 3.0
#define STRIPE 10.0
#define MONTH 29.0
#define CHILD_REDUCTION 0.85

//defines for task #5
#define MAX_INPUT_LENGTH 100

//struct for task #5
struct TypedCurrency {
    char type[4];
    double value;
};

//defintion for task #1
int stringIndex(char text[], char symbol);

//defintion for task #2
int enthaeltString(char wrappingText[], char innerText[]);

//defintion for task #3
int isEqual(char text1[], char text2[]);

//defintion for task #4
void fahrkarte();
int fetchTicketType();
int fetchTicketSize();
void printPrices();
float getMoneyInput(float ticketPrize);
void splitReturnMoney(float moneyReturn);
float getTicketPrizeBySize(int ticketSize);

//defintion for task #5
void currencyCalculator();
void printIntroduction();
struct TypedCurrency getInput();
int isValidCurrency(char cur[4]);
char* getTargetCurrency();
double getTargetValue(char fromCur[4], char toCur[4],double fromVal);
float getRateFromCurrency(char cur[4]);
double roundToDecimalPlaces(double num, int decimalPlaces);

//task #1
int stringIndex(char text[], char symbol){
    int length = strlen(text);
    int position = -1;

    for(int i = 0; i < length; i++){
        if(text[i] == symbol){
            position = i;
            i = length;
        }
    }

    return position;
}

//task #2
int enthaeltString(char wrappingText[], char innerText[]){
    int isContaining = 0;
    int wrappingTextLength = strlen(wrappingText);
    int innerTextLength = strlen(innerText);

    if(wrappingTextLength < innerTextLength) return 0;

    for(int i = 0; i < wrappingTextLength; i++){
        int matchingChars = 0;
        for(int j = 0; j < innerTextLength; j++){
            if(wrappingText[i+j] == innerText[j]){
                matchingChars++;
                if(matchingChars == innerTextLength){
                    isContaining = 1;
                    i = wrappingTextLength;
                    j = innerTextLength;
                }
            } else {
                j = innerTextLength;
            }
        }
    }

    return isContaining;
}

//task #3
int isEqual(char text1[], char text2[]){
    int length1 = strlen(text1);
    int length2 = strlen(text2);
    int isEqual = 1;

    if(length1 != length2) return 0;

    for(int i = 0; i < length1; i++){
        if(text1[i] != text2[i]){
            i = length1;
            isEqual = 0;
        }
    }

    return isEqual;
}

//task #4
void fahrkarte(){
    int isChild = fetchTicketType();
    printPrices();
    float ticketPrice = getTicketPrizeBySize(fetchTicketSize());
    if(isChild){
        ticketPrice = ticketPrice * CHILD_REDUCTION;
    }
    float moneyInput = getMoneyInput(ticketPrice);
    splitReturnMoney(moneyInput-ticketPrice);
}

int fetchTicketType(){
    int castCount = -1;
    char childTicket;

    printf("\n\nTicket fuer Kind oder Erwachsenen? (k/e): ");
    castCount = scanf("%c", &childTicket);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    if((childTicket != 'k' && childTicket != 'K' && childTicket != 'e' && childTicket != 'E') || castCount != 1){
        printf("\nUngueltige Eingabe. Bitte erneut versuchen.");

        return fetchTicketType();
    }

    if(childTicket == 'k' || childTicket == 'K'){
        return 1;
    } else {
        return 0;
    }
}

int fetchTicketSize(){
    int castCount = -1;
    char ticketSize;

    printf("\n\nEinzelfahrschein, Streifenkarte, oder Monatskarte? (e/s/m): ");
    castCount = scanf("%c", &ticketSize);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    if((ticketSize != 's' && ticketSize != 'S' && ticketSize != 'e' && ticketSize != 'E' && ticketSize != 'm' && ticketSize != 'M') || castCount != 1){
        printf("\nUngueltige Eingabe. Bitte erneut versuchen.");

        return fetchTicketSize();
    }

    if(ticketSize == 'e' || ticketSize == 'E'){
        return 0;
    } else if(ticketSize == 's' || ticketSize == 'S') {
        return 1;
    } else {
        return 2;
    }
}

void printPrices(){
    printf("\nEinzel\t\t%.2f Euro", SINGLE);
    printf("\nStreifen\t%.2f Euro", STRIPE);
    printf("\nMonat\t\t%.2f Euro", MONTH);
}

float getMoneyInput(float price){
    float input=-1.0;
    int castCount = -1;



    printf("\nKosten: %.2f Euro\n\nBitte Geld einwerfen: ", price);
    castCount = scanf("%f", &input);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    if(input < price || castCount != 1){
        printf("\nUngueltige Eingabe. Bitte erneut versuchen.");

        return getMoneyInput(price);
    }

    return input;
}

float getTicketPrizeBySize(int size){
    if(size == 0){
        return SINGLE;
    } else if (size == 1){
        return STRIPE;
    } else {
        return MONTH;
    }
}

void splitReturnMoney(float moneyReturn){
    int centReturn = (int)(moneyReturn * 100);

    int euro2 = 0;
    int euro1 = 0;
    int cent50 = 0;
    int cent20 = 0;
    int cent10 = 0;
    int cent5 = 0;
    int cent2 = 0;
    int cent1 = 0;

    printf("\n\nRueckgeld: %.2f\n\n", moneyReturn);



    while(centReturn >= 200){
        euro2++;
        centReturn = centReturn -200;
    }

    while(centReturn >= 100){
        euro1++;
        centReturn = centReturn -100;
    }

    while(centReturn >= 50){
        cent50++;
        centReturn = centReturn -50;
    }

    while(centReturn >= 20){
        cent20++;
        centReturn = centReturn -20;
    }

    while(centReturn >= 10){
        cent10++;
        centReturn = centReturn -10;
    }

    while(centReturn >= 5){
        cent5++;
        centReturn = centReturn -5;
    }

    while(centReturn >= 2){
        cent2++;
        centReturn = centReturn -2;
    }

    while(centReturn >= 1){
        cent1++;
        centReturn = centReturn -1;
    }

    printf("Muenzenausgabe:\n\n");

    printf("2  Euro:\t%d\n", euro2);
    printf("1  Euro:\t%d\n", euro1);
    printf("50 Cent:\t%d\n", cent50);
    printf("20 Cent:\t%d\n", cent20);
    printf("10 Cent:\t%d\n", cent10);
    printf("5  Cent:\t%d\n", cent5);
    printf("2  Cent:\t%d\n", cent2);
    printf("1  Cent:\t%d\n", cent1);
}

//task #5
void currencyCalculator(){
    printIntroduction();
    struct TypedCurrency initialCurrency = getInput();

    char *targetCurrency = getTargetCurrency();

    if(isEqual(initialCurrency.type,targetCurrency)){
        printf("\nSie haben die identische Waehrung gewaehlt. Eine Umrechnung ist nicht erforderlich.\n\n%.2f %s sind %.2f %s.\n\n",initialCurrency.value, initialCurrency.type, initialCurrency.value, targetCurrency);
        return;
    }

    double targetValue = getTargetValue(initialCurrency.type, targetCurrency, initialCurrency.value);

    if(targetValue == -1.0) return;

    printf("\n\n%.2f %s sind %.2f %s.\n\n\n", initialCurrency.value, initialCurrency.type, targetValue, targetCurrency);

    //Free previously allocated memory in getTargetCurrency()
    free(targetCurrency);
}

void printIntroduction(){
    printf("Waehrungsrechner\n\n\nGeben Sie den umzurechnenden Betrag im folgenden Format ein:\n\n\n\t20.34 Waehrung\n\n\nFuer die Waehrung sind folgende Abluerzungen zulaessig:\n\n\n\tUSD\tUS-Dollar\n\tGBP\tBritische Pfund\n\tEUR\tEuro\n\n\n");
}

struct TypedCurrency getInput(){
    struct TypedCurrency inputCurrency;
    char inputString[MAX_INPUT_LENGTH];
    char numberString[MAX_INPUT_LENGTH];
    char currencyString[4]; // 4th for null terminator


    printf("Eingabe: ");
    fgets(inputString, sizeof(inputString), stdin);

    int arrayToPrintIn = 0;
    int numberIndex = 0;
    int currencyIndex = 0;

    for (int i = 0; i < strlen(inputString); i++) {
        // Handle space or newline character
        if (inputString[i] == ' ' || inputString[i] == '\n') {
            arrayToPrintIn++;
            // If we have both parts, exit the loop
            if (arrayToPrintIn == 2) {
                break;
            }
            continue; // Skip processing space or newline character
        }

        if (arrayToPrintIn == 0) {
            //check if char is a number
            if(isdigit(inputString[i]) || inputString[i] == '.'){
                numberString[numberIndex++] = inputString[i];
            } else {
                printf("\nFalsche Eingabe. Bitte versuchen Sie es erneut!\n");
                return getInput();
            }
        }
        else if (arrayToPrintIn == 1) {
            if(currencyIndex < 3){
                currencyString[currencyIndex++] = inputString[i];
            } else {
                break;
            }

        }
    }

    // Null-terminate the strings
    numberString[numberIndex] = '\0';
    currencyString[currencyIndex] = '\0';

    if(isValidCurrency(currencyString) == 0){
        printf("\nFalsche Eingabe. Bitte versuchen Sie es erneut!\n");
        return getInput();
    }

    printf("\n\nIhre Eingabe:\n\nWert:\t\t%s\nWaehrung:\t%s",numberString,currencyString);

    //parse numberString to float value

    inputCurrency.value = atof(numberString);
    strcpy(inputCurrency.type,currencyString);

    return inputCurrency;
}

int isValidCurrency(char cur[4]){
    char *availableCurrencies[] = {"EUR","USD","GBP"};
    int currencyAmount = sizeof(availableCurrencies) / sizeof(availableCurrencies[0]);

    int isValid = 0;

    for(int i = 0; i < currencyAmount; i++){
        if(isEqual(cur,availableCurrencies[i])){
            i = currencyAmount;
            isValid = 1;
        }
    }

    return isValid;
}

char* getTargetCurrency(){
    // Allocate memory. If the memory is not allocated, the memory will be rewritten after the function is finished, since it is a local variable
    char *currencyString = (char*)malloc(MAX_INPUT_LENGTH * sizeof(char));

    printf("\n\nEingabe der Zielwaehrung: ");
    fgets(currencyString, 4, stdin);

    // Remove newline character if present
    int len = strlen(currencyString);
    if (len > 0 && currencyString[len - 1] == '\n') {
        currencyString[len - 1] = '\0';
    }

    if(!isValidCurrency(currencyString)){
        printf("\nFalsche Eingabe. Bitte versuchen Sie es erneut!\n");
        free(currencyString); // Free the memory before the recursive call

        // Clear the input buffer
        int c;
        while ((c = getchar()) != '\n' && c != EOF);

        return getTargetCurrency();
    }

    return currencyString;
}

double getTargetValue(char fromCur[4], char toCur[4],double fromVal){

    float sourceRate = getRateFromCurrency(fromCur);
    float destRate = getRateFromCurrency(toCur);

    if(sourceRate == -1.0 || destRate == -1.0){
        printf("\n\nEs ist ein Anwendungsfehler aufgetreten.");
        return -1.0;
    }

    return roundToDecimalPlaces((destRate/sourceRate)*fromVal,2);

}

float getRateFromCurrency(char cur[4]){
    //Rates relative to EUR
    float eurRate = 1.0;
    float gbpRate = 0.6254;
    float usdRate = 0.9036;

    if(isEqual(cur,"EUR")) return eurRate;
    if(isEqual(cur,"GBP")) return gbpRate;
    if(isEqual(cur,"USD")) return usdRate;

    return -1.0;
}

double roundToDecimalPlaces(double num, int decimalPlaces) {
    double factor = pow(10, decimalPlaces);
    return round(num * factor) / factor;
}


int main()
{
    printf("1. Aufgabe\n\nIndex des Zeichens 'e' im String 'das ist ein text': %d\n\n",stringIndex("das ist ein text", 'e'));
    printf("\n\n2. Aufgabe\n\nDer Text 'das ist ein text' enthaelt das Wort 'ist': %d\n\n",enthaeltString("das ist ein text", "ist"));
    printf("\n\n3. Aufgabe\n\nDer Text 'ABC' und 'DEF' sind nicht identisch: %d\n\n", isEqual("ABC","DEF"));
    printf("\n\n4. Aufgabe\n\n");
    fahrkarte();
    printf("\n\n");
    printf("\n\n5.Aufgabe\n\n");
    currencyCalculator();
    return 0;
}
