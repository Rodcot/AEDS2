#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char s[]);

void isVogal(char s[]);

void isConsoante(char s[]);

void isInteiro(char s[]);

void isReal (char s[]);

int main(){
    char entrada[1000][100];
    int nEntrada = 0;

    do{
        scanf(" %[^\n]s", entrada[nEntrada]);
    } while (isFim(entrada[nEntrada++]) == false);
    nEntrada--; 

    //pra cada entrada, uma de saida com o numero de letras de cada tipo.
    for (int i = 0; i < nEntrada; i++){
        isVogal(entrada[i]);
        printf(" ");
        isConsoante(entrada[i]);
        printf(" ");
        isInteiro(entrada[i]);
        printf(" ");
        isReal(entrada[i]);
        printf("\n");
    }
    return 0;
}

bool isFim(char s[]){
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

void isVogal(char s[]){
    bool resp = false;
    for(int i = 0 ; i < strlen(s); i++){ 
        if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'){
            resp = true;
        } else {
            i = strlen(s);
            resp = false;
        }     
    }
    if (resp == false){
        printf("NAO");
    } else {
        printf("SIM");
    }
}

void isConsoante(char s[]){
    bool resp  = false;
    for(int i = 0; i < strlen(s); i++){
        if( (int)s[i] > 64 && (int)s[i] < 91 || (int)s[i] > 96 && (int)s[i] < 123){    
            if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'){
                i = strlen(s);
                resp = false;
            } else {
                resp = true;
            }
        }
    }
    if (resp == false){
        printf("NAO");
    } else {
        printf("SIM");
    }
}

void isInteiro(char s[]){
    bool resp = false;
    for(int i = 0; i < strlen(s); i++){
        if ((int)s[i] > 47 && (int)s[i] < 58){
            resp = true;
        } else {
            i = strlen(s);
            resp = false;
        }
    }

    if (resp == true){
        printf("SIM");
    } else {
        printf("NAO");
    }
}

void isReal (char s[]){
    bool resp = false;
    for(int i =0; i < strlen(s); i++){
        if((int)s[i] > 47 && (int)s[i] < 58 || s[i] == 46){
            resp = true;
        } else {
            resp = false;
            i = strlen(s);
        }
    }
    if(resp == true){
        printf("SIM");
    } else {
        printf("NAO");
    }    
}
