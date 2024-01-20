// Lösung von Andreas Pfeiffer

#include <stdio.h>

int main()
{

    int jahr = 2024;

    if (jahr % 4 == 0) {
        if (jahr % 100 == 0) {
            if (jahr % 400 == 0) {
                printf("%d ist ein Schaltjahr.\n", jahr);
            } else {
                printf("%d ist kein Schaltjahr.\n", jahr);
            }
        } else {
            printf("%d ist ein Schaltjahr.\n", jahr);
        }
    } else {
        printf("%d ist kein Schaltjahr.\n", jahr);
    }

    return 0;
}


// #include <stdio.h>

//int main() {
//    int jahr;

//    printf("Bitte geben Sie eine Jahreszahl ein: ");
//    scanf("%d", &jahr);

//    if ((jahr % 4 == 0 && jahr % 100 != 0) || (jahr % 400 == 0)) {
//        printf("%d ist ein Schaltjahr.\n", jahr);
//    } else {
//        printf("%d ist kein Schaltjahr.\n", jahr);
//    }

//    return 0;
//}

