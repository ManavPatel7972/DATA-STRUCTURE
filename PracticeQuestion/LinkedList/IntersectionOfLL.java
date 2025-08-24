package LinkedList;
public class IntersectionOfLL {
    
}
public  class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int t1Length = 0;
        int t2Length = 0;

        while(t1!=null){
            t1Length++;
            t1 = t1.next;
        }

        while(t2!=null){
            t2Length++;
            t2 = t2.next;
        }

        t1 = headA;
        t2 = headB;

        if(t1Length>t2Length){
            int step = t1Length -t2Length;

            for(int i=1;i<=step;i++){
                t1 = t1.next;
            }
        }

        else{
            int step = t2Length -t1Length;

            for(int i=1;i<=step;i++){
                t2 = t2.next;
            }
        }

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;

    }
}