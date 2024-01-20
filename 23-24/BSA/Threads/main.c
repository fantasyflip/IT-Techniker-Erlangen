#include <stdio.h>
#include <windows.h>

int THREADCOUNT = 1000000;

DWORD WINAPI ThreadFunc(void* data){
    // Hier kommt Code für den Thread
    int i = 0;

    printf("Thread1; Start\n");

    for(i = 0;i < THREADCOUNT;i++){
        printf("Hochgezaehlt - i: %i\n", i);
    }
    return 0;
}

int main()
{
    // Thread erzeugen mit CreateThread

    HANDLE threadhandle = CreateThread(NULL, 0, ThreadFunc, NULL, 0, NULL);
    if(threadhandle){
        // Wenn die Threaderzeugung erfolgreich war, warte auf Beendigung des Threads
        WaitForSingleObject(threadhandle, INFINITE);
    }
}

int main(){

}
