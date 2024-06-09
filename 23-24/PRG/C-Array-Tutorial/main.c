#include <stdio.h>
#include <stdlib.h>

float ohneArray();
float mitArray();
float dynArray();

int main()
{
    // Aufgabe:
    // Es soll ein Programm entwickelt werden, das Messwerte einliest
    // und anschließend einen Mittelwert aus den Werten bestimmt

    dynArray();


    return 0;
}

float ohneArray(){
    // 1. Es sollen 5 Messwerte aufgenommen werden
    // Möglichkeit ohne Array

    int wert1, wert2, wert3, wert4, wert5;

    // Einlesen der Messwerte vom Benutzer
    printf("Bitte geben Sie den ersten Messwert ein: ");
    scanf("%d", &wert1);

    printf("Bitte geben Sie den zweiten Messwert ein: ");
    scanf("%d", &wert2);

    printf("Bitte geben Sie den dritten Messwert ein: ");
    scanf("%d", &wert3);

    printf("Bitte geben Sie den vierten Messwert ein: ");
    scanf("%d", &wert4);

    printf("Bitte geben Sie den fünften Messwert ein: ");
    scanf("%d", &wert5);

    // Berechnung des Mittelwerts
    float mittelwert = (wert1 + wert2 + wert3 + wert4 + wert5) / 5.0;

    // Ausgabe des Mittelwerts
    printf("Der Mittelwert der Messwerte ist: %.2f\n", mittelwert);

    return mittelwert;

    // Nachteile:
    // - Keine einfach iterative Eingabe möglich
    // - Es werden viele Variablen benötigt
    // - Bei vielen Messwerten schnell unübersichtlich und anfällig für Tippfehler
}

float mitArray(){
    // 2. Es sollen 5 Messwerte aufgenommen werden
    // Möglichkeit mit Array

    // Array der Länge 5 anlegen

    int werte[5];

    // oder

    // int werte[5] = {0, 0, 0, 0, 0};

    // oder

    // int laenge = 5;
    // int werte[laenge];

    // Werte aufnehmen
    for(int i = 0; i < 5; i++){
        printf("Bitte geben Sie den %d. Messwert ein: ", i+1);
        scanf("%d", &werte[i]);
    }

    // Werte summieren
    int summe = 0;
    for(int i = 0; i < 5; i++){
        summe = summe + werte[i];
    }

    // Mittelwert berechnen
    float mittelwert = summe / 5.0;

    // Ausgabe des Mittelwerts
    printf("Der Mittelwert der Messwerte ist: %.2f\n", mittelwert);

    return mittelwert;

    // Vorteile:
    // - Übersichtlicher. Auch bei vielen Messwerten
    // - Iterative Bearbeitung möglich
}

float dynArray(){
    // 3. Es soll zu Beginn der Laufzeit entschieden werden wie viele Messwerte aufgenommen werden

    int anzahl = 0;

    // Anzahl der Messwerte erfassen
    printf("Geben Sie die Anzahl der Messwerte an: ");
    scanf("%d",&anzahl);

    // Entsprechend großen Speicherbereich reservieren und Anfangsadresse abspeichern
    int* werte = (int*)calloc(sizeof(int), anzahl);

    // Überprüfen ob das reservieren funktioniert hat
    if(werte == NULL){
        // Wenn keine Adresse in der Variable gespeichert ist, hat das reservieren nicht funktioniert und das Programm muss beendet werden
        printf("Fehler beim Anlegen des Arrays. Das Programm wird beendet... \n");
        exit(42);
    }

    // Werte erfassen
    for(int i = 0; i < anzahl; i++){
        printf("Bitte geben Sie den %d. Messwert ein: ", i+1);
        scanf("%d", &werte[i]);
    }

    // Werte summieren
    int summe = 0;
    for(int i = 0; i < anzahl; i++){
        summe = summe + werte[i];
    }

    // Mittelwert berechnen
    float mittelwert = summe / (float)anzahl;

    // Ausgabe des Mittelwerts
    printf("Der Mittelwert der Messwerte ist: %.2f\n", mittelwert);

    return mittelwert;

    // Vorteile:
    // - Dynamische Speicherreservierung während der Laufzeit
    // - Sehr flexibler Code
}
