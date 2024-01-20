#include <stdio.h>

/*
 * Deklaration: Variable wird mit Namen und Typ dem Compiler bekannt gemacht
 * Initialisierung: ERstmalige Zuweisung eines Wertes
 */

int main()
{
    double height = 1.3, width = 2.1, area;

    // Flaechenformel fuer Rechteck

    area = height * width;

    // %.2lf -> long float platzhalter mit 2 Nachkommastellen

    printf("Die Flaeche des Rechtecks mit der Hoehe %.2lf und der Breite %.2lf\n", height, width);
    printf("betraegt %.2lf\n", area);

    return area;
}
