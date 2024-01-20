#include <stdio.h>


void task1() {
    printf("Aufgabe 1:\n\n");

    int result = 0;

    for(int i = 1; i <= 100; i++){
        // i zum Ergebnis addieren und anschließend im Ergebnis abspeichern, damit beim nächsten Durchlauf der aktuelle Stand verfügbar ist.
        result = result + i;
    }

    printf("Die Summe aus allen Zahlen von 0-100 ist %d.\n\n", result);
}

void task2(){
    printf("Aufgabe 2:\n\n");

    //Kleines 1x1 -> maximal bis 10
    int limit = 10;

    //Anfag der Header-Ausgabe
    printf("0\t|");

    //Zahlen von 1 bis einschließlich zum Limit von links nach rechts ausgeben.
    for(int i = 1; i <= limit; i++){
        printf("%d\t", i);
    }

    printf("\n");

    //Horizontale Abgrenzung unter dem Header passend zur Größe des Limits.
    for(int i = 0; i <= limit; i++){
        printf("--------");
    }

    printf("\n");
    //Ende der Header-Ausgabe

    for(int i = 1; i <= limit; i++){
        //i entspricht Wert auf der Y-Achse. -> Ein i-durchlauf ergibt eine Zeile.

        //Ausgabe des Werts in i zu beginn jeder Zeile für den vertikalen Header.
        printf("%d\t|",i);
        for(int j = 1; j <= limit; j++){
            //j entspricht Wert auf der X-Achse.

            //Ergebnis aus i x j ausgeben. Mit \t wird ein Tab eingefügt für gleichmäßigen Platz. (Nur bis zu einer maximalen Größe von 7 Stellen. Danach wird das Layout gebrochen -> reicht für das kleine 1x1)
            printf("%d\t", i * j);
        }

        //Nachdem alle Werte aus dem i-er 1x1 berecnet wurden beginnt eine neue Zeile.
        printf("\n");
    }

    printf("\n\n");
}

void task3(){
    printf("Aufgabe 3:\n\n");

    // Schleife für Teilaufgabe a und b -> i = 0 entspricht a | i = 1 entspricht b
    for(int i = 0; i <=1; i++){
        //Anfang Header-Ausgabe

        //Wenn i = 0, dann 'a)' ausgeben, sonst 'b)'
        printf("%c)\n\n",i == 0? 'a':'b');
        printf("a # b # c # d #");
        //Entsprechend der Teilaufgabe passenden Ausdruck ausgeben im Header
        i == 0 ? printf(" a && b || c && d\n") : printf(" a && (b || c) && d\n");
        printf("--------------------------------\n");

        //Ende Header-Ausgabe

        //Schleife für die erste Spalte der Wahrheitstabelle.
        //Bevor sich a ändert müssen erst alle anderen Werte sich ändern.
        //(Es gibt nur zwei Zustände. Deswegen ist die Bedingung der Schleifen immer x <= 1 -> 0 <= 1 & 1 <= 1)
        for(int a = 0; a <= 1; a++){

            // Schleife für die zweite Spalte der Wahrheitstabelle.
            for(int b = 0; b <= 1; b++){

                // Schleife für die dritte Spalte der Wahrheitstabelle.
                for(int c = 0; c <= 1; c++){

                    // Schleife für die vierte Spalte der Wahrheitstabelle.
                    for(int d = 0; d <= 1; d++){

                        //Unterscheidung ob es aktuell um die Teilaufgabe a oder b geht.
                        if(i == 0){
                            //Komplette Ausgabe einer möglichen Konstellation des Ausdrucks aus Teilaufgabe a
                            printf("%d # %d # %d # %d # \t%d\n",a,b,c,d, a&&b||c&&d?1:0);
                        } else {
                            //Komplette Ausgabe einer möglichen Konstellation des Ausdrucks aus Teilaufgabe a
                            printf("%d # %d # %d # %d # \t%d\n",a,b,c,d, a&&(b||c)&&d?1:0);
                        }

                    }
                }
            }
        }

        printf("\n\n");
    }
}

void task4(){
    printf("Aufgabe 4:\n\n");

    //Ausgangsnummer im Dezimalsystem.
    int number =1234;
    //Integer-Array um die 0en und 1en aus der Umrechnung abzuspeichern und im Anschluss eine Ausgabe in der richtigen Reihenfolge zu ermöglichen.
    int binary[32];
    //Index um zu Zählen wie viele Stellen die Binärzahl hat.
    int index = 0;

    //Ausgabe der Dezimalzahl
    printf("Die Dezimalzahl ist: %d\n", number);

    //Solange die nummer nicht 0 ist soll die Dezimalzahl durch 2 geteilt werden und der Rest wird in den Integer-Array abgespeichert.
    while(number != 0)  {
        //Rest ermitteln und abspeichern in den Array.
        binary[index] = number % 2;
        //Tatsächliche Teilung durch zwei und abspeichern für den nächsten Durchlauf. Da ein Integer verwendet wird sind Nachkommastellen irrelevant und werden abgeschnitten ohen die Zahlen vor dem Komma zu beeinflussen.
        number = number / 2;
        //Binärzahl ist um eine Stelle länger geworden -> Index um 1 erhöhen.
        index++;
    }

    printf("Die Binaerzahl ist: ");
    //Aktuell ist die Binärzahl in umgekehter Reihenfolge im Array abgespeichert.
    //Für die Ausgabe in der richtigen Reihenfolge wird der Array von der letzten Stelle in der sich ein Wert befindet (index - 1) bis zur ersten Stelle (0) durchgegangen und jedes mal der Inhalt der jeweiligen Zelle ausgegeben.
    for (int i = index - 1; i >= 0; i--) {
        printf("%d", binary[i]);

        //Zur Übersichtlichkeit der Ausgabe wird nach jeder vierten Stelle von rechts nach links ein Leerzeichen eingefügt.
        if(i%4 == 0){
            printf(" ");
        }
    }

    printf("\n\n");
}

int main()
{
    //Aufruf der einzelnen Funktionen.
    task1();
    task2();
    task3();
    task4();
    return 0;
}
