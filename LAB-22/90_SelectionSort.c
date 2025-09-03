// 90. Write a program to implement Selection Sort using Array.

#include <stdio.h>
#include<stdlib.h>

void selectionSort(int arr[], int n){
    
    for(int i=0;i<n-1;i++){
        int min = i;

        for(int j=i;j<n;j++){
            if(arr[j] < arr[min]){
                min = j;
            }
        }

        //swap
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }    
}

void printArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main(){
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: \n");
    printArray(arr, n);

    selectionSort(arr, n);

    printf("Sorted array: \n");
    printArray(arr, n);

    return 0;
}
