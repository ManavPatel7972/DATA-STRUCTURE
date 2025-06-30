#include <stdio.h>
void main()
{
  int r1, c1, i, j;
  printf("Enter the rows & cols of 1st matrix:");
  scanf("%d %d", &r1, &c1);
  int a[r1][c1];
  printf("Enter elements of 1st matrix:");
  for (i = 0; i < r1; i++)
  {
    for (j = 0; j < c1; j++)
    {
      scanf("%d", &a[i][j]);
    }
  }
  printf("Enter the rows & cols of 2nd matrix:");
  scanf("%d %d", &r1, &c1);
  int b[r1][c1];
  printf("Enter elements of 1st matrix:");
  for (i = 0; i < r1; i++)
  {
    for (j = 0; j < c1; j++)
    {
      scanf("%d", &b[i][j]);
    }
  }
  int sum[i][j];
  for (i = 0; i < r1; i++)
  {
    for (j = 0; j < c1; j++)
    {
      sum[i][j] = a[i][j] + b[i][j];
      printf("%d ", sum[i][j]);
    }
    printf("\n");
  }
}
