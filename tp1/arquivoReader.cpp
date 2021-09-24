 #include <stdio.h>
 
void readarc(int n){
    FILE * arquivo =fopen("exemplo.txt", "rb");
    if(arquivo == NULL){
        printf("Erro ao abrir arquivo\n");
    }
    else{
         for(int i=0;i<n;i++){
        double number=0;
        
        fseek(arquivo,  (n-1-i)*8, SEEK_SET);
        fread(&number, sizeof(double), 1, arquivo);
        int numberInteiro;
        int res;
        res=number;
        if(number-res!=0){
            printf("%g\n", number);
        }else{
            printf("%d\n", res);
        }
        }
    fclose(arquivo); 
    } 
}

void oparc(int n){
    double x=0; 
    FILE * arquivo =fopen("exemplo.txt", "wb");

    if(arquivo == NULL){
        printf("Erro ao abrir arquivo\n");
    }else{
        for(int i =0 ;i<n;i++){
             scanf("%lf",&x);
             fwrite(&x, sizeof(double), 1, arquivo); 
        }
        fclose(arquivo);
    }
} 

int main (){
    int n=0;
    scanf("%d\n", &n);
    oparc(n);
    readarc(n);
} 