// 21. Read n numbers in an array then read two different numbers, replace 1st 
// number with 2nd number in an array and print its index and final array.

#include <stdio.h>

int main() {
    int n;
    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i < n; i++) {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    int oldNum, newNum;
    printf("Enter old number: ");
    scanf("%d", &oldNum);
    printf("Enter new number: ");
    scanf("%d", &newNum);

    int found = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] == oldNum) {
            arr[i] = newNum;
            printf(" index = %d\n ", i);
            found = 1;
        }
    }

    if (!found) {
        printf("None");
    }

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
