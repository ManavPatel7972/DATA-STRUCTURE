#include<stdio.h>
int main(){
    int n;
    printf("Enter a Number:");
    scanf("%d",&n);

    int i=0;
    while (i<n)
    {

        if(n%i == 0){
            printf("%d",i);
        }
        i++;
    }
    
    printf("end");
}