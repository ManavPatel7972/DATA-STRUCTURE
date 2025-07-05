// WAP to perform given operation in the linked list. There exist a Linked List. Add
// a node that contains the GCD of that two nodes between every pair adjacent
// node of Linked List.

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
    printf("\n");
}

int gcdOfTwoNumber(int n1, int n2)
{
    int gcd = 1;

    int min = (n1 < n2) ? n1 : n2;

    for (int i = 1; i <= min; i++)
    {
        if (n1 % i == 0 && n2 % i == 0)
        {
            gcd = i;
        }
    }

    return gcd;
}

Node *addNodeGCD(Node *head)
{

    Node *t1 = head;
    Node *t2 = head->link;

    if (head == NULL || head->link == NULL)
    {
        return head;
    }

    while (t2 != NULL)
    {

        int n1 = t1->info;
        int n2 = t2->info;

        int gcd = gcdOfTwoNumber(n1, n2);

        Node *newNode = createNode(gcd);

        newNode->link = t2;
        t1->link = newNode;

        t1 = t2;
        t2 = t2->link;
    }

    return head;
}

int main()
{

    first = createNode(18);
    first->link = createNode(6);
    first->link->link = createNode(10);
    first->link->link->link = createNode(3);
    // first->link->link->link->link = createNode(9);
    // first->link->link->link->link->link = createNode(30);
    // first->link->link->link->link->link->link = createNode(70);
    // first->link->link->link->link->link->link->link = createNode(80);

    display();

    printf(" gcd = %d \n", gcdOfTwoNumber(18, 6));

    display(addNodeGCD(first));

    return 0;
}