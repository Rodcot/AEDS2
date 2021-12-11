#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char s[]);

bool verificarPalindromo(char s[]);

int main(){
    char entrada[1000][100];
    int nEntrada = 0;

    do{
        scanf(" %[^\n]s", entrada[nEntrada]);
    } while (isFim(entrada[nEntrada++]) == false);
    nEntrada--;


    for (int i = 0; i < nEntrada; i++){
        if (verificarPalindromo(entrada[i])){
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
    }
    return 0;
}

bool isFim(char s[]){
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool verificarPalindromo(char s[]){
    bool resp = false; 
    for(int i = 0 ; i < strlen(s); i++){
        if(s[i] == s[(strlen(s) -i -1 )]){
            resp = true;
        } else {
            resp = false;
            i = strlen(s);
        }
    }
    return resp;
}