#include <stdio.h> 

int main(){
    int inputLimit;
    scanf("%d",&inputLimit);

    FILE *originalFile = fopen("arquivo.txt", "wb");

    for(int i = 0; i < inputLimit; i++){
        double n;
        scanf("%lf", &n);
        fwrite(&n, sizeof(double), 1, originalFile);
    }
    fclose (originalFile);

    originalFile = fopen("arquivo.txt", "rb");

    for(int i=0;i<inputLimit;i++){
        double n;

        fseek(originalFile, (inputLimit - 1 -i )*8, SEEK_SET);
        fread(&n, sizeof(double), 1, originalFile);

        int integer = n;
        if(n - integer != 0){
            printf("%g\n", n);
        }else{
            printf("%d\n", integer);
        }
    }
    fclose(originalFile);
}