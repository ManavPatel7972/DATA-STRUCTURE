// . Write a program to calculate average of first n numbers. 

#include<stdio.h>
int main(){
    int n;
    printf("Enter a Size:");
    scanf("%d",&n);

    int arr[n];
    int count = 0;
    int sum = 0;

    for(int i=0;i<n;i++){
        printf("Enter a %d ",i+1);
        scanf("%d",&arr[i]);

    }

    for(int i=0;i<n;i++){
        sum = sum + arr[i];
        count++;
    }

    float avg = (float) sum / count;
    
    printf("Average = %f",avg);

    return 0;
}