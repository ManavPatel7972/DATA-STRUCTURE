package LinkedList;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;

        while(temp!=null){
            size++;
            temp = temp.next;
        }

        int nth = size - n + 1;

        temp = head;

        for(int i=1;i<nth - 1;i++){
            temp = temp.next;
        }
        temp.next  = temp.next.next;
        return head;
    }
}