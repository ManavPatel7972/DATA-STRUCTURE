// 55. WAP to define a C structure named Student (roll_no, name, branch and
// batch_no) and also to access the structure members using Pointer.

#include <stdio.h>
#include <stdlib.h>

typedef struct Student
{
    int roll_no;
    char name[20];
    char branch[20];
    int batch_no;
} s;

int main()
{

    s s1;
    s *ptr;

    ptr = &s1;

    printf("Enter Roll No: ");
    scanf("%d", &ptr->roll_no);

    printf("Enter Name: ");
    scanf("%s", ptr->name);

    printf("Enter Branch: ");
    scanf("%s", ptr->branch);

    printf("Enter Batch No: ");
    scanf("%d", &ptr->batch_no);

    printf("\n--- Student Details ---\n");
    printf("Roll No   : %d\n", ptr->roll_no);
    printf("Name      : %s\n", ptr->name);
    printf("Branch    : %s\n", ptr->branch);
    printf("Batch No  : %d\n", ptr->batch_no);

    return 0;
}