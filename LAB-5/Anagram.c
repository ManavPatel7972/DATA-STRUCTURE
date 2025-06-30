// Design anagram game using array.
// • Allow a user to enter N words and store it in an array.
// • Generate a random number between 0 to N-1.
// • Based on the random number generated display the word stored at that index of an array and allow user to enter its anagram.
// • Check whether the word entered by the user is an anagram of displayed number or not and display an appropriate message.
// • Given a word A and word B. B is said to be an anagram of A if and only if the characters present in B is same as characters present in A, irrespective of their sequence. For ex: “LISTEN” == “SILENT”

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
void main() {
  int n,random,i,j;
  char anagram[10], names[50][10];
  printf("Enter the number of names:");
  scanf("%d",&n);
  printf("Enter the names:");
  for(i=0;i<n;i++) {
    scanf("%s",names[i]);
  }
  random = rand() % n;
  printf("Random word=%s\n",names[random]);
  printf("Enter the anagram:");
  scanf("%s",anagram);

  if(strlen(anagram)==strlen(names[random])){
    for(i=0;i<strlen(names[random]);i++){
      for(j=0;j<strlen(anagram);j++){
        if(names[random][i]==anagram[j]){
          anagram[j]='1';
          break;
        }
      }
    }
  }
  else{
    printf("anagram is not true");
  }

  printf("anagram if all is 1 true : %s",anagram);
}