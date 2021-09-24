#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool isPalRec(char str[],int s, int e){
    if (s == e){
        return true;
    }
    if (str[s] != str[e]){
        return false;
    }
    if (s < e + 1){
        return isPalRec(str, s + 1, e - 1);
    }
    
    return true;
}

bool isPal(char str[]){
    int n = strlen(str);
    if (n == 0){
        return true;
    }
        
    return isPalRec(str, 0, n - 1);
}

int main(){
    for(;;){
        char original[256];
        scanf("%s", &original);

        int c = strcmp(original, "FIM");
        if(c == 0){
            exit(0);
        }

        if(isPal(original)){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
    }
    return 0;
}