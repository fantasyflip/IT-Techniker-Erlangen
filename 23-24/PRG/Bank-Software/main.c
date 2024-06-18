#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define KONTO_COUNT 5
#define IBAN_LENGTH 22

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


// Aufgabe:
// Legen Sie ein Array mit 5 Konten an. Initialisieren Siedie Konten
// indem Sie eine Funktion KontoAnlegen() implementieren, mit der die 5 Konten angelegt werden.
// Implementieren Sie eine Funktion, die die Kontodaten aller Konten am Bildschirm ausgibt

struct Konto KontoAnlegen();
struct Person PersonAnlegen();
struct Datum DatumAufnehmen();
struct Adresse AdresseAufnehmen();

void RandomIban(char* iban);
char RandomLetter();
char RandomDigit();

int main()
{
    struct Konto konten[KONTO_COUNT];

    for(int i = 0; i < KONTO_COUNT; i++){
        konten[i] = KontoAnlegen();
        printf("\n\n-----------------------------\n\n");
    }


    return 0;
}

struct Konto KontoAnlegen(){
    struct Konto konto;

    printf("\nKonto anlegen");

    RandomIban(&konto.iban);
    konto.inhaber = PersonAnlegen();
    konto.eroeffnung = DatumAufnehmen();
    konto.kontostand = 0.0;
    konto.gebuehr = 7.8;
    konto.zins = 0.0375;


    return konto;
}

struct Person PersonAnlegen(){
    struct Person person;

    printf("\n\nPerson anlegen");

    person.adresse = AdresseAufnehmen();
    person.geburtstag = DatumAufnehmen();

    printf("\n\nVorname der Person: ");
    scanf("%s", &person.vorname);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    printf("Nachname der Person: ");
    scanf("%s", &person.vorname);

    // Clear the input buffer
    while ((c = getchar()) != '\n' && c != EOF);

    return person;
}

struct Adresse AdresseAufnehmen(){
    struct Adresse adresse;

    printf("\n\nAdresse angeben");

    printf("\n\nStrasse: ");
    scanf("%s", &adresse.strasse);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    printf("Hausnummer: ");
    scanf("%s", &adresse.hausnummer);

    // Clear the input buffer
    while ((c = getchar()) != '\n' && c != EOF);

    printf("Postleitzahl: ");
    scanf("%s", &adresse.postleitzahl);

    // Clear the input buffer
    while ((c = getchar()) != '\n' && c != EOF);

    printf("Wohnort: ");
    scanf("%s", &adresse.wohnort);

    // Clear the input buffer
    while ((c = getchar()) != '\n' && c != EOF);

    return adresse;
}

struct Datum DatumAufnehmen(){
    struct Datum datum;

    printf("\n\nDatum angeben");

    printf("\n\nJahr: ");
    scanf("%d", &datum.jahr);

    // Clear the input buffer
    int c;
    while ((c = getchar()) != '\n' && c != EOF);

    printf("Monat: ");
    scanf("%d", &datum.monat);

    // Clear the input buffer
    while ((c = getchar()) != '\n' && c != EOF);

    printf("Tag: ");
    scanf("%d", &datum.tag);

    // Clear the input buffer
    while ((c = getchar()) != '\n' && c != EOF);

    return datum;
}

// Function to generate a random digit
char RandomDigit() {
    return '0' + rand() % 10;
}

// Function to generate a random letter
char RandomLetter() {
    return 'A' + rand() % 26;
}

// Function to generate a random IBAN
void RandomIban(char* iban) {
    // Example format: CCkk BBBB CCCC CCCC CCCC CCCC
    // CC - Country code (2 letters)
    // kk - Check digits (2 numbers)
    // BBBBCCCCCCCCCCCCCCCC - Basic Bank Account Number (BBAN) (18 characters for simplicity)

    // Country code
    iban[0] = RandomLetter();
    iban[1] = RandomLetter();

    // Check digits
    iban[2] = RandomDigit();
    iban[3] = RandomDigit();

    // BBAN
    for (int i = 4; i < IBAN_LENGTH; i++) {
        iban[i] = RandomDigit();
    }

    // Null-terminate the string
    iban[IBAN_LENGTH] = '\0';
}
