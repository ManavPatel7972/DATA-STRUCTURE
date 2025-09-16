// 81. Write a program to implement phone book dictionary using Binary Search Tree 
// which provides following operations: 
// • Add new entry in phone book,  
// • Remove entry from phone book,  
// • Search phone number  
// • List all entries in ascending order of name and 
// • List all entries in descending order of name 


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure for phone book entry (BST Node)
typedef struct Node {
    char name[50];
    char phone[20];
    struct Node* left;
    struct Node* right;
} Node;

// Function to create a new entry
Node* createNode(char name[], char phone[]) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    strcpy(newNode->name, name);
    strcpy(newNode->phone, phone);
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Insert new entry in phone book (BST by name)
Node* insert(Node* root, char name[], char phone[]) {
    if (root == NULL) return createNode(name, phone);

    if (strcmp(name, root->name) < 0)
        root->left = insert(root->left, name, phone);
    else if (strcmp(name, root->name) > 0)
        root->right = insert(root->right, name, phone);
    else
        printf("Entry with name '%s' already exists!\n", name);

    return root;
}

// Search phone number by name
Node* search(Node* root, char name[]) {
    if (root == NULL || strcmp(root->name, name) == 0)
        return root;
    if (strcmp(name, root->name) < 0)
        return search(root->left, name);
    return search(root->right, name);
}

// Helper to find smallest node (used in delete)
Node* minValueNode(Node* node) {
    Node* current = node;
    while (current && current->left != NULL)
        current = current->left;
    return current;
}

// Remove entry from phone book
Node* deleteNode(Node* root, char name[]) {
    if (root == NULL) return root;

    if (strcmp(name, root->name) < 0)
        root->left = deleteNode(root->left, name);
    else if (strcmp(name, root->name) > 0)
        root->right = deleteNode(root->right, name);
    else {
        // Node with one child or no child
        if (root->left == NULL) {
            Node* temp = root->right;
            free(root);
            return temp;
        } else if (root->right == NULL) {
            Node* temp = root->left;
            free(root);
            return temp;
        }

        // Node with two children - get inorder successor
        Node* temp = minValueNode(root->right);
        strcpy(root->name, temp->name);
        strcpy(root->phone, temp->phone);
        root->right = deleteNode(root->right, temp->name);
    }
    return root;
}

// List all entries in ascending order of name (Inorder Traversal)
void listAscending(Node* root) {
    if (root != NULL) {
        listAscending(root->left);
        printf("Name: %-10s | Phone: %s\n", root->name, root->phone);
        listAscending(root->right);
    }
}

// List all entries in descending order of name (Reverse Inorder Traversal)
void listDescending(Node* root) {
    if (root != NULL) {
        listDescending(root->right);
        printf("Name: %-10s | Phone: %s\n", root->name, root->phone);
        listDescending(root->left);
    }
}

// Menu-driven program
int main() {
    Node* root = NULL;
    int choice;
    char name[50], phone[20];

    do {
        printf("\n--- Phone Book Menu ---\n");
        printf("1. Add new entry\n");
        printf("2. Remove entry\n");
        printf("3. Search phone number\n");
        printf("4. List all entries (Ascending)\n");
        printf("5. List all entries (Descending)\n");
        printf("6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        getchar(); // consume newline

        switch(choice) {
            case 1:
                printf("Enter name: ");
                gets(name);
                printf("Enter phone: ");
                gets(phone);
                root = insert(root, name, phone);
                break;

            case 2:
                printf("Enter name to remove: ");
                gets(name);
                root = deleteNode(root, name);
                break;

            case 3:
                printf("Enter name to search: ");
                gets(name);
                Node* res;
                res = search(root, name);
                if (res != NULL)
                    printf("Phone number of %s is %s\n", res->name, res->phone);
                else
                    printf("Entry not found!\n");
                break;

            case 4:
                printf("\nPhone Book (Ascending Order):\n");
                listAscending(root);
                break;

            case 5:
                printf("\nPhone Book (Descending Order):\n");
                listDescending(root);
                break;

            case 6:
                printf("Exiting Phone Book...\n");
                break;

            default:
                printf("Invalid choice! Try again.\n");
        }
    } while(choice != 6);

    return 0;
}
