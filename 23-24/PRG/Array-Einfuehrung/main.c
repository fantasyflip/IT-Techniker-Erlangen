#include <stdio.h>

int main()
{
    //Temperatursensor misst jede Minute
    //Messwerte: 20.1, 20.0, 19.5, 19.1, ...
    //An einem Tag sind das 24*60 = 524160 Werte

    double tempWerte[1440] = {20.1, 20.0, 19.5, 19.1};
    char wort[11]= {'W','e','r','n','e','r'};
    char wort2[11] = "Werner";

    for(int i=0; i<6;i++){
        printf("%c",wort[i]);
    }

    printf("\n\n");

    printf("%s\n\n",wort);

    printf("%s\n\n",wort2);

    printf("Anfangsadresse im Speicher von wort: %u\n\n",wort);
    printf("Anfangsadresse im Speicher von wort: %x\n\n",wort);
    printf("Anfangsadresse im Speicher von wort: %p\n\n",wort);


    int k = 0;

    while(wort[k]!='\0'){
        printf("%c", wort[k]);
        k++;
    }

    printf("\n\n");

//    tempWerte[0] = 20.1;
//    tempWerte[1] = 20.0;
//    tempWerte[2] = 19.5;
//    tempWerte[3] = 19.1;

    for(int i = 0; i < 4; i++){
        printf("%.1lf Grad Celsius\n", tempWerte[i]);
    }

    return 0;
}
