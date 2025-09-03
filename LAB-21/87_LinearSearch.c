// 87. Write a program to implement a Linear Search using Array. #include<stdio.h>

#include<stdlib.h>
#include<stdio.h>

int arr[10];

int search(int arr[], int key){
    
    for(int i=0;i<10;i++){
        if(key == arr[i]){
            return i;
        }
    }
    return -1;
} 

int main(){

    int arr[] = {14,92,33,12,64,75};
    int key = 12;

    printf("Key Index = %d",search(arr,key));

    return 0;
}