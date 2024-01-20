#include <stdio.h>
#include <unistd.h>

void task1(){

    printf("Aufgabe 1: Satz umkehren\n\n");

    //Variablen definieren
    char sentence[]="Heute ist ein sonniger Tag! Die Luft ist frisch und warm.";
    int sentenceLength = sizeof(sentence)/sizeof(char);

    //Satz ausgeben
    for(int i = 0; i < sentenceLength-1; i++){
        printf("%c",sentence[i]);
    }

    printf("\n");

    //Variablen zum umdrehen definieren
    //Länge - 2 damit an erster Stelle nicht das Array Ende als Wert steht - \0
    int start = 0, end = sentenceLength - 2;

    //Bis zur Mitte des Satzes wiederholen
    while (start < end){

        //Temporär speichern des Zeichens, das ans Ende soll
        char tempChar = sentence[start];
        //Zeichen vom Ende an den Anfang setzen
        sentence[start] = sentence[end];
        //Temporär gespeichertes Zeichen ans Ende setzen
        sentence[end] = tempChar;

        //Zähler in die entsprechende Richtung ändern
        start++;
        end--;
    }

    //Satz ausgeben
    for(int i = 0; i < sentenceLength-1; i++){
        printf("%c",sentence[i]);
    }

    printf("\n\n");
}

void task2(){

    printf("Aufgabe 2: Array Laenge vergleichen\n\n");

    //Variablen definieren
    char array1[] = "Das ist ein kurzer Array.", array2[] = "Das ist der Array, der laenger ist.";
    int length1 = sizeof(array1)/sizeof(typeof(array1[0])), length2 = sizeof(array2)/sizeof(typeof(array2[0]));

    //Längen vergleichen und entsprechenden Array ausgeben
    if(length1 > length2){
        for(int i = 0; i < length1; i++){
            printf("%c",array1[i]);
        }
    } else {
        for(int i = 0; i < length2; i++){
            printf("%c",array2[i]);
        }
    }

    printf("\n\n");
}

void task3(){

    printf("Aufgabe 3: Array-Swap\n\n");

    //Variablen definieren
    char array1[] = "Programmieren ist schoen!", array2[] = "Der Computer funktioniert nicht!";
    int length1 = sizeof(array1)/sizeof(typeof(array1[0])), length2 = sizeof(array2)/sizeof(typeof(array2[0]));
    int limit = length1 > length2 ? length2 : length1;

    //Arrays ausgeben
    for(int i = 0; i < length1; i++){
        printf("%c",array1[i]);
    }
    printf("\n");
    for(int i = 0; i < length2; i++){
        printf("%c",array2[i]);
    }
    printf("\n\n");


    //Inhalt der Arrays tauschen. Der kleinere Array bestimmt das Limit. Alles was hinter dem Limit im längeren Array steht bleibt erhalten.
    for(int i = 0; i < limit; i++){
        char tempChar;
        tempChar = array1[i];
        array1[i] = array2[i];
        array2[i] = tempChar;
    }

    //Arrays ausgeben
    for(int i = 0; i < length1; i++){
        printf("%c",array1[i]);
    }
    printf("\n");
    for(int i = 0; i < length2; i++){
        printf("%c",array2[i]);
    }
    printf("\n\n");
}

void task4(){


    printf("Aufgabe 4: Arrays addieren\n\n");

    //Variablen definieren
    int array1[] = {0,1,2,3,4,5,6,7,8,9,10}, array2[] = {10,11,12,13,14,15,16,17,18,19,20,21,22}, array3[13];
    char header[][14]={"Position", "Wert - Array 1", "Wert - Array 2", "Wert - Array 3"};
    int length1 = sizeof(array1)/sizeof(typeof(array1[0])), length2 = sizeof(array2)/sizeof(typeof(array2[0])), length3 = sizeof(array3)/sizeof(typeof(array3[0]));

    //Schleife für die Zeilen
    for(int i = 0; i < sizeof(header)/sizeof(header[0]); i++){

        //Header ausgeben für die entsprechende Zeile
        for(int j = 0; j < sizeof(header[i])/sizeof(header[i][0]); j++){
            printf("%c", header[i][j]);
        }
        printf("\t:\t");

        //Zeile 1 - Positionen vorgeben und ausgeben
        if(i == 0){
            for(int j = 0; j < length3; j++){
                printf("%d\t", j);
            }

        }

        //Zeile 2 - Array 1 ausgeben
        if(i == 1){
            for(int j = 0; j < length1; j++){
                printf("%d\t", array1[j]);
            }
        }

        //Zeile 3 - Arrayy 2 ausgeben
        if(i == 2){
            for(int j = 0; j < length2; j++){
                printf("%d\t", array2[j]);
            }
        }

        //Arrays addieren
        for(int j = 0; j < length3; j++){
            //Bereichsüberschreitung abfangen, da array1 kürzer als array2 ist.
            if(j > length1 - 1){
                array3[j] = 0 + array2[j];
            } else {
                array3[j] = array1[j] + array2[j];
            }
        }

        //Zeile 4 - Array 3 ausgeben
        if(i == 3){
            for(int j = 0; j < length3; j++){
                printf("%d\t", array3[j]);
            }
        }

        printf("\n\n");
    }
}

void task5(){

    printf("Aufgabe 5: Paarweise tauschen\n\n");

    //Variablen definieren
    char sentence[] = "Die Technikerschule Erlangen ist schoen!";
    int length = sizeof(sentence)/sizeof(typeof(sentence[0]));

    //Satz ausgeben
    for(int i = 0; i < length; i++){
        printf("%c", sentence[i]);
    }

    printf("\n");

    //Alle zwei Zeichen das Zeichen mit dem Nachfolger tauschen
    for(int i = 0; i < length; i += 2){
        char tempChar = sentence[i];
        sentence[i] = sentence[i+1];
        sentence[i+1] = tempChar;
    }

    //Satz ausgeben
    for(int i = 0; i < length; i++){
        printf("%c", sentence[i]);
    }

    printf("\n\n");
}

void task6(int runs){

    printf("Aufgabe 6: Laufschrift\n\n");

    //Variablen definieren
    char sentence[] = "Das ist eine Laufschrift :D --- ";
    int length = sizeof(sentence)/sizeof(typeof(sentence[0]));

    //Anzahl der Durchläufe der Laufschrift festlegen
    for(int n = 0; n < length * runs - runs; n++){
        //Alle Zeichen um einen Platz verschieben
        for(int i = 0; i < length; i++){
            char tempChar = sentence[i];
            //Sonderfall für das erste Zeichen abfangen, da dieses ans Ende muss.
            if(i == 0){
                sentence[i] = sentence[i + 1];
                sentence[length-1] = tempChar;
            } else {
                sentence[i] = sentence[i + 1];
                sentence[i-1] = tempChar;
            }
        }

        //Zeichenfolge ausgeben
        for(int i = 0; i < length; i++){
            printf("%c", sentence[i]);
        }

        //8ms warten
        usleep(80000);
        //Zurück an den Zeilenanfang springen
        printf("\r");
    }


    printf("\n\n");
}

void task7(){

    printf("Aufgabe 7: Caesar-Verschluesselung\n\n");

    //Variablen definieren
    char clearText[] = "caesar", secretText[sizeof(clearText)], charset[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}, secretCharset[sizeof(charset)];
    int rotationSteps = 3, charsetLength = sizeof(charset)/sizeof(typeof(charset[0])), clearTextLength = sizeof(clearText)/sizeof(typeof(clearText[0]));

    //secrectCharset gleich füllen wie charset.
    for(int i = 0; i < charsetLength; i++){
        secretCharset[i] = charset[i];
    }


    //wenn der charset verschoben werden muss.
    if (rotationSteps > 0 && rotationSteps < charsetLength) {
        //secretCharset um rotationSteps verschieben
        for (int i = 0; i < rotationSteps; ++i) {
            char tempChar = secretCharset[0];
            for (int j = 0; j < charsetLength - 1; j++) {
                secretCharset[j] = secretCharset[j + 1];
            }
            secretCharset[charsetLength - 1] = tempChar;
        }
    }

    //Den Cleartext char für char durchgehen
    for(int i = 0; i < clearTextLength; i++){
        int index = -1;

        //index des clearText chars aus dem charset finden
        for(int j = 0; j < charsetLength; j++){
            if(charset[j] == clearText[i]){
                index = j;
                break;
            }
        }

        //wenn es den char im charset gibt den entsprechenden char aus dem secretCharset setzen.
        if(index != -1){
            secretText[i] = secretCharset[index];
        }

    }

    printf("Klartext:\t");

    //Klartext ausgeben
    for(int i = 0; i < clearTextLength; i++){
        printf("%c", clearText[i]);
    }

    printf("\n\nVerschluesselt:\t");

    //secretText ausgeben
    for(int i = 0; i < clearTextLength - 1; i++){
        printf("%c", secretText[i]);
    }

    printf("\n\n");

}

int main()
{
    task1();
    task2();
    task3();
    task4();
    task5();
    task6(1);
    task7();

    return 0;
}
