
public class ConvertSinglyLLToCircularLL {

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

    public static void displayCLL(Node head) {
        Node temp = head;

        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static Node singlyTocircular(Node head) {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        return head;
    }

    // public static void push(int val) {

    //     Node newNode = new Node(val);
    //     newNode.next = head;
    //     head = newNode;
    // }

    public static void main(String[] args) {

        head = createNode(10);
        head.next = createNode(20);
        head.next.next = createNode(30);
        head.next.next.next = createNode(40);
        head.next.next.next.next = createNode(50);
        head.next.next.next.next.next = createNode(60);
       

        // push(10);
        // push(20);
        // push(30);
        // push(40);
        // push(50);
        // push(60);

        display(head);

        head = singlyTocircular(head);

        displayCLL(head);

    }

}