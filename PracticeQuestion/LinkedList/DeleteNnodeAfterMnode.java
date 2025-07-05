public class DeleteNnodeAfterMnode {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;

        }
    }

    static Node head = null;

    public static Node createNode(int x) {
        Node newNode = new Node(x);
        return newNode;

    }

    public static void display(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int count(Node head) {
        if (head == null) {
            return -1;
        }

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static Node deleteNnodeAfterM(Node head, int n, int m) {
        Node t = head;

        if (head == null) {
            return null;
        }

        while (t != null && t.next != null) {

            for (int i = 1; i < m; i++) {
                t = t.next;
            }

            for (int i = 1; i <= n; i++) {

                if (t != null && t.next != null) {
                    t.next = t.next.next;

                }
            }

            if (t != null) {
                t = t.next;
            }

        }
        return head;

    }

    public static void main(String[] args) {

        head = createNode(9);
        head.next = createNode(1);
        head.next.next = createNode(3);
        head.next.next.next = createNode(5);
        head.next.next.next.next = createNode(9);
        head.next.next.next.next.next = createNode(4);
        head.next.next.next.next.next.next = createNode(10);
        head.next.next.next.next.next.next.next = createNode(1);

        display(head);

        display(deleteNnodeAfterM(head, 1, 2));
    }
}
