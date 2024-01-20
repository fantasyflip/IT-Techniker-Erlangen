#include <stdio.h>

void task1(){
    printf("Aufgabe 1: Fakultaet\n\n");

    //Variablen definieren
    int input = 9, output = 1;

    //Schleife so oft wiederholen wie der input
    for(int i = 1; i <= input; i ++){
        //i mit dem output multiplizieren
        output = i * output;
    }

    //Ergebnis ausgeben
    printf("Die Fakultaet der Zahl %i ist %i\n\n", input, output);
}

void task2(){
    printf("Aufgabe 2: Fibonacci\n\n");

    //Variablen definieren - die ersten beiden Fib-Zahlen sind statisch definiert. Erste Fib 'preLastFib' 0 und zweite Fib 'lastFib' 1. Das Offset wird deshalb auf 2 gesetzt.
    int target = 35, lastFib = 1, preLastFib = 0, offset = 2;

    //Ausgaben Header
    printf("Pos.\tFib.\n");

    //Ersten beiden statischen Fib-Zahlen ausgeben
    printf("%i\t%i\n", 1, 0);
    printf("%i\t%i\n", 2, 1);

    //Die restlichen Fib-Zahlen können dynamisch generiert werden. Bis zum target - den offset
    for(int i = 0; i < target - offset; i++){
        //Aktuelle Fib-Zahl berechnen
        int currentFib = lastFib + preLastFib;
        //Fib-Zahlen um eins nach hinten schieben.
        preLastFib = lastFib;
        lastFib = currentFib;

        //Aktuelle Fib-Zahl ausgeben - Position ist i + 1, da die Schleife bei 0 beginnt, + offset nach den ersten beiden statischen Fib-Zahlen
        printf("%i\t%i\n", i + 1 + offset, currentFib);
    }

    printf("\n");
}

void task3(){
    printf("Aufgabe 3: Dreieck\n\n");

    //Variable definieren
    int height = 9;

    //Schleife für die Zeilen
    for(int i = 0; i < height; i++){
        //Schleife für die Sterne
        for(int j = 0; j <= i; j++){
            printf("*");
        }
        //Absatz nach jeder Zeile mit Sternen
        printf("\n");
    }

    printf("\n");
}

void task4(){
    printf("Aufgabe 4: Quadrat mit Diagonalen\n\n");

    const char fillIcon = 'x', spaceIcon = '-';

    #define  WIDTH 15

    //Schleife für Zeilen
    for(int i = 0; i < WIDTH; i++){
        //Schleife für Zeichen in der Zeile
        for(int j = 0; j < WIDTH; j++){
            //Wenn es die erste oder die letzte Zeile ist
            if(i == 0 || i == WIDTH - 1){
                //fillIcon ausgeben
                printf("%c",fillIcon);
            }
            //Wenn es das erste oder letzte Zeichen in einer Zeile ist
            else if (j == 0 || j == WIDTH - 1){
                //fillIcon ausgeben
                printf("%c", fillIcon);
            }
            //Diagonalen zeichnen
            else if(i == j || i == WIDTH - j - 1){
                //fillIcon ausgeben
                printf("%c", fillIcon);
            }
            //Sonst spaceIcon ausgeben
            else {
                printf("%c", spaceIcon);
            }
        }

        //Absatz nach jeder Zeile
        printf("\n");
    }

    printf("\n");
}

void task5(){
    printf("Aufgabe 5: Raute\n\n");

    //Variablen definieren
    const char fillIcon = 'O', spaceIcon = '+';
    const int width = 9;

    //Überprüfen ob die Breite ungerade ist.
    if(width % 2 == 0){
        printf("Die Breite muss ungerade sein. Gewaehlte Breite: %i\n", width);
    } else {

        //Schleife für jede Zeile
        for(int i = 0; i < width; i++){
            //Schleife für jedes Zeichen
            for(int j = 0; j < width; j++){
                //Horizontale Mitte
                if(i == (width/2)){
                    printf("%c",fillIcon);
                }
                //Vertikale Mitte
                else if(j == (width/2)){
                    printf("%c",fillIcon);
                }
                //Diagonalen
                else if(j == (width/2) + i || j == (width/2) - i || j == i - (width/2) ||  j == (width - i-1) + (width/2)){
                    printf("%c",fillIcon);
                }
                //Restliche Zeichen
                else {
                    printf("%c",spaceIcon);
                }
            }
            printf("\n");
        }
    }

    printf("\n");
}

void task6(){
    printf("Aufgabe 6: Dreieck - Rechter Winkel unten links\n\n");

    //Variable definieren
    int height = 9;

    //Schleife für die Zeilen
    for(int i = 0; i < height; i++){
        //Schleife für die Sterne
        for(int j = 0; j <= i; j++){
            printf("*");
        }
        //Absatz nach jeder Zeile mit Sternen
        printf("\n");
    }

    printf("\n");
}

void task7(){
    printf("Aufgabe 7: Dreieck - Rechter Winkel unten rechts\n\n");

    //Variable definieren
    int height = 9;

    //Schleife für die Zeilen
    for(int i = 0; i <= height; i++){
        //Schleife für die Leerzeichen vor den Sternen
        for(int j = 0; j < height - i; j++){
            printf(" ");
        }
        //Schleife für die Sterne
        for(int j = 0; j < i; j++){
            printf("*");
        }
        //Absatz nach jeder Zeile
        printf("\n");
    }

    printf("\n");
}

void task8(){
    printf("Aufgabe 8: Dreieck - Rechter Winkel oben links\n\n");

    //Variable definieren
    int height = 9;

    //Schleife für die Zeilen
    for(int i = height; i > 0; i--){
        //Schleife für die Sterne
        for(int j = 0; j < i; j++){
            printf("*");
        }
        //Absatz nach jeder Zeile mit Sternen
        printf("\n");
    }

    printf("\n");
}

void task9(){
    printf("Aufgabe 9: Dreieck - Rechter Winkel oben rechts\n\n");

    //Variable definieren
    int height = 9;

    //Schleife für die Zeilen
    for(int i = 0; i < height; i++){
        //Schleife für die Leerzeichen vor den Sternen
        for(int j = 0; j < i; j++){
            printf(" ");
        }
        //Schleife für die Sterne
        for(int j = 0; j < height-i; j++){
            printf("*");
        }
        //Absatz nach jeder Zeile
        printf("\n");
    }

    printf("\n");
}

void task10(){
    printf("Aufgabe 10: Raute aus Sternen\n\n");

    int width = 9;

    if(width % 2 == 0){
        printf("Die Breite muss ungerade sein. Gewaehlte Breite: %i\n", width);
    } else {

        //Schleife für die Zeilen
        for(int i = 0; i < width; i ++){
            //Leerzeichen links und rechts berechnen
            int spaces = (width/2)-i;

            //Wenn Leerzeichen negativ sind den Betrag davon benutzen
            if(spaces < 0){
                spaces = spaces * -1;
            }


            //Leerzeichen ausgaben
            for(int j = 0; j < spaces; j++){
                printf(" ");
            }
            //Sterne ausgeben
            for(int j = 0; j < width-(spaces*2); j++){
                printf("*");
            }
            //Leerzeichen ausgeben
            for(int j = 0; j < spaces; j++){
                printf(" ");
            }

            //Absatz nach jeder Zeile
            printf("\n");

        }
    }

    printf("\n");
}

void task11(){
    printf("Aufgabe 11: Zusatzaufgabe\n\n");

    int count = 3;
    int invert = 0;

    //Schleife für Reihe der Blöcke
    for(int l = 0; l < count; l++){
        //Schleife für Zeilen
        for(int k = 0; k < count; k++){
            //Schleife für die Wiederholung der Count Muster -> count = 3 -> Ein Muster OOO oder XXX
            for(int i = 0; i < count; i++){
                //Schleife für ein Muster -> n * X oder n * O
                for(int j = 0; j < count; j++){
                    if(i % 2 == 0){
                        printf("%c", invert == 1 ? 'X' : 'O');
                    } else {
                        printf("%c", invert == 1 ? 'O' : 'X');
                    }
                    printf(" ");
                }
            }
            printf("\n");
        }

        //Invertieren der Muster für die Folge Reihe
        if(invert == 0){
            invert = 1;
        } else {
            invert = 0;
        }
    }
    printf("\n\n");
}

void task12(){
    printf("Aufgabe 12: Pot. Schulaufgaben Aufgabe - Haus vom Nikolaus\n\n");


    //Höhe (und Breite) des Hauses OHNE das Dach
    int height = 23;

    //Dach ausgeben, ohne horizontalen Strich
    //Schleife für die Höhe -> Höhe ist die Höhe des Hauses / 2 und anschließend aufgerundet. Bei 7 / 2 = 3,5 wird bei int einfach 3 daraus. Deshalb muss man hier +1 machen um die Mitte zu finden
    for(int i = 0; i < height/2+1; i++){
        //Abstand zur Seite berechnen - Ist links und rechts immer gleich weit entfernt
        int offset = (height/2)+1-i;
        //Schleife für die Zeile
        for(int j = 0; j < height; j++){
            //Jedes mal wenn j an der stelle eines offsets ist wird ein Stern gemacht. Sonst Leerzeichen
            if(j == offset-1 || j == height-offset){
                printf("*");
            } else {
                printf(" ");
            }
        }
        //Nach jeder vollen Zeile: Zeilenumbruch
        printf("\n");
    }

    //Haus zeichnen
    //Schleife für die Zeilen
    for(int i = 0; i < height; i++){
        //Schleife für die Spalten
        for(int j = 0; j < height; j++){
            //Wenn es die erste oder die letzte Zeile ist permanent mit * ausfüllen (Boden und Dach)
            if(i==0 || i == height-1){
                printf("*");
            }
            //Wenn es die erste oder die letzte Spalte ist permanent mit * ausfüllen (Seitenwände links und rechts)
            else if(j == 0 || j == height-1){
                printf("*");
            }
            //Diagonalen:
            //links oben -> rechts unten: Wenn j und i gleich sind wird ein * gesetzt
            //rechts oben -> links unten: Wenn j die breite - 1 (fangen bei 0 an zu zählen) - i (um sich immer weiter nach links anzunähern) ist wird ein * gesetzt
            else if(j == i || j == height-1-i){
                printf("*");
            }
            //Sonst wird ein Leerzeichen gesetzt
            else {
                printf(" ");
            }
        }
        //Nach jeder vollen Zeile: Zeilenumbruch
        printf("\n");
    }

    //Die IF-Abfragen aus dem Zeichnen des Hauses können theoretisch auch in einer einzigen IF-Abfrage erledigt werden (auskommentieren zum testen):

//    for(int i = 0; i < height; i++){
//        for(int j = 0; j < height; j++){
//            if(i==0 || i == height-1 || j == 0 || j == height-1 || j == i || j == height-1-i){
//            // ^-----1.Abfrage-------^^------2.Abfrage----------^^-------3. Abfrage--------^
//                printf("*");
//            } else {
//                printf(" ");
//            }
//        }
//        printf("\n");
//    }

    printf("\n\n");
}

int main()
{
//    task1();
//    task2();
//    task3();
//    task4();
    task5();
//    task6();
//    task7();
//    task8();
//    task9();
//    task10();
//    task11();
//    task12();

    return 0;
}
