// 79. Write a program to construct a binary tree from given Postorder and Preorder 
// traversal sequence. 

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

Node *helper(int pre[], int preS, int preE, int post[], int postS, int postE) {
    if (preS > preE || postS > postE) return NULL;

    Node *node = createNode(pre[preS]);
    if (preS == preE) return node;

    
    int i = postS;
    
    while (post[i] != pre[preS+1]) i++;

    int leftSize = i - postS + 1;

    node->left  = helper(pre, preS+1, preS+leftSize, post, postS, i);
    node->right = helper(pre, preS+leftSize+1, preE, post, i+1, postE-1);

    return node;
}

Node *constructBst(int pre[],int preS,int preE,int post[],int postS,int postE){

    root = helper(pre,preS,preE-1,post,postS,postE-1);
    
    if(root == NULL) return NULL;
    return root;
}

int main(){

    int pre[] = {30,20,10,25,40,35,45};
    int post[] = {10,25,20,35,45,40,30};
    root = constructBst(pre,0, sizeof(pre)/sizeof(pre[0]),post,0,sizeof(post)/sizeof(post[0]));

    displayPretty(root,0);

    return 0;
}


