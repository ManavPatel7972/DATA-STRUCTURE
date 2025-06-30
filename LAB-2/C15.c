#include<stdio.h>
#include<math.h>

int main(){

    int n;
    printf("Enter a number:");
    scanf("%d",&n);

    int ori = n;
    int sum = 0;
    int digit;

    int count=0;
    while(n!=0){
        n=n/10;
        count++;
    }
    

    while(ori!=0){
        digit = ori % 10;
        sum = sum + pow(digit,count);
        ori = ori/10;
       
    }

    printf(" sum = %d ",sum);

}