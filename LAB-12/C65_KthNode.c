// 65. WAP to swap Kth node from beginning with Kth node from end in a singly linked
//  list.

#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int info;
    struct node *link;
} Node;

Node *first = NULL;
int size = 0;

Node *createNode(int x)
{

    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->info = x;
    newNode->link = NULL;
    size++;

    return newNode;
}

void swap()
{
    int k;
    printf("Enter a Kth position OF Node to Swap for Begining and Ending of Node value :");
    scanf("%d", &k);

    Node *ts = first;
    Node *tl = first;

    int lastKth = size - k + 1;    

    if (k < 1 || k > size)
    {
        printf("Invalid Index !!!\n");
        return;
    }

    if (first == NULL)
    {
        printf("List is Empty Not Swaping Possible...\n");
        return;
    }

    if (k == lastKth)
    {
        printf("List Length is ODD and swaping of same Element is Not Possible:\n");
        return;
    }

    for (int i = 1; i < k; i++)
    {
        ts = ts->link;
    }

    for (int i = 1; i < lastKth; i++)
    {
        tl = tl->link;
    }

    int x = ts->info;
    int y = tl->info;

    ts->info = y;
    tl->info = x;
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

int main()
{

    first = createNode(10);
    first->link = createNode(20);
    first->link->link = createNode(30);
    first->link->link->link = createNode(40);
    first->link->link->link->link = createNode(50);
    first->link->link->link->link->link = createNode(60);
    first->link->link->link->link->link->link = createNode(70);
    first->link->link->link->link->link->link->link = createNode(80);

    printf("Size = %d\n\n", size);

    display();
    printf("\n\n");

    swap();

    display();

    return 0;
}