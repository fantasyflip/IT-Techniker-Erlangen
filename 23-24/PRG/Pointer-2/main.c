#include <stdio.h>

void tausche(int a, int b);
void tauscheBesser(int* adr_a, int* adr_b);
void tauscheMehr(void* adr_a, void* adr_b, char type);

int main()
{
    int zahl1 = 11;
    int zahl2 = 9999;


    printf("vorher\nzahl1:\t%d\nzahl2:\t%d\n\n", zahl1, zahl2);

    tausche(zahl1, zahl2);  // Call by Value

    printf("nachher\nzahl1:\t%d\nzahl2:\t%d\n\n", zahl1, zahl2);

    // POINTER
    printf("\n\n\nPointer\n\n");

    printf("vorher\nzahl1:\t%d\nzahl2:\t%d\n\n", zahl1, zahl2);

    tauscheBesser(&zahl1, &zahl2);  // Call by Reference

    printf("nachher\nzahl1:\t%d\nzahl2:\t%d\n\n", zahl1, zahl2);


    printf("\n\n\TauscheMehr: integer\n\n");

    printf("vorher\nzahl1:\t%d\nzahl2:\t%d\n\n", zahl1, zahl2);

    tauscheMehr(&zahl1, &zahl2, 'i');  // Call by Reference

    printf("nachher\nzahl1:\t%d\nzahl2:\t%d\n\n", zahl1, zahl2);


    printf("\n\n\TauscheMehr: char\n\n");

    char char1 = 'A', char2 = 'B';

    printf("vorher\nchar1:\t%c\nchar2:\t%c\n\n", char1, char2);

    tauscheMehr(&char1, &char2, 'c'); // Call by Reference

    printf("nachher\nchar1:\t%c\nchar2:\t%c\n\n", char1, char2);


    printf("\n\n\TauscheMehr: float\n\n");

    float float1 = 1.23, float2 = 4.56;

    printf("vorher\nfloat1:\t%f\nfloat2:\t%f\n\n", float1, float2);

    tauscheMehr(&float1, &float2, 'f');  // Call by Reference

    printf("nachher\nfloat1:\t%f\nfloat2:\t%f\n\n", float1, float2);


    printf("\n\n\TauscheMehr: double\n\n");

    double double1 = 1.23, double2 = 4.56;

    printf("vorher\ndouble1:\t%f\ndouble2:\t%f\n\n", double1, double2);

    tauscheMehr(&double1, &double2, 'd');  // Call by Reference

    printf("nachher\ndouble1:\t%f\ndouble2:\t%f\n\n", double1, double2);

    return 0;
}

void tausche(int a, int b){
    int hilf;

    hilf = a;
    a = b;
    b = hilf;
}

void tauscheBesser(int *adr_a, int *adr_b){
    int hilf;

    hilf = *adr_a;  // Wert an Speicherposition in 'hilf' speichern
    *adr_a = *adr_b;    // Inhalte tauschen
    *adr_b = hilf;  // Wert aus 'hilf' in 'b' speichern
}

void tauscheMehr(void* adr_a, void* adr_b, char type){
    if(type == 'i'){
        int hilf;
        int* int_adr_a;
        int* int_adr_b;

        int_adr_a = (int*)adr_a; // cast von void* zu int*
        int_adr_b = (int*)adr_b;

        hilf = *int_adr_a;
        *int_adr_a = *int_adr_b;
        *int_adr_b = hilf;
    }

    if(type == 'c'){
        char hilf;
        char *char_adr_a = (char *)adr_a; // Casting void* to char*
        char *char_adr_b = (char *)adr_b;

        hilf = *char_adr_a;
        *char_adr_a = *char_adr_b;
        *char_adr_b = hilf;
    }

    if(type == 'f'){
        float hilf;
        float* float_adr_a;
        float* float_adr_b;

        float_adr_a = (float*)adr_a; // cast von void* zu float*
        float_adr_b = (float*)adr_b;

        hilf = *float_adr_a;
        *float_adr_a = *float_adr_b;
        *float_adr_b = hilf;
    }

    if(type == 'd'){
        double hilf;
        double* double_adr_a;
        double* double_adr_b;

        double_adr_a = (double*)adr_a; // cast von void* zu double*
        double_adr_b = (double*)adr_b;

        hilf = *double_adr_a;
        *double_adr_a = *double_adr_b;
        *double_adr_b = hilf;
    }
}


