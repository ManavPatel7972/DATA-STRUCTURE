//54. WAP to check whether the string is Palindrome or not using Pointer. 

#include <stdio.h>
#include<string.h>

int main() {
    char str[100];
    char *start, *end;
    int isPalindrome = 1;

    printf("Enter a string: ");
    scanf("%s", str); 

    start = str; 
    end = str;

    while (*(end + 1) != '\0') {
        end++;
    }

   
    while (start < end) {
        if (*start != *end) {
            isPalindrome = 0;
            break;
        }
        start++;
        end--;
    }

    if (isPalindrome) {
        printf("The string is a palindrome.\n");
    } else {
        printf("The string is not a palindrome.\n");
    }

    return 0;
}
