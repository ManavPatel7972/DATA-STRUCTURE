// 80. WAP to find the smallest and largest elements in the Binary Search Tree. 

#include <stdio.h>
#include <stdlib.h>
#include<stdbool.h>
#include<math.h>


typedef struct Node {
    int val;
    struct Node * left;
    struct Node* right;
} Node;

Node *root = NULL;


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

Node *small(Node *root){

    if(root->left == NULL) return root;
    
    small(root->left);
}

Node *large(Node *root){

    if(root->right == NULL) return root;

    large(root->right);
}

 int main(void){   

    

    return 0;
}