#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include<math.h>


typedef struct node
{
    int val;
    struct node *next;
} Node;

Node *first = NULL;

Node *createNode(int x)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->val = x;
    newNode->next = NULL;
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
        printf("%d ", temp->val);
        temp = temp->next;
    }
    printf("\n");
}

int count(Node *node)
{

    int count = 0;

    Node *temp = node;

    while (temp != NULL)
    {
        count++;
        temp = temp->next;
    }
    return count;
}

Node *middle(Node *first)
{

    if (first == NULL)
    {
        return NULL;
    }

    int c = count(first);

    if (c % 2 == 0)
    {

        int m = c / 2;
        Node *t = first;

        for (int i = 1; i <= m; i++)
        {
            t = t->next;
        }

        return t;
    }
    else
    {
        int m = floor(c/2);
         Node *t = first;

        for(int i=1;i<=m;i++){
           t = t->next;
        }
        return t;
    }
}

int main()
{

    first = createNode(1);
    first->next = createNode(2);
    first->next->next = createNode(3);
    first->next->next->next = createNode(4);
    first->next->next->next->next = createNode(5);
    // first->next->next->next->next->next = createNode(6);

    display();

    // first = middle(first);

    printf("\nAfter Find Middle...\n");

    display();


    return 0;
}