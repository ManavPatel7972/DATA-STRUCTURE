// 77. Write a program to check whether the given tree is symmetric or not.

#include <stdio.h>
#include <stdlib.h>
#include<stdbool.h>

 typedef struct Node{
    int val;
    struct Node *left;
    struct Node *right;
} Node;

Node *root = NULL;


Node *createNode(int val)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->val = val;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

void createTreeHelper(Node *node)
{
    int choice, val;

    printf("left of %d (Yes -> 1)(No -> 0) : ", node->val);
    scanf("%d", &choice);

    if (choice == 1)
    {
        printf("Enter the value of the left of %d : ", node->val);
        scanf("%d", &val);

        node->left = createNode(val);
        createTreeHelper(node->left);
    }

    printf("right of %d (Yes -> 1)(No -> 0) : ", node->val);
    scanf("%d", &choice);

    if (choice == 1)
    {
        printf("Enter the value of the right of %d : ", node->val);
        scanf("%d", &val);

        node->right = createNode(val);
        createTreeHelper(node->right);
    }
}

Node *createTree()
{
    int val;
    printf("Enter a Root Node : ");
    scanf("%d", &val);

    root = createNode(val);
    createTreeHelper(root);

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

bool issymmetric(Node *root1, Node* root2){
    if(root1 == NULL && root2 == NULL) return true;
    if(root1 == NULL || root2 == NULL) return false;

    if(root1->val != root2->val) return false;

    return issymmetric(root1->left,root2->right);
} 

int main(void)
{    

    printf("Enter a Tree \n");
    root = createTree();

    printf("\n");
    printf("\n");
    displayPretty(root, 0);

    printf("Is Symmetric = %d",issymmetric(root,root));


    return 0;
}