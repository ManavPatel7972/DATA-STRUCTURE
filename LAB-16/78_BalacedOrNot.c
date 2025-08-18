// 78. Given a binary tree, determine if it is height-balanced (A height-balanced binary 
// tree is a binary tree in which the depth of the two subtrees of every node never 
// differs by more than one). 

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

int height(Node* root){
    if(root == NULL) return 0;
    return 1 + fmax(height(root->left),height(root->right));
}

bool isBalanced(Node *root){
    if(root == NULL) return true;

    int lh = height(root->left);
    int rh = height(root->right);

    return (abs(lh-rh)<=1) && isBalanced(root->left) && isBalanced(root->right);
}

 int main(void)
{    
    // int arr[] = {3,9,20,15,7};
    // int n = (int)sizeof(arr)/sizeof(arr[0]);
    
    // for(int i=0;i<n;i++){
    //     root = insert(root,arr[i]);
    // }

    Node* root=createNode(20);
    root->left=createNode(10);
    root->right=createNode(30);


    printf("\n");
    printf("\n");
    displayPretty(root, 0);

    printf("Is Balanced = %d",isBalanced(root));

    return 0;
}