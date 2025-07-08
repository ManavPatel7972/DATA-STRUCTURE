// 73. WAP to delete alternate nodes of a doubly linked list.
#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int info;
    struct node *lptr;
    struct node *rptr;
} Node;

Node *first = NULL;
Node *last = NULL;
int size = 0;

Node *createNode(int x)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->info = x;
    newNode->lptr = NULL;
    newNode->rptr = NULL;

    return newNode;
}

void createList(int x)
{

    Node *newNode = createNode(x);

    if (first == NULL)
    {

        first = newNode;
        last = newNode;
        // size++;
        return;
    }

    last->rptr = newNode;
    newNode->lptr = last;
    last = newNode;
    // size++;
    return;
}

void display(Node *first)
{

    if (first == NULL)
    {
        printf("\nList Is Empty...\n");
        return;
    }

    Node *temp = first;

    printf("\nList Is....\n");

    while (temp != NULL)
    {
        printf("%d ", temp->info);
        temp = temp->rptr;
    }
    printf("\n\n");
}

Node *deleteAlterNode(Node *first){

    if(first == NULL || first->rptr == NULL){
        printf("List Is Empty Or Only One Ele ...!");
        return first;
    }

    Node *temp = first;

    while(temp!=NULL && temp->rptr != NULL){

        temp->rptr = temp->rptr->rptr;
        temp = temp->rptr;

        if(temp!=NULL){
            temp->lptr = temp->lptr->lptr;
        }
    }

    return first;
}

int main()
{

    createList(10);
    createList(20);
    createList(30);
    createList(40);
    createList(50);

    display(first);

    display(deleteAlterNode(first));

    return 0;
}