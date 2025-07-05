//61. Write a program to implement queue using singly linked list. 
#include<stdio.h>
#include<stdlib.h>

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

int pop(){

    if(first == NULL){
        printf("Queue Is Empty...");
        return -1;
    }

    Node *temp = first;
    int x = temp->info;

    first = first->link;
    temp->link = NULL;
    free(temp);

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




int main(){

    push();
    push();
    push();
    printf("\n");

    display();

    printf("\n");

    printf("Pop Ele = %d\n\n",pop());

    display();


    return 0;

}