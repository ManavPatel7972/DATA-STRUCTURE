#include <stdio.h>
int main()
{
    
    int day;
    printf("Enter a Day:");
    scanf("%d",&day);

    int ori = day;

    int y;
    int m;

    y = (day / 365);
    day = (day % 365);
    
    m = (day / 7);
    day = (day % 7);

       
    printf("%d means %d year %d week and %d days",ori, y, m,day);

    return 0;
}