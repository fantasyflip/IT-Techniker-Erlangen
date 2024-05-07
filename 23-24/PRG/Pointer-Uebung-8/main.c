#include <stdio.h>

void task1(int* a, int* b);

void task1(int* a, int* b){
    int temp;

    temp = *a;  // Wert an Speicherposition in 'temp' speichern
    *a = *b;    // Inhalte tauschen
    *b = temp;  // Wert aus 'temp' in 'b' speichern
}

int main()
{
    int a = 5, b = 10;

    printf("Task 1: Tauschen\n\nVor tauschen\ta=%d\tb=%d\n\n",a,b);

    task1(&a, &b);

    printf("Nach tauschen\ta=%d\tb=%d\n\n\n",a,b);

    return 0;
}
