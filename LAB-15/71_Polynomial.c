
// 71. Write a program to perform addition of two polynomial equations using
// appropriate data structure

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int info;
    struct node *link;
} Node;

Node *first = NULL;
Node *second = NULL;

Node *createNode(int x) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->info = x;
    newNode->link = NULL;
    return newNode;
}

void display(Node *head) {
    if (head == NULL) {
        printf("List is Empty...\n");
        return;
    }

    Node *temp = head;
    printf("Polynomial:\n");

    int power = 0;
    while (temp != NULL) {
        printf("%dx^%d", temp->info, power);
        temp = temp->link;
        power++;
        if (temp != NULL) {
            printf(" + ");
        }
    }
    printf("\n");
}

Node * reverse(Node * first){

    if(first == NULL){
        printf("List is Empty....");
        return NULL;
    }

    Node *curr = first;
    Node *next = NULL;
    Node *prev = NULL;

    while(curr!=NULL){
        next = curr->link;
        curr->link = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

Node* sumOfPolinimial(Node *head1, Node *head2) {
    Node *t1 = head1;
    Node *t2 = head2;
    Node *newHead = NULL;
    Node *p = NULL;

    while (t1 != NULL || t2 != NULL) {

        int v1 = (t1 != NULL) ? t1->info : 0;
        int v2 = (t2 != NULL) ? t2->info : 0;

        int sum = v1 + v2;

        Node *newNode = createNode(sum);

        if (newHead == NULL) {
            newHead = newNode;
            p = newHead;
        } else {
            p->link = newNode;
            p = newNode;
        }

        if (t1 != NULL) t1 = t1->link;
        if (t2 != NULL) t2 = t2->link;
    }

    return newHead;
}

int main() {
    first = createNode(1);
    first->link = createNode(1);
    first->link->link = createNode(6);
    first->link->link->link = createNode(13);

    second = createNode(2);
    second->link = createNode(10);
    second->link->link = createNode(1);

    printf("First Polynomial:\n");
    display(first);

    printf("Second Polynomial:\n");
    display(second);

    printf("Sum of Polynomials:\n");
    display(sumOfPolinimial(first, second));

    return 0;
}
