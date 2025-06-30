#include<stdio.h>
void main() {
  int r1,c1,r2,c2,i,j,k;
  printf("Enter the rows & cols of 1st matrix:");
  scanf("%d %d",&r1,&c1);
  int a[r1][c1];
  printf("Enter elements of 1st matrix:");
  for(i=0;i<r1;i++) {
    for(j=0;j<c1;j++) {
      scanf("%d",&a[i][j]);
    }
  }
  printf("Enter the rows & cols of 2nd matrix:");
  scanf("%d %d",&r2,&c2);
  int b[r2][c2];
  printf("Enter elements of 1st matrix:");
  for(i=0;i<r2;i++) {
    for(j=0;j<c2;j++) {
      scanf("%d",&b[i][j]);
    }
  }
  int mul[i][j];
  for(i=0;i<r1;i++) {
    for(j=0;j<c2;j++) {
      mul[i][j]=0;
      for(k=0;k<c1;k++) {
        mul[i][j] += a[i][k] * b[k][j];
      }
    }
  }
  for(i=0;i<r1;i++) {
    for(j=0;j<c2;j++) {
      printf("%d ",mul[i][j]);
    }
    printf("\n");
  }
}