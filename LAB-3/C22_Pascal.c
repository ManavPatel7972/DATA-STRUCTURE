// . WAP to print Pascal triangle.

#include<stdio.h>
int main(){
    int r;

    printf("Enter a row:");
    scanf("%d",&r);

    int arr[r][r];

    for(int i=1;i<=r;i++){
        for(int space=1;space<=i-1;space++){
            printf(" ");
        }
        for(int j=1;j<=i+1;j++){
            if(j == 1 || j == i){
                printf("1");
            } 
            else{
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                printf("%d ",arr[i][j]);
            }
            
        }
        printf("\n");
    }

    return 0;
}