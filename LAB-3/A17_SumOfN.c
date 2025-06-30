//  Write a program to calculate sum of numbers from m to n.

#include <stdio.h>
int main()
{
    int n;
    int m;
    int size;

    printf("Enter a size:");
    scanf("%d", &size);

    printf("Enter a first:");
    scanf("%d", &m);

    printf("Enter a Last:");
    scanf("%d", &n);

    int sum = 0;
    int arr[size];

    for (int i = 0; i < size; i++)
    {
        printf("Enter a %d ", i + 1);
        scanf("%d", &arr[i]);
    }

    for (int i = m; i <= n; i++)
    {
        sum = sum + arr[i];
    }

    printf("Sum = %d", sum);

    return 0;
}