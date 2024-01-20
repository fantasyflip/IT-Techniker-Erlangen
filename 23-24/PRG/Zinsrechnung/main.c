#include <stdio.h>
#include <math.h>

int main()
{
    double capital = 100000.0;
    double interest = 2.5;
    int years = 10;

    printf("Startkapital: %.2lf Euro\n",capital);
    printf("Effektiver Jahreszins: %.2lf %%\n\n", interest);

    interest = interest / 100.0;

    printf("--------------------------\n");
    printf("|    Jahr |    Kapital   |\n");
    printf("--------------------------\n");

    for(int i = 0; i < years + 1; i++){
        printf("|   %4d  |  %11.2lf |\n",i, capital);

        capital = capital + capital * interest;
    }

    printf("--------------------------\n");

    printf("\n\n\n");
    return 0;
}
