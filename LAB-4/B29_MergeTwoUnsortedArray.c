// 29. Write a program to merge two unsorted arrays.

#include <stdio.h>
#include <stdlib.h>

int main()
{

    int n1,n2;

    printf("Enter a Array1 Size");
    scanf("%d", &n1);

    int arr1[n1];

    printf("Enter a Array Ele:");
    for (int i = 0; i < n1; i++)
    {
        scanf("%d", &arr1[i]);
    }

    printf("Enter a Array2 Size");
    scanf("%d", &n2);

    int arr2[n2];

    printf("Enter a Array Ele:");
    for (int i = 0; i < n2; i++)
    {
        scanf("%d", &arr2[i]);
    }

    int n = n1+n2;

    int arr[n];
    int idx = 0;

    for(int i=0;i<n1;i++){
        arr[idx] = arr1[i];
        idx++;
    }
    for(int i=0;i<n2;i++){
        arr[idx] = arr2[i];
        idx++;
    }

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }


    return 0;
}