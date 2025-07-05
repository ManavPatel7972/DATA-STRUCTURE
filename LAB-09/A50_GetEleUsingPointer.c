//50. WAP to get and print the array elements using Pointer.

#include <stdio.h>

int main() {
    int n;
    
    printf("Enter size of the array: ");
    scanf("%d", &n);

    int arr[n];
    int *ptr = arr; 
    
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", (ptr + i));
    }

    printf("Array elements are:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", *(ptr + i));
    }

    return 0;
}
