// 66. Write a program to sort elements of a linked list.
#include <stdio.h>
#include <stdlib.h>

typedef struct struct ListNode
{
    int info;
    struct struct ListNode *link;
} struct ListNode;

struct ListNode *first = NULL;
int size = 0;

struct ListNode *createstruct ListNode(int x)
{

    struct ListNode *newstruct ListNode = (struct ListNode *)malloc(sizeof(struct ListNode));
    newstruct ListNode->info = x;
    newstruct ListNode->link = NULL;
    size++;

    return newstruct ListNode;
}

void display()
{
    if (first == NULL)
    {
        printf("List Is Empty.....");
        return;
    }

    struct ListNode *temp = first;

    printf("\nLinked List :\n");

    while (temp != NULL)
    {
        printf("%d ", temp->info);
        temp = temp->link;
    }
    printf("\n");
}

struct ListNode *sort(struct ListNode *head)
{

    struct ListNode *curr = head;
    struct ListNode *temp = curr->link;

    while(curr!=NULL){

        temp = curr->link;

        while(temp!=NULL){

            if(curr->info > temp->info){

                int t = curr->info;
                curr->info = temp->info;
                temp->info = t;

            }

            temp = temp->link;
        }

        curr = curr->link;
    }

    return head;

}

int main()
{

    first = createstruct ListNode(-28);
    first->link = createstruct ListNode(40);
    first->link->link = createstruct ListNode(20);
    first->link->link->link = createstruct ListNode(-50);
    first->link->link->link->link = createstruct ListNode(5);
    first->link->link->link->link->link = createstruct ListNode(30);
    first->link->link->link->link->link->link = createstruct ListNode(70);
    first->link->link->link->link->link->link->link = createstruct ListNode(80);

    display();

    display(sort(first));

    return 0;
}