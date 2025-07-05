
// 58. WAP to check whether 2 singly linked lists are same or not.

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct node
{
    int info;
    struct node *link;
} Node;

Node *createNode(int x)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->info = x;
    newNode->link = NULL;
    return newNode;
}

int isSame(Node *first1, Node *first2)
{

    int flag = 1;

    Node *temp1 = first1;
    Node *temp2 = first2;

    while (temp1 != NULL && temp2 != NULL)
    {
        if (temp1->info != temp2->info)
        {
            flag = 0;
            break;
        }
        temp1 = temp1->link;
        temp2 = temp2->link;
    }
    return flag;
}

int main()
{

    Node *first1 = createNode(1);
    first1->link = createNode(2);
    first1->link->link = createNode(3);

    Node *first2 = createNode(1);
    first2->link = createNode(2);
    first2->link->link = createNode(2);

    printf("----result---\n");

    if (isSame(first1, first2))
    {
        printf("Liked List are Same.");
    }
    else
    {
        printf("Liked List are Not Same.");
    }

    return 0;
}
