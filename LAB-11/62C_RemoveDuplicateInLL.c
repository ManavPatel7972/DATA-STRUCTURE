// 62. WAP to remove duplicate elements from a singly linked list.

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

void removeDuplicate()
{

    if (first == NULL)
    {
        printf("List is Empty....");
        return;
    }

    Node *temp = first;
    Node *prev = first;
    Node *next = first->link;

    while (temp != NULL)
    {
        
        next = temp->link;
        prev = temp;
        
        while (next != NULL)
        {

            if (temp->info == next->info)
            {
                next = next->link;
                prev->link = next;
            }

            else

            {
                prev = next;
                next = next->link;
            }

            if (prev != NULL && prev->link != NULL)
            {

                if (prev->link->info != temp->info)
                {
                    prev = next;
                    next = next->link;
                }
                else
                {
                    prev->link = next->link;
                    next = next->link;
                }
            }
        }

        temp = temp->link;

    }
}

int main()
{

    first = createNode(1);
    first->link = createNode(1);
    first->link->link = createNode(1);
    first->link->link->link = createNode(4);
    first->link->link->link->link = createNode(10);
    first->link->link->link->link->link = createNode(4);
    first->link->link->link->link->link->link = createNode(1);
    first->link->link->link->link->link->link->link = createNode(40);

    display();

    removeDuplicate();

    display();

    return 0;
}