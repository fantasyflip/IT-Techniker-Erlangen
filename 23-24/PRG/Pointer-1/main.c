#include <stdio.h>

int main()
{
    unsigned int zahl = 70;
    unsigned int* adr_zahl;
    // neuer Datentyp: Zeiger auf eine Variable vom Typ unsigned int
    // kurz: Zeiger auf unsigned int
    // einfach gesagt: Typ einer Variablen, die die Anfangsadresse einer
    //                 anderen Variable vom Typ unsigned int aufnehmen kann

    unsigned int werte[]={2,1,6,8,22};
    unsigned char* adr_byte;

    adr_zahl = &zahl;  // &: Adresse von ...

    adr_byte = (unsigned char*)adr_zahl;

    printf("Anfangsadresse von zahl: %x\n",adr_zahl);

    printf("Inhalt von zahl: %u\n",zahl);
    printf("Inhalt von zahl: %u\n",*adr_zahl); // *: Inhalt von der Adresse ...

    zahl++;

    printf("Inhalt von zahl: %u\n",*adr_zahl);

    (*adr_zahl)++;

    printf("Inhalt von zahl: %u\n",*adr_zahl);

    printf("Anfangsadresse des Arrays werte: %x\n",&werte[0]);
    printf("Adresse des 2. Elements von werte: %x\n",&werte[1]);
    printf("Adresse des 3. Elements von werte: %x\n",&werte[2]);
    printf("Adresse des 4. Elements von werte: %x\n",&werte[3]);
    printf("Adresse des 5. Elements von werte: %x\n",&werte[4]);

    printf("Wert von werte: %x\n",werte); // Ist die Anfangsadresse des Arrays werte

    printf("Inhalt des 1. Elements ueber Zeiger: %u\n",*werte);
    printf("Inhalt des 2. Elements ueber Zeiger: %u\n",*(werte+1));
    printf("Inhalt des 3. Elements ueber Zeiger: %u\n",*(werte+2));
    printf("Inhalt des 4. Elements ueber Zeiger: %u\n",*(werte+3));
    printf("Inhalt des 5. Elements ueber Zeiger: %u\n",*(werte+4));

    zahl = 70;

    printf("Eins ueber Arraygrenze: %u bei Adresse %x\n",*(werte+5), werte+5);

    printf("Inhalt des 1. Bytes von zahl: %u\n",*adr_byte);
    printf("Inhalt des 2. Bytes von zahl: %u\n",*(adr_byte+1));
    printf("Inhalt des 3. Bytes von zahl: %u\n",*(adr_byte+2));
    printf("Inhalt des 4. Bytes von zahl: %u\n",*(adr_byte+3));


    return 0;
}
