//56. Write a program to implement a node structure for singly linked list. Read the 
// data in a node, print the node. 

#include<stdio.h>
#include<stdlib.h>


typedef struct node{
    int info;
    struct node *link;
} Node;

int main(){

    int val;
    Node *newNode = (Node*) malloc(sizeof(Node));

    printf("Enter a Value oF Node Data:");
    scanf("%d",&val);

    newNode->info = val;
    newNode->link = NULL;

    printf("%d",newNode->info);

    free(newNode);

    return 0;
}