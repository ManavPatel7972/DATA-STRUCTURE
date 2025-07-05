

struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *createNode(int x)
{
    struct ListNode *newNode = (struct ListNode *)malloc(sizeof(struct ListNode));
    newNode->val = x;
    newNode->next = NULL;
    return newNode;
}

struct ListNode *mergeTwoLists(struct ListNode *list1, struct ListNode *list2)
{

    struct ListNode *t1 = list1;
    struct ListNode *t2 = list2;

    struct ListNode *head = NULL;

    if (t1 == NULL)
    {
        return list2;
    }

    if (t2 == NULL)
    {
        return list1;
    }

    if (t1->val < t2->val)
    {
        struct ListNode *newHead = createNode(t1->val);
        head = newHead;
        t1 = t1->next;
    }
    else
    {
        struct ListNode *newHead = createNode(t2->val);
        head = newHead;
        t2 = t2->next;
    }

    struct ListNode *temp = head;

    while (t1 != NULL && t2 != NULL)
    {

        if (t1->val < t2->val)
        {
            temp->next = createNode(t1->val);
            t1 = t1->next;

        }
        else
        {
            temp->next = createNode(t2->val);
            t2 = t2->next;
        }
        temp = temp->next;
    }

    if(t1!=NULL){
        temp->next = t1;
    }
    else{
        temp->next = t2;
    }

    return head;

}