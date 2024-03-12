#include <stdio.h>

int fakuIter(int n);
int fakuRec(int n);

int main()
{
    printf("Fakultaet (Iterativ) von %d: %d\n", 3, fakuIter(3));
    printf("Fakultaet (Rekursiv) von %d: %d\n", 3, fakuRec(3));
    return 0;
}

int fakuIter(int n){
    int res = 1;

    for(int i = 1; i<=n; i++){
        res = res * i;
    }

    return res;
}

int fakuRec(int n){
    if(n==1) return 1;
    else return n * fakuRec(n-1);
}
