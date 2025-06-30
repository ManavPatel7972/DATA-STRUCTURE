// 25. Write a program to delete a number from a given location in an array.

#include <stdio.h>

int main()
{

    int n, p;
    printf("Enter a Size Of Array:");
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i < n; i++)
    {
        printf("Enter a %d ", i + 1);
        scanf("%d", &arr[i]);
    }

    printf("Enter a Position to Delete a Ele:\n");
    scanf("%d", &p);

    if (p < 0 || p > n)
    {
        printf("Invalid Position!!!");
        return -1;
    }

    for (int i = p; i < n - 1; i++)
    {
        arr[i] = arr[i + 1];
    }

    n--;

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }

    return 0;
}