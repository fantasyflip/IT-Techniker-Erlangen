#include <stdio.h>

void task1(int* a, int* b);
void task2();

void task1(int* a, int* b){
    int temp;

    temp = *a;  // Wert an Speicherposition in 'temp' speichern
    *a = *b;    // Inhalte tauschen
    *b = temp;  // Wert aus 'temp' in 'b' speichern
}

void task2(){
    int i_number = 3;
    double d_number =1.23;

    printf("Integer:\t%d\t%p\n",i_number, &i_number);
    printf("Double:\t\t%.2f\t%p\n\n",d_number, &d_number);

    int* pi_number = &i_number;
    double* pd_number = &d_number;

    printf("Integer-Pointer:\t%p\n",&pi_number);
    printf("Double-Pointer:\t\t%p\n\n",&pd_number);

    int** ppi_number = &pi_number;
    double** ppd_number = &pd_number;

    int temp = **ppi_number;
    **ppi_number = **ppd_number;
    **ppd_number = temp;

    printf("Integer:\t%d\t%p\n",i_number, &i_number);
    printf("Double:\t\t%.2f\t%p\n\n",d_number, &d_number);
}

int main()
{
    int a = 5, b = 10;

    printf("Task 1: Tauschen\n\nVor tauschen\ta=%d\tb=%d\n\n",a,b);

    task1(&a, &b);

    printf("Nach tauschen\ta=%d\tb=%d\n\n\n",a,b);

    printf("Task 2: Elementares Zeiger-Handling\n\n");

    task2();

    return 0;
}
