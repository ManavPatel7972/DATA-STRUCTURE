#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

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


Node * reverseLL(Node *first){
    Node *curr = first;
    Node *prev = NULL;
    Node *next = NULL;

    if(first == NULL){
        printf("List is Empty...");
        return NULL;
    }

    while(curr!=NULL){
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}


bool isPalindrome(Node *head)
{
    Node *t1 = head;
    Node *t2 = head;

    if(head == NULL){
        return true;
    }
    
    Node *newHead = createNode(t1->val);
    t1 = t1->next;

    t2 = newHead;

    while(t1!=NULL){
        Node *newNode = createNode(t1->val);
        t2->next = newNode;
        t2 = t2->next;
        t1 = t1->next;
    }

    t2->next = NULL;

    t1 = head;
    t2 = newHead;

    Node *rev = reverseLL(t2);

    while(t1!=NULL && rev != NULL){
        if(t1->val != rev->val){
            return false;
        }
    }

    return true;
}

int main()
{

    first = createNode(1);
    first->next = createNode(2);
    first->next->next = createNode(2);
    first->next->next->next = createNode(1);

    printf("hello");

    if(isPalindrome(first)){
        printf("Palindrome\n");
    }
    else
    {
        printf("Not Palindrome\n");
    }
    

    return 0;
}