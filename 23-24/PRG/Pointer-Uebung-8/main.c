#include <stdio.h>

void task1(int* a, int* b);
void task2();
void task3();


// Funktion zum tauschen von zwei integers durch Call by reference
// Funktion werden zwei Speicheradressen einer int variable übergeben
void task1(int* a, int* b){
    // Es wird ein typischer Drei-Wege-Tausch verwendet

    int temp;   // Temp-Platz um einen Wert während des Tauschens zu speichern

    temp = *a;  // Den Wert hinter der Speicheradresse a in den Temp-Platz speichern
    *a = *b;    // Den Wert von b in a speichern
    *b = temp;  // Den Wert aus temp(a) in b speichern

    // Kein Return notwendig! Call by refernce ändert die Werte direkt im Speicher über die Speicheradressen
}

void task2(){
    int i_number = 3;       // Int-Variable Wert zuweisen
    double d_number =1.23;  // Double-Variable Wert zuweisen

    // Werte und deren Speicheradressen ausgeben
    printf("Integer:\t%d\t%p\n",i_number, &i_number);
    printf("Double:\t\t%.2f\t%p\n\n",d_number, &d_number);

    int* pi_number = &i_number;     // Int-Pointer auf die Adresse der Int-Variable
    double* pd_number = &d_number;  // Double-Pointer auf die Adresse der Double-Variable

    // Speicheradressen der Pointer ausgeben (Nicht die Speicheradressen der "Zahl"-Variablen!!!)
    // Es werden die Adressen ausgegeben, an denen die Adressen der "Zahl"-Variablen gespeichert werden.
    printf("Integer-Pointer:\t%p\n",&pi_number);
    printf("Double-Pointer:\t\t%p\n\n",&pd_number);

    // Pointer auf Pointer -> zwei Sterne **
    int** ppi_number = &pi_number;      // Int-Pointer auf die Adresse des einfachen Int-Pointers
    double** ppd_number = &pd_number;   // Double-Pointer auf die Adresse des einfachen Double-Pointers

    // Drei-Wege-Tausch mit doppelten Pointern
    // 1.Stern: Wert hinter dem doppelten Pointer: Wert von einfachen Pointern (pi_number, pd_number)
    // 2.Stern: Wert hinter dem einfachen Pointer: Wert von "Zahl"-Variablen (i_number, d_number)
    int temp = **ppi_number;
    **ppi_number = **ppd_number;
    **ppd_number = temp;

    // Werte und deren Speicheradressen ausgeben
    printf("Integer:\t%d\t%p\n",i_number, &i_number);
    printf("Double:\t\t%.2f\t%p\n\n\n",d_number, &d_number);

    // Beim Tausch der Werte verliert der Double Wert seine Nachkommastellen. Der Int-Wert erhält 0en als Nachkommastellen.
}

void task3(){
    unsigned int ui_number = 0x7fed15a0;    // unsigned int variable Wert zuweisen

    // Wert ausgeben
    printf("Unsigned Integer:\t%d\n\n", ui_number);

    // Unsigned Char Pointer erstellen, weil der genau 1 Byte groß ist
    // Pointer zeigt auf die Speicheradresse der Variable (Muss dabei gecastet werden um Warnmeldungen zu vermeiden)
    unsigned char* pui_number = (unsigned char*)&ui_number;

    // For-Schleife mit 4 Durchläufen
    // Variable wird Byte für Byte ausgegeben indem der Pointer bei jedem Durchlauf um 1 erhöht wird, beginnend bei 0.
    for(int i = 0; i < 4; i++){
        printf("Byte %d\t%x\n",i+1,*(pui_number + i));
    }
}

int main()
{
    //Funktionsaufrufe
    int a = 5, b = 10;

    printf("Task 1: Tauschen\n\nVor tauschen\ta=%d\tb=%d\n\n",a,b);

    task1(&a, &b);

    printf("Nach tauschen\ta=%d\tb=%d\n\n\n",a,b);

    printf("Task 2: Elementares Zeiger-Handling\n\n");

    task2();

    printf("Task 3: Zeiger auf void\n\n");

    task3();

    return 0;
}
