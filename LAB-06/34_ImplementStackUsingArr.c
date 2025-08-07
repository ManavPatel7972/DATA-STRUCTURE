// 34. Write a menu driven program to implement following operations on the Stack 
// using an Array 
// • PUSH, POP, DISPLAY 
// • PEEP, CHANGE

#include <stdio.h>
#define SIZE 100 

int stack[SIZE];
int top = -1;  

void push(int value) {
    if (top == SIZE - 1) {
        printf("Stack Overflow! Cannot push %d\n", value);
    } else {
        top++;
        stack[top] = value;
        printf("Pushed %d to stack.\n", value);
    }
}


void pop() {
    if (top == -1) {
        printf("Stack Underflow! Nothing to pop.\n");
    } else {
        printf("Popped %d from stack.\n", stack[top]);
        top--;
    }
}

int peek(){
     if (top == -1) {
        printf("Stack Underflow! Nothing to pop.\n");
    }
    return stack[top];
}


void display() {
    if (top == -1) {
        printf("Stack is empty.\n");
    } else {
        printf("Stack elements (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            printf("%d ", stack[i]);
        }
        printf("\n");
    }
}

int main() {
    int choice, value;

    while (1) {
        printf("\n--- Stack Menu ---\n");
        printf("1. Push\n2. Pop\n3. peek\n4. display\n5. exist");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("Enter value to push: ");
            scanf("%d", &value);
            push(value);
            break;
        case 2:
            pop();
            break;
        case 3:
            printf("Top = %d",peek());
            break;
        case 4:
            display();
            break;
        case 5:
            printf("Exiting program.\n");
            return 0;
        default:
            printf("Invalid choice! Try again.\n");
        }
    }

    return 0;
}
