#include<stdio.h>
int main(){
    int n;
    printf("Enter a Number:");
    scanf("%d",&n);

    for(int i=2;i<n;i++){
        if(n%i == 0){
            printf("%d ",i);
        }
        
    }
    return 0;
}