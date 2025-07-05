import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MergeAlterPositionLL {

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

    public static Node mergeAlterPosition(Node head1, Node head2) {

        Node t1 = head1;
        Node t2 = head2;

        if (head1 == null && head2 == null) {
            return null;
        }

        while (t1 != null && t2 != null) {

            Node p1 = t1.next;
            Node p2 = t2.next;

            t1.next = t2;
            t2.next = p1;

            t1 = p1;
            t2 = p2;
        }

        return head1;
    }

    public static void main(String[] args) {

        head = createNode(1);
        head.next = createNode(2);
        head.next.next = createNode(3);

        Node h2 = createNode(4);
        h2.next = createNode(5);
        h2.next.next = createNode(6);
        h2.next.next.next = createNode(7);
        h2.next.next.next.next = createNode(8);


        display(head);

        display(mergeAlterPosition(head, h2));

        
    }
}
