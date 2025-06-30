#include<stdio.h>
#define PI 3.14
int main(){
    float r;
    float ans;
    printf("Enter a Radius:");
    scanf("%f",&r);
    ans = PI*r*r;
    printf("Area of Circle = %f\n",ans);

    return 0;
}