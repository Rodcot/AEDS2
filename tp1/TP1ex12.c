#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char s[]);

bool verificarPalindromo(char s[], int count, int z);

int main(){
    char entrada[1000][100];
    int nEntrada = 0;

    do{
        scanf(" %[^\n]s", entrada[nEntrada]);
    } while (isFim(entrada[nEntrada++]) == false);
    nEntrada--;

    for (int i = 0; i < nEntrada; i++){
        if (verificarPalindromo(entrada[i],0,0)){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
    }
    return 0;
}

bool isFim(char s[]){
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool verificarPalindromo(char s[], int count, int z){ 
    bool resp = false; 

    if (z < strlen(s)/2) { 
        if(s[z] == s[(strlen(s) - z - 1 )]){   
            return verificarPalindromo( s , count + 1, z+1);
        }else{ 
            return verificarPalindromo(s, count, z+1);
        }
    } 

    if(count == strlen(s)/2){
        resp = true;
    }else{
        resp = false;
    }

    return resp;
}