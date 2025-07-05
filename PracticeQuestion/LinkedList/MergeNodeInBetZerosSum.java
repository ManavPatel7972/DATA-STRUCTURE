public class MergeNodeInBetZerosSum {

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

    static ListNode head = null;

    public static ListNode createNode(int x) {
        ListNode newNode = new ListNode(x);
        return newNode;

    }

    public static void display(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode mergeNodes(ListNode head) {

        if(head == null) return null;

        ListNode t = head;
        ListNode t1 = t.next;
        ListNode dummy = createNode(-1);
        ListNode p = dummy;

        while(t!=null && t1 !=null){

            int sum = 0;

            while(t1.val != 0){

                if(t.val == 0 && t1.val != 0){
                    sum += t1.val;
                }
                t1 = t1.next;
            }

            ListNode newNode = createNode(sum);
            p.next = newNode;
            p = newNode;

            t = t1;
            t1 = t.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        head = createNode(0);
        head.next = createNode(1);
        head.next.next = createNode(0);
        head.next.next.next = createNode(3);
        head.next.next.next.next = createNode(0);
        head.next.next.next.next.next = createNode(2);
        head.next.next.next.next.next.next = createNode(2);
        head.next.next.next.next.next.next.next = createNode(0);

        display(head);

        display(mergeNodes(head));
    }
}
