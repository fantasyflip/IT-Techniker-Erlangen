#include <stdio.h>

int stringIndex(char text[], char symbol);

int stringIndex(char text[], char symbol){
    int length = sizeof(text);
    int position = -1;

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
    printf("pos: %d\n\n", stringIndex("test",'e'));
    return 0;
}
