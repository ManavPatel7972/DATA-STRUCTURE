
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node
{
    char song[20];
    struct node *lptr;
    struct node *rptr;

} Node;

Node *first = NULL;
Node *last = NULL;
Node *nextSong = NULL;
Node *currSong = NULL;
int size = 0;

Node *createNode()
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    printf("Enter A Song: ");
    scanf(" %[^\n]", newNode->song);
    newNode->lptr = NULL;
    newNode->rptr = NULL;
    return newNode;
}

// void createList()
// {
//     Node *newNode = createNode();

//     if (first == NULL)
//     {
//         first = last = newNode;
//         first->rptr = first;
//         first->lptr = first;
//     }
//     else
//     {
//         last->rptr = newNode;
//         newNode->lptr = last;
//         newNode->rptr = first;
//         first->lptr = newNode;
//         last = newNode;
//     }

//     size++;
// }

void display(Node *first)
{
    if (first == NULL)
    {
        printf("\nList Is Empty...\n");
        return;
    }

    Node *temp = first;

    printf("\nPlayList:\n");
    do
    {
        printf("%s ,", temp->song);
        temp = temp->rptr;
    } while (temp != first);
    printf("\n\n");
}

void addSongAtFirst()
{
    Node *newNode = createNode();

    if (first == NULL)
    {
        first = last = newNode;
        first->rptr = first;
        first->lptr = first;
    }
    else
    {
        newNode->rptr = first;
        newNode->lptr = last;
        first->lptr = newNode;
        last->rptr = newNode;
        first = newNode;
    }
    size++;
}

void addSongAtLast()
{
    Node *newNode = createNode();

    if (first == NULL)
    {
        first = last = newNode;
        first->rptr = first;
        first->lptr = first;
    }
    else
    {
        last->rptr = newNode;
        newNode->lptr = last;
        newNode->rptr = first;
        first->lptr = newNode;
        last = newNode;
    }
    size++;
}

void deleteSongAtIndex()
{
    int idx;
    printf("Enter index to delete Song:");
    scanf("%d", &idx);

    if (first == NULL)
    {
        printf("Playlist is empty.\n");
        return;
    }

    if (idx < 0 || idx >= size)
    {
        printf("Invalid index!\n");
        return;
    }

    Node *temp = first;

    if (size == 1)
    {
        free(first);
        first = last = NULL;
        size--;
        return;
    }

    if (idx == 0)
    {
        first = first->rptr;
        first->lptr = last;
        last->rptr = first;
        free(temp);
        size--;
        return;
    }

    for (int i = 1; i < idx; i++)
    {
        temp = temp->rptr;
    }

    temp->rptr = temp->rptr->rptr;
    temp = temp->rptr;

    temp->lptr = temp->lptr->lptr;

    if (temp == last)  last = temp->lptr;
    free(temp);
    size--;
}

void nextSongPlaying()
{
    if (first == NULL)
    {
        printf("Play List is Empty..\n");
        return;
    }

    if (nextSong == NULL)
    {
        nextSong = first;
    }
    else
    {
        nextSong = nextSong->rptr;
    }

    currSong = nextSong;
    printf("Playing Next Song: %s\n", nextSong->song);
}

void prevSongPlaying()
{
    if (first == NULL)
    {
        printf("Play List is Empty..\n");
        return;
    }

    if (nextSong == NULL)
    {
        printf("No song is currently selected.\n");
        return;
    }

    nextSong = nextSong->lptr;
    
    currSong = nextSong;
    printf("Playing Previous Song: %s\n", nextSong->song);
}

void currPlayingSong(){

    if(currSong == NULL){
        printf("\nCurrently No Song Playing..\n");
        return;
    }
    printf("\nCurrently Playing Song: %s\n", currSong->song);
}

int main()
{
    int choice;
    int temp  = 1;

    while (temp)
    {
        printf("\n--Music Playlist Menu--\n");
        printf("1. Add Song at First\n");
        printf("2. Add Song at Last\n");
        printf("3. Delete Song at Index\n");
        printf("4. Display Playlist\n");
        printf("5. Play Next Song\n");
        printf("6. Play Previous Song\n");
        printf("7.Play Current Song\n");
        printf("0. Exit\n");

        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            addSongAtFirst();
            break;

        case 2:
            addSongAtLast();
            break;

        case 3:
            deleteSongAtIndex();
            break;

        case 4:
            display(first);
            break;

        case 5:
            nextSongPlaying();
            break;

        case 6:
            prevSongPlaying();
            break;
        case 7:
            currPlayingSong();
            break;

        case 0:
            printf("Exiting...\n");
            temp = 0;
            break;

        default:
            printf("Invalid choice! Try again.\n");
        }
    }

    return 0;
}
