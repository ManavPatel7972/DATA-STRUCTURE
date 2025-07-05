
#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int info;
    struct node *link;
} Node;

Node *first = NULL;
Node *last = NULL;
int size = 0;

Node *createNode(int x)
{

    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->info = x;
    newNode->link = NULL;

    return newNode;
}

void createList(int x)
{

    Node *newNode = createNode(x);

    if (first == NULL)
    {
        first = newNode;
        last = newNode;
        last->link = first;
        size++;
        return;
    }

    newNode->link = first;
    last->link = newNode;
    last = newNode;
    size++;
}

void display(Node *first)
{


    if (first == NULL)
    {
        printf("List Is Empty.....");
        return;
    }

    Node *temp = first;

    printf("\nLinked List :\n");

    do
    {
        printf("%d ", temp->info);
        temp = temp->link;

    } while (temp != first);

    printf("\n");
}

void splitCLL(Node *first)
{

    Node *t1 = first;
    Node *t1Head = first;
    Node *t2 = NULL;
    Node *t2Head = NULL;

    if (first == NULL)
    {
        printf("List is Empty...");
        return;
    }

    if (size % 2 != 0)
    {
        printf("Odd Length of CLL it is Not Posible to Split !!");
        return;
    }

    int n = size / 2;

    for (int i = 1; i < n; i++)
    {
        t1 = t1->link;
    }

    t2 = t1->link;

    t1->link = t1Head;

    
    t2Head = t2;

    while (t2 != last)
    {
        t2 = t2->link;
    }

    t2->link = t2Head;

    display(t1Head);
    display(t2Head);

}

int main()
{

    createList(1);
    createList(2);
    createList(3);
    createList(4);
    createList(5);
    createList(6);
    createList(7);
    createList(8);


    display(first);

    splitCLL(first);



}