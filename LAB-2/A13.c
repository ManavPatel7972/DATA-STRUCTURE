#include <stdio.h>

int prime(int s, int e)
{
    int i = 2;
    while (s <= e)
    {
        if (s % i == 0)
        {
            printf("%d ", i);
        }
        s++;
        i++;
    }
}
int main()
{
    int s;
    int e;

    printf("Enter a Start:");
    scanf("%d", &s);

    printf("Enter a End:");
    scanf("%d", &e);

    prime(s, e);
}