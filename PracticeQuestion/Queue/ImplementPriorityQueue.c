#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int arrLength = 5;
int f = -1;
int r = -1;
int size = 0;

typedef struct pair{
    int val;
    int priority;
}Pair;

Pair arr[5];

void add(){

    if(r >= arrLength){
        printf("Priority Queue is OverFlow");
        return;
    }

    int v;
    int p;
    printf("Enter a Val :\n");
    scanf("%d",&v);

    printf("Enter a Priority :\n");
    scanf("%d",&p);

    if(f == -1){
        f = r = 0;
    }

    arr[r].val = v;
    arr[r].priority = p;
    r++;

    sortPriority();

}

void sortPriority(){
    
    for(int i=0;i<5;i++){
      for(int j=i+1;j<5;j++){
        if(arr[i].priority < arr[j].priority){
            //swap
            Pair temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
      }  
    }
}

Pair del(){

    if(f == -1){
        Pair temp;
        temp.val =  -1;
        temp.priority = -1;
        printf("Priority Queue is UnderFlow!!");
        return temp;
    }

    return arr[f++];
}

void display(){
    if(f == -1){
        printf("Priority Queue is Empty!!");
        return;
    }

    for(int i=f;i<=r;i++){
        printf("Val:%d -> Priority:%d \n",arr[i].val,arr[i].priority);
    }
}


int main(){

    add();
    add();
    add();
    add();
    add();
    display();
    Pair temp = del();
    printf("\n\nDeleted = val:%d -> priority:%d",temp.val,temp.priority);
    printf("\nafter delete::\n\n");
    display();

    return 0;
}
