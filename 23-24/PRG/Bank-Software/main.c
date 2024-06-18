#include <stdio.h>

// Datenmodellierung für eine Banksoftware

struct Datum{
    int tag;
    int monat;
    int jahr;
};

struct Adresse
{
    char strasse[30];
    char hausnummer[10];
    char postleitzahl[5];
    char wohnort[20];
};

struct Person{
    char name[30];
    char vorname[30];
    struct Adresse adresse;
    struct Datum geburtstag;
};

struct Konto {
    struct Person inhaber;
    char iban[23]; // 22 + 1 für \0
    struct Datum eroeffnung;
    double kontostand;
    double gebuehr;
    double zins;
};

int main()
{
    printf("Hello World!\n");
    return 0;
}
