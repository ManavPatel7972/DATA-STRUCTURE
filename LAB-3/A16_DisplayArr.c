// 16. Write a program to read and display n numbers using an array.

#include<stdio.h>
int main(){
    int n;
    printf("Enter a Size:");
    scanf("%d",&n);

    int arr[n];

    for(int i=0;i<n;i++){
        printf("Enter a ",i+1);
        scanf("%d",&arr[i]);
    }

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }
    
    return 0;
}