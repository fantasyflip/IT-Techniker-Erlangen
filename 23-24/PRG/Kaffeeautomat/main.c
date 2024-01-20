#include <stdio.h>

int main()
{
    unsigned int milk = 0, sugar = 0;
    double price, input = 2.36, output;

    if(!milk && !sugar){
        price = 1.0;
    } else if(milk && sugar){
        price = 2.0;
    } else if(!milk && sugar){
        price = 1.50;
    } else if(milk && !sugar){
        price = 1.50;
    } else {
        printf("Ausnahmefehler! Informieren Sie den Kundendienst!\n");
    }

    output = input - price;

    if(output < 0.0){
        printf("Eingeworfen: %.2lf Euro\n", input);
        printf("Preis: %.2lf Euro\n", price);
        printf("Noch zu zahlen: %.2lf Euro\n", output * -1.0);
    } else {
        if(!milk && !sugar){
            printf("Kaffee so schwarz wie mein Humor\n");
        } else if(milk && sugar){
            printf("Kaffee mit Milch und Zucker\n");
        } else if(!milk && sugar){
            printf("Kaffee mit Zucker ohne Milch\n");
        } else if(milk && !sugar){
            printf("Kaffee mit Milch ohne Zucker\n");
        } else {
            printf("Ausnahmefehler! Informieren Sie den Kundendienst!\n");
        }

        printf(" Vielen Dank! Ihr Rueckgeld beträgt %.2lf Euro\n", output);
    }



    printf("\n\n");
    return 0;
}
