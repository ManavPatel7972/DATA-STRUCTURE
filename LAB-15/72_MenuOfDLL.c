// 72. Write a menu driven program to implement following operations on the doubly
// linked list.
// • Insert a node at the front of the linked list.
// • Delete a node from specified position.
// • Insert a node at the end of the linked list. (Home Work)
// • Display all nodes. (Home Work)

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

    // Node *temp = first;

    // while (temp != last)
    // {
    //     temp = temp->rptr;
    // }

    last->rptr = newNode;
    newNode->lptr = last;
    last = newNode;
    // size++;
    return;
}

void display(Node *first)
{

    if(first == NULL){
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

void insertAtFirst()
{
    int x;
    printf("Enter a Value:");
    scanf("%d", &x);

    Node *newNode = createNode(x);
    if (first == NULL)
    {
        first = newNode;
        last = newNode;
        size++;
        return;
    }
    newNode->rptr = first;
    first->lptr = newNode;
    first = newNode;
    size++;
}

void deleteAtindex()
{
    int idx;
    printf("Enter a Index to Delete a Node:");
    scanf("%d", &idx);

    if (first == NULL)
    {
        printf("Doubly Linked List Is Empty..");
        return;
    }

    if (idx < 0 || idx >= size)
    {
        printf("Invalid Index !!");
        return;
    }

    if (idx == 0)
    { // for First

        Node *temp = first;

        if(first == last){
            first = NULL;
            last = NULL;
            free(temp);
            size--;
            return;
        }

        first = first->rptr;
        first->lptr = NULL;
        temp->rptr = NULL;
        free(temp);
        size--;
        return;
    }

    if (idx == size - 1)
    { // for Last

        Node *temp = last;

         if(first == last){
            deleteAtindex();
            return;
        }

        last = last->lptr;
        last->rptr = NULL;
        temp->lptr = NULL;
        free(temp);
        size--;
        return;
    }

    Node *temp = first;

    for (int i = 1; i < idx; i++)
    {
        temp = temp->rptr;
    }

    temp->rptr = temp->rptr->rptr; 
    temp = temp->rptr;

    temp->lptr = temp->lptr->lptr;
    size--;

    return;
}

void insertAtEnd(){

    if(first == NULL){
        insertAtFirst();
        return;
    }

    int x;
    printf("Enter a Value:");
    scanf("%d", &x);

    Node *newNode = createNode(x);

    last->rptr = newNode;
    newNode->lptr = last;
    last = newNode;
    last->rptr = NULL;
    size++;
    return;
}

int main()
{

    // createList(10);
    // createList(20);
    // createList(30);
    // createList(40);
    // createList(50);



    int temp = 1;
    while (temp)
    {
        int choice;
        printf("\n\nSelect Menu...\n\n");
        printf("1.insertAtFirst \n 2.DeleteAtIndex \n 3.InsertAtEnd \n 4.Display\n 5.Count\n 6.Exist");

        scanf("\n%d", &choice);

        switch (choice)
        {
        case 1:
            insertAtFirst();
            break;

        case 2:
            deleteAtindex();
            break;

        case 3:
            insertAtEnd();
            break;
        case 4:
            display(first);
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