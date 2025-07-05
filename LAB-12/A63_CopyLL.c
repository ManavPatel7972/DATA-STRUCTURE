//63. Write a program to copy a linked list. 

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

Node* copyLL(){

    if(first == NULL){
        printf("List is Empty");
        return NULL;
    }

    Node *temp = first;
    Node *newHead = createNode(temp->info);
    Node *temp2 = newHead;
    temp = temp->link;

    while(temp!=NULL){
        Node *newNode = createNode(temp->info);
        temp2->link = newNode;
        temp2 = newNode;
        temp = temp->link;
    }
    return newHead;
}


void display()
{
    if (first == NULL)
    {
        printf("List Is Empty.....");
        return;
    }

    Node *temp = first;

    printf("\nLinked List :\n");

    while (temp != NULL)
    {
        printf("%d ", temp->info);
        temp = temp->link;
    }
    printf("\n");
}

void display2(Node *newHead){
    Node *temp = newHead;
    while(temp!=NULL){
        printf("%d ",temp->info);
        temp = temp->link;
    }
}

int main()
{

    first = createNode(1);
    first->link = createNode(1);
    first->link->link = createNode(6);
    first->link->link->link = createNode(13);
    first->link->link->link->link = createNode(13);
    first->link->link->link->link->link = createNode(13);
    first->link->link->link->link->link->link = createNode(27);
    first->link->link->link->link->link->link->link = createNode(27);

    display();
    printf("\nAfter Copy...\n");
    display2(copyLL());

    return 0;
}