#include<stdio.h>
int main(){
    int sum = 0;
    int n;

    printf("Enter a Number:");
    scanf("%d",&n);


    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            sum = sum + j;
        }
    }
    printf("%d",sum);
}