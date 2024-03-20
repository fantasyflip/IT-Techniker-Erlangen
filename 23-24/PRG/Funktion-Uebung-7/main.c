#include <stdio.h>
#include <string.h>

#define SINGLE 3.0
#define STRIPE 10.0
#define MONTH 29.0
#define CHILD_REDUCTION 0.85

int stringIndex(char text[], char symbol);
int enthaeltString(char wrappingText[], char innerText[]);
int isEqual(char text1[], char text2[]);
void fahrkarte();
int fetchTicketType();
int fetchTicketSize();
void printPrices();
float getMoneyInput(float ticketPrize);
void splitReturnMoney(float moneyReturn);
float getTicketPrizeBySize(int ticketSize);

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


int main()
{
    fahrkarte();
    return 0;
}
