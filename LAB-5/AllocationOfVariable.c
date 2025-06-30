#include<stdio.h>
#include<stdlib.h>
 void main() {
  int *iptr;
  char *cptr;
  float *fptr;

  iptr = (int *)malloc(sizeof(int));
  cptr = (int *)malloc(sizeof(char));
  fptr = (int *)malloc(sizeof(float));

  if(iptr && cptr && fptr) {
    *iptr = 20;
    *cptr = 'R';
    *fptr = 11.11;

    printf("%d ",*iptr);
    printf("%c ",*cptr);
    printf("%f ",*fptr);
    free(iptr);
    free(cptr);
    free(fptr);

    printf("Memory free");
  }
  else {
    printf("Wrong memory allocation");
  }
 }