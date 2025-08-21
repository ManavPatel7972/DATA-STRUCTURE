#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int valStack[100];
char opStack[100];
int valTop = -1, opTop = -1;

void pushVal(int num) {
    valStack[++valTop] = num;
}

int popVal() {
    return valStack[valTop--];
}

int peekVal() {
    return valStack[valTop];
}

void pushOp(char op) {
    opStack[++opTop] = op;
}

char popOp() {
    return opStack[opTop--];
}

char peekOp() {
    return opStack[opTop];
}

int precedence(char op) {
    if(op == '+' || op == '-') return 2;
    else if(op == '*' || op == '/') return 4;   
    else if(op == '^') return 5;
    else if(op == '(') return 0; 
    else return 8;
}

void calculation() {
    int v2 = popVal();
    int v1 = popVal();
    char op = popOp();

    if (op == '+') pushVal(v1 + v2);
    else if (op == '-') pushVal(v1 - v2);
    else if (op == '*') pushVal(v1 * v2);
    else if (op == '/') pushVal(v1 / v2);
}

int main() {
    char str[] = "1+(5*3)";

    for (int i = 0; str[i] != '\0'; i++) {

        char ch = str[i];
        int ascii = (int) ch;

        if (ascii >= 48 && ascii <= 57) {
           pushVal(ascii - 48);
        }

        else if (opTop == -1 || ch == '(' || peekOp() == '(') {
            pushOp(ch);
        } 
        else if (ch == ')') {
            while (peekOp() != '(') {
                calculation();
            }
            popOp(); // Pop '('
        } 
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            while (opTop != -1 && precedence(peekOp()) >= precedence(ch)) {
                calculation();
            }
            pushOp(ch);
        }
    }

    while (opTop != -1) {
        calculation();
    }

    printf("Result: %d\n", peekVal());
    return 0;
}
