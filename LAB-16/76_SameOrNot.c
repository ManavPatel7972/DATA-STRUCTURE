// 76. Write a program to check whether the given two trees are same or not. 

#include <stdio.h>
#include <stdlib.h>
#include<stdbool.h>

typedef struct Node {
    int val;
    struct Node * left;
    struct Node* right;
} Node;

Node *root1 = NULL;
Node *root2 = NULL;


Node* createNode(int x) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->val = x;
    newNode->left = newNode->right = NULL;
    return newNode;
}

Node* insert(Node* root, int x) {
    if (root == NULL) return createNode(x);
    if (x < root->val) root->left = insert(root->left, x);
    else if (x > root->val) root->right = insert(root->right, x);
    return root;
}

void display(Node *node)
{
    if (!node) return;

    printf("%d ", node->val);
    display(node->left);
    display(node->right);
}


void displayPretty(Node *node, int level)
{
    if (!node) return;

    displayPretty(node->right, level + 1);

    if (level != 0)
    {
        for (int i = 0; i < level - 1; ++i)
        {
            printf("|\t");
        }

        printf("|------->%d\n", node->val);
    }
    else
    {
        printf("%d\n", node->val);
    }

    displayPretty(node->left, level + 1);
}

bool isSame(Node *root1 , Node *root2){
    if(root1 == NULL && root2 == NULL) return true;
    if(root1 == NULL || root2 == NULL) return false;

    if(root1->val != root2->val) return false;

    return isSame(root1->left,root2->left) && isSame(root1->right,root2->right);
}





 int main(void)
{    
    int arr[] = {3,2,4,1};
    int n = (int)sizeof(arr)/sizeof(arr[0]);
    
    for(int i=0;i<n;i++){
        root1 = insert(root1,arr[i]);
    }

    for(int i=0;i<n;i++){
        root2 = insert(root1,arr[i]);
    }

    printf("\n");
    printf("\n");
    displayPretty(root1, 0);

   printf(isSame(root1,root2) ? printf(" Is same = True") : printf(" Is same = False"));

    return 0;
}