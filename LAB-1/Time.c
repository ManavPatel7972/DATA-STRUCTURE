#include <stdio.h>
int main()
{

    int sec;
    printf("Enter a Second:");
    scanf("%d",&sec);

    
    int h;
    int m;

    h = (sec / 3600);
    sec = (sec % 3600);
    
    m = (sec / 60);
    sec = (sec % 60);

       
    printf("Time is %2d:%2d:%2d", h, m,sec);

    return 0;
}