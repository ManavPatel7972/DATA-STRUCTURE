#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<limits.h>

typedef struct node{
    int val;
    int height;
    struct node *left;
    struct node *right;
}Node;

Node *root = NULL;

Node *createNode(int x){
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->val = x;
    newNode->height = 1;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

void createTreeHelper(Node *node){
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

Node *createTree(){
    int x;
    printf("Enter a Root : ");
    scanf("%d",&x);
    root = createNode(x);
    createTreeHelper(root);
    return root;
}

void display(Node *node){
    if (!node) return;

    printf("%d ", node->val);
    display(node->left);
    display(node->right);
}

void displayPretty(Node *node, int level){
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

int height(Node *root){
    if(root == NULL) return 0;
    return root->height;
}

int balanced(Node *root){
    if(root == NULL) return 0;
    return height(root->left) - height(root->right);
}

//RightRotate
Node *rightRotate(Node *y){
    Node *x = y->left;
    Node *t = x->right;

    //Rotation
    x->right  = y;
    y->left = t;

    //After Rotation Update the Height;
    y->height = 1 + (int) fmax(height(y->left),height(y->right));
    x->height = 1 + (int) fmax(height(x->left),height(x->right));

    return x;
}

//LeftRotate
Node *leftRotate(Node *y){
    Node *x = y->right;
    Node *t = x->left;

    //Rotation
    x->left = y;
    y->right = t;

    //After Rotation Update the Height;
    y->height = 1 + (int) fmax(height(y->left),height(y->right));
    x->height = 1 + (int) fmax(height(x->left),height(x->right));

    return x;
}

Node *insert(Node *root,int x){
    if(root == NULL){
        root = createNode(x);
        return root;
    }
    if(root->val > x){
      root->left = insert(root->left,x);  
    }
    else if(root->val < x){
        root->right = insert(root->right,x);
    }

    root->height = 1 + (int) fmax(height(root->left),height(root->right));

    int balance = balanced(root);

    if(balance < -1){ // right heavy;
        
        if(x  > root->right->val){ //RR
            return leftRotate(root);
        }
        else if(x < root->right->val){ //RL  (Two - Step)
            root->right = rightRotate(root->right); // Step -1 RightRotate of root.right  
            return leftRotate(root);  // Step -2 LeftRotate of root
        }
    }
    
    if(balance > 1){ // left heavy;
        
        if(root->left->val > x){ //LL
            return rightRotate(root);
        }
        else if(root->left->val < x){ //LR  (Two - Step)
            root->left = leftRotate(root->left); //Step -1 LeftRotate of root.left
            return rightRotate(root); // Step -2 rightRotate of root
        }
    }

    return root;
}


int main(){
    
    // root = insert(root, 10);
    // root = insert(root, 20);
    // root = insert(root, 30); 
    // root = insert(root, 25);
    // root = insert(root, 28);

    int arr[] = {0,1,2,3,4,5,6,7,8};
    int n = (int) sizeof(arr) / sizeof(arr[0]);
   
    for(int i=0;i<n;i++){
        root = insert(root,arr[i]);
    }

    displayPretty(root,0);

}