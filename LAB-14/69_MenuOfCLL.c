// 69. Write a menu driven program to implement following operations on the circular
// linked list.
// • Insert a node at the front of the linked list.
// • Delete a node from specified position.
// • Insert a node at the end of the linked list.
// • Display all nodes.

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

void display()
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

void insertAtFirst()
{
    int x;
    printf("Enter Value:");
    scanf("%d",&x);

    if (first == NULL)
    {
        Node *temp = createNode(x);
        first = temp;
        last = temp;

        last->link = first;

        size++;
        return;
    }

    Node *newNode = createNode(x);

    newNode->link = first;
    last->link = newNode;
    first = newNode;
    size++;
}

void deleteAtIndex()
{                               @@@@@@@ Delete First nathi thatu....

    int idx;
    printf("Enter Index to Delete Node:");
    scanf("%d",&idx);

    Node *temp = first;


    if (first == NULL)
    {
        printf("List is Empty..");
        return;
    }
    if (idx < 0 || idx >= size)
    {
        printf("Invalid Index !!");
        return;
    }

    if (idx == size - 1) // for last Node
    {
        for (int i = 1; i < idx; i++)
        {
            temp = temp->link;
        }

        temp->link = first;
        size--;
        return;
    }

    if (idx == 0)
    { // for first Node
        Node *temp = first;
        last->link = first->link;
        first = first->link;

        temp->link = NULL;

        free(temp);
        size--;
        return;
    }

    for (int i = 1; i < idx; i++)
    {
        temp = temp->link;
    }

    temp->link = temp->link->link;
    size--;
}

void insertAtEnd()
{

    if (first == NULL)
    {
        insertAtFirst();
        return;
    }

    int x;
    printf("Enter Value:");
    scanf("%d",&x);

    Node *newNode = createNode(x);
    newNode->link = first;
    last->link = newNode;
    last = newNode;
    size++;
}

int main()
{

    // createList(1);
    // createList(2);
    // createList(3);
    // createList(4);
    // createList(5);

    int temp = 1;
    while (temp)
    {
        int choice;
        printf("\nSelect Menu...\n");
        printf("1.insertAtFirst \n 2.DeleteAtIndex \n 3.InsertAtEnd \n 4.Display\n 5.Count\n 6.Exist");

        scanf("\n%d", &choice);

        switch (choice)
        {
        case 1:
            insertAtFirst();
            break;

        case 2:
            deleteAtIndex();
            break;

        case 3:
            insertAtEnd();
            break;
        case 4:
            display();
            break;
        case 5:
            printf("Count = %d", size);
            break;
        case 6:
            temp = 0;
            break;

        default:
            printf("Invalid Operation!!!");
            break;
        }

        if (temp == 0)
        {
            printf("Exiting....");
            break;
        }
    }

    return 0;
}