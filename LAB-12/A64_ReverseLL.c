//64. Write a program to reverse a linked list. 

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

Node * reverse(){

    if(first == NULL){
        printf("List is Empty....");
        return NULL;
    }

    Node *curr = first;
    Node *next = NULL;
    Node *prev = NULL;

    while(curr!=NULL){
        next = curr->link;
        curr->link = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

int main(){

    first = createNode(10);
    first->link = createNode(20);
    first->link->link = createNode(30);
    first->link->link->link = createNode(40);
    first->link->link->link->link = createNode(60);
    first->link->link->link->link->link = createNode(70);
    first->link->link->link->link->link->link = createNode(80);
    first->link->link->link->link->link->link->link = createNode(90);

    display();


    first = reverse();

    display();

    return 0;

}