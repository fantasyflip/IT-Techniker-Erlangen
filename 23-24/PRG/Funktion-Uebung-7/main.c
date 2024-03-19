#include <stdio.h>
#include <string.h>

int stringIndex(char text[], char symbol);

int stringIndex(char text[], char symbol){
    int length = strlen(text);
    int position = -1;

    printf("%d",length);

    for(int i = 0; i < length; i++){
        if(text[i] == symbol){
            position = i;
            i = length;
        }
    }

    return position;
}

int main()
{
    printf("pos: %d\n\n", stringIndex("test",'p'));
    return 0;
}
