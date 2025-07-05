// 68. Write a program to swap two consecutive nodes in the linked list. Don’t change
// the values of nodes, implement by changing the link of the nodes.

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
    printf("\n\n");
}

Node *swapConsecutive(Node *head)
{

    if (head == NULL || head->link == NULL)
    {
        return head;
    }

    Node *t1 = head;
    Node *t2 = t1->link;
    Node *t = t2->link;
    Node *newHead = t2;
    Node *p = NULL;

    while (t1 != NULL && t2 != NULL)
    {

        t2->link = t1;
        t1->link = t;

        if (p != NULL)
        {

            p->link = t2;
            
        }

        p = t1;
        t1 = t;

        if (t1 != NULL && t1->link != NULL)
        {
            t2 = t1->link;
            t = t2->link;
        }
        else
        {

            break;
        }
    }

    return newHead;
}

int main()
{

    first = createNode(1);
    first->link = createNode(2);
    first->link->link = createNode(3);
    first->link->link->link = createNode(4);
    first->link->link->link->link = createNode(5);
    first->link->link->link->link->link = createNode(6);
    first->link->link->link->link->link->link = createNode(7);
    first->link->link->link->link->link->link->link = createNode(8);

    display();

    first = swapConsecutive(first);

    display();

    return 0;
}