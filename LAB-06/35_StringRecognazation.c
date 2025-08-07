// 35. How stack can be used to recognize strings aca, bcb, abcba, abbcbba? Write a
// program to solve the above problem.

#include <stdio.h>
#define SIZE 100

char stack[SIZE];
int top = -1;

void push(char ch)
{
    stack[++top] = ch;
}

char pop()
{
    return stack[top--];
}

int main()
{
    char c[SIZE];
    printf("Enter a String:\n");
    scanf("%s", c);

    int i = 0;


    while (c[i] != 'c' && c[i] != '\0')
    {
        push(c[i]);
        i++;
    }

    if (c[i] == 'c')
    {
        i++;
    }

    while (c[i] != '\0')
    {
        if (pop() != c[i])
        {
            printf("Invalid\n");
            return 0;
        }
        i++; 
    }

    if (top == -1)
        printf("Valid\n");
    else
        printf("Invalid\n");

    return 0;
}

