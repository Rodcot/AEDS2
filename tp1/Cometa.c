#include <stdio.h>
#include <stdlib.h>
int main(){
    int nextComet, year;
    scanf("%d", &year);

    if(year == 0){
        exit(0);
    }
    if(year < 2062){
            nextComet = year + (76 - (year - 1986));
            printf("%d", nextComet);
        }else if(year < 2138){
            nextComet = year + (76 - (year - 2062));
            printf("%d", nextComet);
        }else if(year < 2214){
            nextComet = year + (76 - (year - 2138));
            printf("%d", nextComet);
        }else if(year < 2290){
            nextComet = year + (76 - (year - 2214));
            printf("%d", nextComet);
        }else if(year < 2366){
            nextComet = year + (76 - (year - 2290));
            printf("%d", nextComet);
        }else if(year < 2442){
            nextComet = year + (76 - (year - 2366));
            printf("%d", nextComet);
        }else if(year < 2518){
            nextComet = year + (76 - (year - 2442));
            printf("%d", nextComet);
        }else if(year < 2594){
            nextComet = year + (76 - (year - 2518));
            printf("%d", nextComet);
        }else if(year < 2670){
            nextComet = year + (76 - (year - 2594));
            printf("%d", nextComet);
        }else if(year < 2746){
            nextComet = year + (76 - (year - 2670));
            printf("%d", nextComet);
        }else if(year < 2822){
            nextComet = year + (76 - (year - 2746));
            printf("%d", nextComet);
        }else if(year < 2898){
            nextComet = year + (76 - (year - 2822));
            printf("%d", nextComet);
        }else if(year < 2974){
            nextComet = year + (76 - (year - 2898));
            printf("%d", nextComet);
        }else{
            printf("0");
        }
    

    return 0;
}