package LinkedList;
public class RemoveDupliInSortedLL {

}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = head;

        if (t == null) {
            return null;
        }

        while (t != null && t.next != null) {
            if (t.val == t.next.val) {
                t.next = t.next.next;
            }
            if (t.next != null) {
                if (t.next.val != t.val) {
                    t = t.next;
                }
            }

        }
        return head;

    }
}
