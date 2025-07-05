// 59. Write a program to remove the duplicates nodes from given sorted Linked List.
// • Input: 1 → 1 → 6 → 13 → 13 → 13 → 27 → 27
// • Output: 1 → 6 → 13 → 27

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

void removeDuplicate()
{
    Node *temp = first;

    while (temp != NULL && temp->link != NULL)
    {
        if (temp->info == temp->link->info)
        {
            Node *dup = temp->link;
            temp->link = temp->link->link;
            free(dup);
        }
        else
        {
            temp = temp->link;
        }
    }
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
    first = createNode(1);
    first->link = createNode(1);
    first->link->link = createNode(6);
    first->link->link->link = createNode(13);
    first->link->link->link->link = createNode(13);
    first->link->link->link->link->link = createNode(13);
    first->link->link->link->link->link->link = createNode(27);
    first->link->link->link->link->link->link->link = createNode(27);

    display();

    removeDuplicate();

    display();

    return 0;
}