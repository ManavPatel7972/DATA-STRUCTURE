package LinkedList;
import java.util.List;

public class Cycle2InLL {
    
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;

        while(fast!=null){
    
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle){
            return null;
        }

        ListNode temp = head;

        while(temp != slow){
            slow = slow.next;
            temp = temp.next;
        }
        return slow;
    }
}