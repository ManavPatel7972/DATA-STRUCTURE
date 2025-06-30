// Write a program to find position of the smallest number & the largest number 
// from given n numbers.

#include <stdio.h>

int main() {
    int n;
    printf("Enter size: ");
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i < n; i++) {
        printf("Enter number %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    int min = arr[0], max = arr[0];
    int minIdx = 0, maxIdx = 0;

    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
            maxIdx = i;
        }
        if (arr[i] < min) {
            min = arr[i];
            minIdx = i;
        }
    }

    printf("Largest number is %d at index %d\n", max, maxIdx);
    printf("Smallest number is %d at index %d\n", min, minIdx);

    return 0;
}
