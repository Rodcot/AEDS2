#include <stdio.h>
#include <stdlib.h>
int main(){
    int n1,n2,n3, highest = 0, maisVelho = 0;
    scanf("%d", &n1);
    if(n1 == 0){
        exit(0);
    }
    scanf("%d", &n2);
    scanf("%d", &n3);

    if(n1 > n2 && n1 > n3){
        highest = n1;
        n1 = 0;
    }else if(n2 > n1 && n2 > n3){
        highest = n2;
        n2 = 0;
    }else if(n3 > n2 && n3 > n1){
        highest = n3;
        n3 = 0;
    }
    int idade = highest - (n1+n2+n3);

    if(idade > n2 && idade > n3 && idade > n1){
        maisVelho = idade;
    }else if(n1 > n2 && n1 > n3 && n1 > idade){
        maisVelho = n1;
    }else if(n2 > n1 && n2 > n3 && n2 > idade){
        maisVelho = n2;
    }else if(n3 > n1 && n3 > n2 && n3 > idade){
        maisVelho = n3;
    }

    printf("%d", maisVelho);

    return 0;
}