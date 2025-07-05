
// 52. WAP to find the largest element in the array using Pointer.

#include <stdio.h>
#include <math.h>
#include <limits.h>

int main()
{
    int n;

    printf("Enter size of the array: ");
    scanf("%d", &n);

    int arr[n];
    int max = INT_MIN;
    int *ptr = arr;

    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", (ptr + i));
    }

    for (int i = 0; i < n; i++)
    {
        if (*(ptr + i) > max)
        {
            max = *(ptr + i);
        }
    }

    printf("Array elements are:\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", *(ptr + i));
    }

    printf("\n MAX = %d", max);

    return 0;
}
