// 49. WAP to allocate and de-allocate memory for int, char and float variable at
// runtime.
#include <stdio.h>
#include <stdlib.h>

int main()
{

    int *intPtr;
    char *charPtr;
    float *floatPtr;

    intPtr = (int *)malloc(sizeof(int));
    charPtr = (char *)malloc(sizeof(char));
    floatPtr = (float *)malloc(sizeof(float));

    if (intPtr == NULL || charPtr == NULL || floatPtr == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    *intPtr = 25;
    *charPtr = 'A';
    *floatPtr = 3.14f;

    printf("intPtr = %d\n", *intPtr);
    printf("charPtr = %c\n", *charPtr);
    printf("floatPtr = %f\n", *floatPtr);

    return 0;
}
