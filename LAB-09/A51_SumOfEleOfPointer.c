
//51. WAP to calculate the sum of n numbers using Pointer.

#include <stdio.h>

int main() {
    int n;
    
    printf("Enter size of the array: ");
    scanf("%d", &n);

    int arr[n];
    int sum = 0;
    int *ptr = arr; 
    
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", (ptr + i));
        sum = sum + *(ptr+i);
    }

    printf("Array elements are:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", *(ptr + i));
    }

    printf("\n Sum Of Number = %d",sum);

    return 0;
}
