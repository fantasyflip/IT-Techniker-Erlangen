#include <stdio.h>
#include <string.h>

int stringIndex(char text[], char symbol);
int enthaeltString(char wrappingText[], char innerText[]);
int isEqual(char text1[], char text2[]);

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

int isEqual(char text1[], char text2[]){
    int length1 = strlen(text1);
    int length2 = strlen(text2);
    int isEqual = 1;

    if(length1 != length2) return 0;

    for(int i = 0; i < length1; i++){
        if(text1[i] != text2[i]){
            i = length1;
            isEqual = 0;
        }
    }

    return isEqual;
}

int main()
{
    printf("gleich: %d\n\n", isEqual("test","test"));
    return 0;
}
