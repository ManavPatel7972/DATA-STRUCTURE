import java.util.ArrayList;
import java.util.List;

public class ReverseLLToLeftRightAndSwapValue {
    
}

// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// LeetCode - 92



class Solution {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        int pos = 1;

        
        while (current != null) {
            if (pos >= left && pos <= right) {
                values.add(current.val);
            }
            current = current.next;
            pos++;
        }

        
        current = head;
        pos = 1;
        
        int idx = values.size() - 1;
        while (current != null) {
            if (pos >= left && pos <= right) {
                current.val = values.get(idx--);
            }
            current = current.next;
            pos++;
        }

        return head;
    }
}