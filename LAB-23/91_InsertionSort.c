// 91. Write a program to implement Insertion Sort using Array.

#include <stdio.h>
#include<stdlib.h>

void insertionSort(int arr[],int n){

    for(int i=0;i<n;i++){
        int j = i-1;
        while(j>0 && arr[j-1] > arr[j]){
            //swap
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--; 
        }
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

    insertionSort(arr, n);

    printf("Sorted array: \n");
    printArray(arr, n);

    return 0;
}
