#include <stdio.h>
#include <stdlib.h>

// Structure for a node in BST
typedef struct Node {
    int val;
    struct Node * left;
    struct Node* right;
} Node;


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

Node* search(Node* root, int find) {
    if (root == NULL || root->val == find) return root;
    if (find < root->val) return search(root->left, find);
    return search(root->right, find);
}

Node *helper(Node *root){
    Node *temp = root;
    while(temp->left != NULL){
        temp = temp->left;
    }
    return temp;
}

Node* deleteNode(Node* root, int find) {
    if (root == NULL) return root;

    if (find < root->val) root->left = deleteNode(root->left, find);

    else if (find > root->val) root->right = deleteNode(root->right, find);

    else {
        // Node with only one child or no child
        /*
        jyare two child node valo delete karvo hoy to pela tree nu inorder find karvu
        pachhi je delete karvo hoy te  
        */
        if (root->left == NULL) {
            Node* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) {
            Node* temp = root->left;
            free(root);
            return temp;
        }

        // Node with two children
       Node *temp = helper(root->right);
       root->val = temp->val;
       root->right = deleteNode(root->right,temp->val);
    }

    return root;
}


void inorder(Node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->val);
        inorder(root->right);
    }
}


void preorder(Node* root) {
    if (root != NULL) {
        printf("%d ", root->val);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(Node* root) {
    if (root != NULL) {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->val);
    }
}

int main() {
    Node* root = NULL;
    int choice, x;

    do {
        printf("\n----- Binary Search Tree Menu -----\n");
        printf("1. Insert a node\n");
        printf("2. Delete a node\n");
        printf("3. Search a node\n");
        printf("4. Inorder Traversal\n");
        printf("5. Preorder Traversal\n");
        printf("6. Postorder Traversal\n");
        printf("7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                printf("Enter x to insert: ");
                scanf("%d", &x);
                root = insert(root, x);
                break;

            case 2:
                printf("Enter x to delete: ");
                scanf("%d", &x);
                root = deleteNode(root, x);
                break;

            case 3:
                printf("Enter x to search: ");
                scanf("%d", &x);
                if (search(root, x))
                    printf("Node %d found in BST.\n", x);
                else
                    printf("Node %d not found in BST.\n", x);
                break;

            case 4:
                printf("Inorder Traversal: ");
                inorder(root);
                printf("\n");
                break;

            case 5:
                printf("Preorder Traversal: ");
                preorder(root);
                printf("\n");
                break;

            case 6:
                printf("Postorder Traversal: ");
                postorder(root);
                printf("\n");
                break;

            case 7:
                printf("Exiting...\n");
                break;

            default:
                printf("Invalid choice! Try again.\n");
        }
    } while(choice != 7);

    return 0;
}
