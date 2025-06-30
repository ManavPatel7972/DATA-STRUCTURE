// 24. Write a program to insert a number at a given location in an array.

#include <stdio.h>

int main()
{

  int n, p, val;
  printf("Enter a Size Of Array:");
  scanf("%d",&n);

  int arr[n + 1];

  for (int i = 0; i < n; i++)
  {
    printf("Enter a %d ", i + 1);
    scanf("%d", &arr[i]);
  }

  printf("Enter a Position to Enter a Ele:\n");
  scanf("%d", &p);

  if(p<0 || p>n){
    printf("Invalid Position!!!");
    return -1;
  }

  printf("Enter a Value to Enter At Position %d\n", p);
  scanf("%d", &val);

  for (int i = n; i > p; i--)
  {
    arr[i] = arr[i - 1];
  }

  arr[p] = val;
  n++;

  for (int i = 0; i < n; i++)
  {
    printf("%d ", arr[i]);
  }

  return 0;
}