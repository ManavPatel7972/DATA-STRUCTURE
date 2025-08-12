#include<stdio.h>
#include<stdlib.h>


int stack[20];
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

void fun(){
    int n;
    printf("Enter n:");
    scanf("%d",&n);

    int a[n];
    int b[n];
    int k = 0;

    printf("Enter a Arr ELE:");
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }

    for(int i=0;i<n;){
        while(a[i] < a[i+1]){
            b[k++] = a[i];
            i++;
        }
        while(a[i] > a[i+1]){
            push(a[i]);
            i++;
        }
        while(peek() < a[i]){
            b[k++] = pop();
            i++;
        }
    }

    if (top==-1){
        printf("True");
    }
    else{
        printf("top = %d",top);
        printf("False");
    }
    


}

int main(){

    fun();

    return 0;

}