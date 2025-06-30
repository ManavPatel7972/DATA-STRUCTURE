#include<stdio.h>
int main(){

    for(int i=0;i<5;i++){
        for(int s = 0;s<=4-i;s++){
            printf(" ");
        }
        for(int j=1;j<=i+1;j++){
            printf(" *");
        }
       printf("\n");
    }
    return 0;

}