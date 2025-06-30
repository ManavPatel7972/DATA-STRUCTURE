#include<stdio.h>
int main(){
    char ch;
    printf("Enter a Character : ");
    scanf("%c",&ch);
    int ascii = ch;
    
    if(ascii>=65 && ascii<=122){
        printf("Enter character %c is vowel",ch);
    }
    // if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
    //     printf("Enter character %c is vowel",ch);

    // }
    else{
        printf("Enter character %c is Not Vowel",ch);
    }
    return 0;

}