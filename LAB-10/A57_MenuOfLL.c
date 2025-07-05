// 57. Write a menu driven program to implement following operations on the singly
// linked list.
// • Insert a node at the front of the linked list.
// • Display all nodes.
// • Delete a first node of the linked list.
// • Insert a node at the end of the linked list.
// • Delete a last node of the linked list.
// • Delete a node from specified position.
// • count the number of nodes

#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int info;
    struct node *link;
} Node;

Node *first = NULL;
int count = 0;

void insertAtFirst()
{
    int x;
    printf("Enter a Value:");
    scanf("%d", &x);

    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->info = x;
    newNode->link = first;
    first = newNode;
    count++;
}

void display()
{
    if (first == NULL)
    {
        printf("List Is Empty.....");
        return;
    }

    Node *temp = first;

    printf("\n\n\nLinked List :\n");

    while (temp != NULL)
    {
        printf("%d ", temp->info);
        temp = temp->link;
    }
    printf(" \n\n\n");
}

void deleteFirst()
{
    if (first == NULL)
    {
        printf("List is Empty...");
        return;
    }

    Node *temp = first;

    first = first->link;

    free(temp);
    count--;
}

void insertAtEnd()
{
    int x;
    printf("Enter a Value:");
    scanf("%d", &x);

    Node *newNode = (Node *)malloc(sizeof(Node));

    newNode->info = x;
    newNode->link = NULL;

    if (first == NULL)
    {
        newNode->link = first;
        first = newNode;
        count++;
    }

    else
    {
        Node *temp = first;

        while (temp->link != NULL)
        {
            temp = temp->link;
        }
        temp->link = newNode;
        count++;
        return;
    }
    
}

void deleteLast()
{
    if (first == NULL)
    {
        printf("List is Empty...");
        return;
    }

    Node *temp = first;

    while (temp->link->link != NULL)
    {
        temp = temp->link;
    }
    Node *temp2;
    temp2 = temp->link;

    temp->link = NULL;

    free(temp2);
    count--;
}

void deleteAtIndex()
{
    int index;
    printf("Enter a Index to Delete:");
    scanf("%d",&index);
    if (first == NULL)
    {
        printf("\nList is Empty...\n");
        return;
    }
    if (index < 0 || index >= count)
    {
        printf("\nInvalid Index!!!\n");
        return;
    }
    if(index == 0){
        deleteFirst();
        return;
    }

    Node *temp = first;
    Node *temp2 = NULL;

    for (int i = 1; i < index; i++)
    {
        temp = temp->link;
    }
    temp2 = temp->link;
    temp->link = temp->link->link;
    free(temp2);
    count--;
}

int main()
{
    int temp = 1;
    while (temp)
    {
        int choice;
        printf("\nSelect Menu...\n");
        printf("1.insertAtFirst \n 2.display \n 3.deleteFirst \n 4.insertAtEnd\n 5.Count\n 6.deleteEnd\n 7.deleteAtIndex\n 8.Exist\n");

        scanf("\n%d", &choice);

        switch (choice)
        {
        case 1:
            insertAtFirst();
            break;

        case 2:
            display();
            break;

        case 3:
            deleteFirst();
            break;
        case 4:
            insertAtEnd();
            break;
        case 5:
            printf("Count = %d",count);
            break;
        case 6:
            deleteLast();
            break;
        case 7:
           deleteAtIndex();
            break;
        case 8:
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