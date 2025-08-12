// 43. Write a program for evaluation of postfix Expression using Stack. 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int stack[100];
int top = -1;

void push(int val){
    stack[++top] = val;
}
int pop(){
    return stack[top--];
}
int peek(){
    return stack[top];
}

void preFixEvaluation(){
    char prefix[100];
    printf("Enter a Postfix Expresion:");
    scanf("%s",prefix);
    for(int i=strlen(prefix)-1;i>=0;i--){
        char ch = prefix[i];
        int ascii = (int) ch;

        if(ascii >= 48 && ascii <=57){
            push(ascii - 48);
        }
        else{
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                if(ch == '+') {
                    int v1 = pop();
                    int v2 = pop();
                    push(v1 + v2);
                }
                if(ch == '-') {
                    int v1 = pop();
                    int v2 = pop();
                    push(v1 - v2);
                }
                if(ch == '*') {
                    int v1 = pop();
                    int v2 = pop();
                    push(v1 * v2);
                }
                if(ch == '/') {
                    int v1 = pop();
                    int v2 = pop();
                    push(v1 / v2);
                }
            }
        }
    }

    printf("Ans = %d",pop());
}

int main(){
    preFixEvaluation();
    return 0;
}