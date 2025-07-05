class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class EleRepeatTimesLL {

    public static void countFrequencies(ListNode head) {
        ListNode outer = head;

        while (outer != null) {
            int count = 0;

            // Count frequency of this value
            ListNode inner = head;
            while (inner != null) {
                if (inner.val == outer.val) {
                    count++;
                }
                inner = inner.next;
            }

            System.out.println("Element " + outer.val + " is repeated " + count + " time(s)");

            outer = outer.next;
        }
    }

    public static void main(String[] args) {
        // Linked List: 1 -> 2 -> 3 -> 2 -> 1 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);

        countFrequencies(head);
    }
}
