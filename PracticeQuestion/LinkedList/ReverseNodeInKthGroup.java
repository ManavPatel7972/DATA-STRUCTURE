import java.util.concurrent.locks.LockSupport;

public class ReverseNodeInKthGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void display(ListNode head) {

        ListNode temp = head;

        if (head == null)
            return;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode t1 = head;
        ListNode t2 = head;
    }

    public static void main(String[] args) {

    }
}
