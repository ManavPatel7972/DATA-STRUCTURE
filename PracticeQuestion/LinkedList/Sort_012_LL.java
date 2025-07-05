public class Sort_012_LL {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int data1) {
            val = data1;
            next = null;
        }

        ListNode(int data1, ListNode next1) {
            val = data1;
            next = next1;
        }
    }

    static ListNode head = null;

    public static ListNode createNode(int x) {
        ListNode newNode = new ListNode(x);
        return newNode;
    }

    public static ListNode sortList(ListNode head) {

        int c0 = 0, c1 = 0, c2= 0;

        ListNode temp = head;

        while (temp != null) {

            if (temp.val == 0) {
                c0++;

            } else if (temp.val == 1) {
                c1++;

            } else {
                c2++;
            }
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {

            if (c0 != 0) {
                temp.val = 0;
                c0--;
            } else if (c1 != 0) {
                temp.val = 1;
                c1--;
            } else {
                temp.val = 2;
                c2--;
            }

            temp = temp.next;
        }
        return head;
    }

    public static void display(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        head = createNode(0);
        head.next = createNode(2);
        head.next.next = createNode(1);
        head.next.next.next = createNode(0);
        head.next.next.next.next = createNode(1);

        display(head);

        sortList(head);

        display(head);



    }
}
