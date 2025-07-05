// 60. Write a program to implement stack using singly linked list.

#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int info;
    struct node *link;
} Node;

Node *first = NULL;

Node *createNode(int x)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->info = x;
    newNode->link = NULL;
    return newNode;
}

void push()
{
    int x;
    printf("Enter a Value To Insert:");
    scanf("%d", &x);

    Node *newNode = createNode(x);
    Node *temp = first;

    if (first == NULL)
    {
        first = newNode;
    }
    else
    {
        while (temp->link != NULL)
        {
            temp = temp->link;
        }

        temp->link = newNode;
        temp = temp->link;
    }
}

int peek()
{
    if (first == NULL)
    {
        printf("Stack is Empty...");
        return -1;
    }

    Node *temp = first;

    while (temp->link != NULL)
    {
        temp = temp->link;
    }

    return temp->info;
}

int pop()
{

    if (first == NULL)
    {
        printf("Stack is Empty...");
        return -1;
    }

    Node *temp = first;
    Node *prev = NULL;

    while (temp->link != NULL)
    {
        prev = temp;
        temp = temp->link;
    }

    int x = temp->info;

    free(temp);

    prev->link = NULL;

    return x;
}

void display()
{

    Node *temp = first;

    while (temp != NULL)
    {
        printf("%d ", temp->info);
        temp = temp->link;
    }

    printf("\n");
}

int main()
{
    push();
    push();
    push();

    display();

    printf("\n");
    printf("\n");

    printf("Peek Ele = %d ", peek());

    printf("Pop ELe = %d ", pop());

    printf("\n");

    display();

    push();
    push();
    push();

    printf("Peek Ele = %d \n", peek());

    printf("Pop ELe = %d \n", pop());

    printf("\n");

    display();
}