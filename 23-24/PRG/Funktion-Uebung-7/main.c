#include <stdio.h>
#include <string.h>

int stringIndex(char text[], char symbol);
int enthaeltString(char wrappingText[], char innerText[]);

int stringIndex(char text[], char symbol){
    int length = strlen(text);
    int position = -1;

    for(int i = 0; i < length; i++){
        if(text[i] == symbol){
            position = i;
            i = length;
        }
    }

    return position;
}

int enthaeltString(char wrappingText[], char innerText[]){
    int isContaining = 0;
    int wrappingTextLength = strlen(wrappingText);
    int innerTextLength = strlen(innerText);

    if(wrappingTextLength < innerTextLength) return 0;

    for(int i = 0; i < wrappingTextLength; i++){
        int matchingChars = 0;
        for(int j = 0; j < innerTextLength; j++){
            if(wrappingText[i+j] == innerText[j]){
                matchingChars++;
                if(matchingChars == innerTextLength){
                    isContaining = 1;
                    i = wrappingTextLength;
                    j = innerTextLength;
                }
            } else {
                j = innerTextLength;
            }
        }
    }

    return isContaining;
}

int main()
{
    printf("enthaelt: %d\n\n", enthaeltString("abctestefg","test"));
    return 0;
}
