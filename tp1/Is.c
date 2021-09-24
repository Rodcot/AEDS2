#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main(){
    for(;;){ 
            char input[256];
            scanf("%s", &input);

            int c = strcmp(input, "FIM");
            if(c == 0){
                exit(0);
            }

            int len = strlen(input);
            int flag = 0;

            for(int i = 0; i < len; i++){
                if(input[i] == 'A' || input[i] == 'E' || input[i] == 'I' || input[i] == 'O' || input[i] == 'U' 
                || input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u' ){
                }else{
                    flag = 1;
                }
            }

            if(flag == 1){
                printf("NAO ");
            }else{
                printf("SIM ");
            }
            
            flag = 0;

            for(int i = 0; i < len; i++){
                if(input[i] == 'B' || input[i] == 'C' || input[i] == 'D' || input[i] == 'F' || input[i] == 'H' 
                || input[i] == 'J' || input[i] == 'K' || input[i] == 'L' || input[i] == 'M' || input[i] == 'N'
                || input[i] == 'P' || input[i] == 'Q' || input[i] == 'R' || input[i] == 'S' || input[i] == 'T'
                || input[i] == 'V' || input[i] == 'W' || input[i] == 'X' || input[i] == 'Z' || input[i] == 'b'
                || input[i] == 'c' || input[i] == 'd' || input[i] == 'f' || input[i] == 'h' || input[i] == 'j'
                || input[i] == 'q' || input[i] == 'r' || input[i] == 's' || input[i] == 't' || input[i] == 'v'
                || input[i] == 'w' || input[i] == 'x' || input[i] == 'z' || input[i] == 'k' ){
                }else{
                    flag = 1;
                }

                
            }

            if(flag == 1){
                printf("NAO ");
            }else{
                printf("SIM ");
            }

            flag = 0;

            for(int i = 0; i < len; i++){
                if(input[i] == '1' || input[i] == '2' || input[i] == '3' || input[i] == '4' || input[i] == '5' 
                || input[i] == '6' || input[i] == '7' || input[i] == '8' || input[i] == '9' || input[i] == '0'){
                }else{
                    flag = 1;
                } 
            }
            
            if(flag == 1){
                printf("NAO ");
            }else{
                printf("SIM ");
            }

            flag = 0;

            for(int i = 0; i < len; i++){
                if(input[i] == '1' || input[i] == '2' || input[i] == '3' || input[i] == '4' || input[i] == '5' 
                || input[i] == '6' || input[i] == '7' || input[i] == '8' || input[i] == '9' || input[i] == '0'
                || input[i] == '.' || input[i] == ','){
                }else{
                    flag = 1;
                } 
            }
            
            if(flag == 1){
                printf("NAO\n");
            }else{
                printf("SIM\n");
            }

        }

}