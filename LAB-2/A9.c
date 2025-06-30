#include<stdio.h>

int main(){

    
    int base,expo;

    printf("Enter a base : ");
    scanf("%d",&base);

    printf("Enter a expo:");
    scanf("%d",&expo);

    int ans = 1;

    for(int i=1;i<=expo;i++){
        ans = ans * base;

    }
   printf("Result = %d",ans);
    return 0;

}