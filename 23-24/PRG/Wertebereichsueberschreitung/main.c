#include <stdio.h>

int main()
{
    // 7 mal f
    int zahl = 0x7fffffff;
    unsigned int zahl2 = 0x7fffffff;

    //Grösste Zahl in einem int
    printf ("zahl = %d\n",zahl);
    printf ("zahl2 = %u\n",zahl2);

    //Um 1 erhoehen
    printf ("zahl + 1 = %d\n",zahl + 1);
    printf ("zahl2 + 1 = %u\n",zahl2 + 1);


    //Ausgabe der Grösse verschiedener Datentypen
    //sizeof(variable): Liefert Speichergrösse einer Variable
    printf ("Groesse von int: %d Byte\n", sizeof(int));
    printf ("Groesse von short int: %d Byte\n", sizeof(short int));
    printf ("Groesse von long int: %d Byte\n", sizeof(long int));
    printf ("Groesse von zahl: %d Byte\n", sizeof(zahl));
    printf ("Groesse von zahl2: %d Byte\n", sizeof(zahl2));


    return 0;
}
