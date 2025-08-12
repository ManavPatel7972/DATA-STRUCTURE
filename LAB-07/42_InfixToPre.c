#include<stdio.h>
#include<string.h>

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
    else return 0;
}

void reverse(char *infix){
    char infixCopy[100];
    strcpy(infixCopy,infix);

    char revInfix[100];
    int k = 0;

    for(int i = strlen(infixCopy)-1 ; i>=0 ;i--){
        if(infixCopy[i] == '(') revInfix[k++] = ')';
        else if(infixCopy[i] == ')') revInfix[k++] = '(';
        else{
            revInfix[k++] = infixCopy[i]; 
        }
    }

    strcpy(infix,revInfix);
    return;
}

void infixToPrefix(){
    char infix[100];
    char prefix[100];
    int k = 0;
    
    printf("Enter a Infix Expresion:\n");
    scanf("%s",infix);

    reverse(infix);
    // printf("%s",infix);

    for (int i = 0; i < strlen(infix); i++) {
        char ch = infix[i];

        if (isdigit(ch)) {
            prefix[k++] = ch;
        } else if (ch == '(') {
            pushOp(ch);
        } else if (ch == ')') {
            while (opTop != -1 && peekOp() != '(') {
                prefix[k++] = popOp();
            }
            popOp(); // pop '('
        } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            while (opTop != -1 && precedence(peekOp()) > precedence(ch)) {
                prefix[k++] = popOp();
            }
            pushOp(ch);
        }
    }

    while (opTop != -1) {
        prefix[k++] = popOp();
    }

    prefix[k] = '\0';

    reverse(prefix);

    printf("Prefix Expression = %s\n", prefix);
}

int main(){
    //9-(5+3)*4/6;
    infixToPrefix();
    return 0;
}