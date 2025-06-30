#include <stdio.h>

int fact(int n)
{

    for (int i = 0; i <= n; i++)
    {

        if (n == 0 || n == 1)
        {
            return n;
        }
      return n * fact(n-1);
    }
}
int main()
{
    printf("hello\n");
    printf("result = " + fact(5));
    return 0;
}