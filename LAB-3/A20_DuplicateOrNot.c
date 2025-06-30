//  Write a program to find whether the array contains a duplicate number or not. 

#include<stdio.h>
#include<stdbool.h>

bool isDuplicate(int arr[],int n){

    for(int i=0;i<n;i++){
        for(int j = i+1;j<n;j++){
            if(arr[i] == arr[j]){
                return true;
            }
        }
    }
    return false;
}
 
int main(){
    int n;
    printf("Enter a Size:");
    scanf("%d",&n);

    int arr[n];

    for(int i=0;i<n;i++){
        printf("Enter a %d ",i+1);
        scanf("%d",&arr[i]);
    }

    if(isDuplicate(arr,n)){
        printf("Arr contains duplicate");
    }
    else{
          printf("Arr does not contains duplicate");
    }

    
    return 0;
}