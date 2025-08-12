// 9-(5+3)*4/6
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

// Character Stack
char charStack[100];
int charTop = -1;

void pushOp(char ch)
{
    charStack[++charTop] = ch;
}
char popOp()
{
    return charStack[charTop--];
}
char peekOp()
{
    return charStack[charTop];
}

// Integer Stack
int intStack[100];
int intTop = -1;

void pushVal(int val)
{
    intStack[++intTop] = val;
}
int popVal()
{
    return intStack[intTop--];
}
int peekVal()
{
    return intStack[intTop];
}

void Calculation()
{

    int v2 = popVal();
    int v1 = popVal();
    char op = popOp();

    if (op == '+')
        pushVal(v1 + v2);
    else if (op == '-')
        pushVal(v1 - v2);
    else if (op == '*')
        pushVal(v1 * v2);
    else if (op == '/')
        pushVal(v1 / v2);
}

void infixEvaluation()
{
    char infix[100];
    printf("Enter a Infix String:\n");
    scanf("%s", infix);

    for (int i = 0; i < strlen(infix); i++)
    {
        char ch = infix[i];
        int ascii = (int)ch;

        if (ascii >= 48 && ascii <= 57)
        {
            pushVal(ascii - 48);
        }
        else if (ch == '(' || charTop == -1)
        {
            pushOp(ch);
        }
        else if (ch == ')')
        {
            while (charTop != -1 && peekOp() != '(')
            {
                Calculation();
            }
            popOp();
        }
        else
        {

            if (ch == '+' || ch == '-')
            {
                while (charTop != -1 && peekOp() != '(')
                {
                    Calculation();
                }
                pushOp(ch);
            }

            if (ch == '*' || ch == '/')
            {

                if (peekOp() == '*' || peekOp() == '/')
                {
                    while (charTop != -1 && (peekOp() == '*' || peekOp() == '/'))
                    {
                        Calculation();
                    }
                    pushOp(ch);
                }
                else
                {
                    pushOp(ch);
                }
            }
        }
    }

    while (charTop != -1)
    {
        Calculation();
    }

    printf("Infix Evaluation = %d", popVal());
    return;
}

int main()
{

    infixEvaluation();

    return 0;
}
