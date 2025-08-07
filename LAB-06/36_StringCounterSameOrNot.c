// 36. Write a program to determine if an input character string is of the form aibi 
// where i >= 1 i.e., Number of ‘a’ should be equal to number of ‘b’. 

#include <stdio.h>
#include <string.h>

int main() {
    char str[100];
    printf("Enter the string: ");
    scanf("%s", str);

    int i = 0;
    int countA = 0, countB = 0;

    while (str[i] == 'a' || str[i] == 'A') {
        countA++;
        i++;
    }
    while (str[i] == 'b' || str[i] == 'B') {
        countB++;
        i++;
    }

    if (str[i] == '\0' && countA == countB && countA >= 1) {
        printf("Valid String\n");
    } else {
        printf("Invalid String\n");
    }

    return 0;
}
