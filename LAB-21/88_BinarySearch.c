// 88. Write a program to implement a Binary Search using Array. (Iterative & 
// recursive)

#include<stdlib.h>
#include<stdio.h>

int arr[10];

int search(int arr[], int start, int end,int key){
    
    if(start > end){
        return -1;
    }

    int mid = (start + end)/2;

    if(arr[mid] == key) return mid;
    if(arr[mid] < key) return search(arr,mid+1,end,key);
    if(arr[mid] > key) return search(arr,start,mid-1,key);
} 

int main(){

    int arr[] = {1,2,3,4,5,6,7,8};
    int key = 5;

    printf("Key Index = %d",search(arr,0,7,key));

    return 0;
}