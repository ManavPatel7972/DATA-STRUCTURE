#include <stdio.h>
#include <string.h>
#include <ctype.h>

char opStack[100];
int opTop = -1;

void pushOp(char ch) {
    opStack[++opTop] = ch;
}

char popOp() {
    return opStack[opTop--];
}

char peekOp() {
    return opStack[opTop];
}


int precedence(char op) {
    if (op == '+' || op == '-') return 1;
    else if (op == '*' || op == '/') return 2;
    else if(op == '^') return 3;
    else return 0;
}

void infixToPostfix() {
    char infix[100];
    char postfix[100];
    int k = 0;

    printf("Enter an Infix Expression:\n");
    scanf("%s", infix);

    for (int i = 0; i < strlen(infix); i++) {
        char ch = infix[i];

        if (isdigit(ch)) {
            postfix[k++] = ch;
        } else if (ch == '(' || peekOp() == '(') {
            pushOp(ch);
        } else if (ch == ')') {
            while (opTop != -1 && peekOp() != '(') {
                postfix[k++] = popOp();
            }
            popOp(); // pop '('
        } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            while (opTop != -1 && precedence(peekOp()) >= precedence(ch)) {
                postfix[k++] = popOp();
            }
            pushOp(ch);
        }
    }

    while (opTop != -1) {
        postfix[k++] = popOp();
    }

    postfix[k] = '\0';

    printf("Postfix Expression = %s\n", postfix);
}

int main() {
    infixToPostfix();
    return 0;
}


// -------------------------------------------------

