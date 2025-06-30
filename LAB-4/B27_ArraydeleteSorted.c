
//7. Write a program to delete a number from an array that is already sorted in an 
//ascending order. 


#include <stdio.h>

int main()
{
  int n,val;

  printf("Enter size of sorted array: ");
  scanf("%d", &n);

  int arr[n];

  printf("Enter %d elements in ascending order:\n", n);
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &arr[i]);
  }

  printf("Enter number to Delete: ");
  scanf("%d", &val);

  int p;

  for (int i = 0; i < n; i++)
  {
    if (arr[i] == val)
    {
      p = i;
      break;
    }
  }

  for (int i = p; i < n-1; i++)
  {
    arr[i] = arr[i+1];
  }

  n--;

  printf("Array after Deletion:\n");
  for (int i = 0; i < n; i++)
  {
    printf("%d ", arr[i]);
  }

  return 0;
}
