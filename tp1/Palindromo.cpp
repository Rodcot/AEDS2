#include <iostream>
#include <cstring>
using namespace std;

int main(){
    char string1[20];
    int i, length;
    
    for(;;){
        int flag = 0;
        cin >> string1;
        int c = strcmp(string1, "FIM");
        if(c == 0){
            exit(0);
        }
        length = strlen(string1);
        
        for(i=0;i < length ;i++){
            if(string1[i] != string1[length-i-1]){
                flag = 1;
                break;
            }
        }

        if (flag) {
            cout <<"NAO"<< endl; 
        }    
        else {
            cout <<"SIM"<< endl; 
        }
    }

    return 0;
}