// Write a program to insert a number in an array that is already sorted in an
// ascending order.

#include <stdio.h>
#include<stdlib.h>


int main()
{
  int n, val;

  printf("Enter size of sorted array: ");
  scanf("%d", &n);

  int arr[n + 1];

  printf("Enter %d elements in ascending order:\n", n);
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &arr[i]);
  }

  printf("Enter number to insert: ");
  scanf("%d", &val);

  int p;

  for (int i = 0; i < n - 1; i++)
  {
    if (arr[i] < val && arr[i + 1] > val)
    {
      p = i + 1;
      break;
    }
  }

  for (int i = n; i > p; i--)
  {
    arr[i] = arr[i - 1];
  }

  arr[p] = val;
  n++;

  printf("Array after insertion:\n");
  for (int i = 0; i < n; i++)
  {
    printf("%d ", arr[i]);
  }

  return 0;
}
