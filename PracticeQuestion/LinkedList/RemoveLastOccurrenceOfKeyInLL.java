package LinkedList;
// Java program to delete last occurrence 
// of key in singly linked list

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class RemoveLastOccurrenceOfKeyInLL {

    // Function to delete the last occurrence
    // of a key in the linked list
    static Node deleteLastOccurrence(Node head, int key) {
        Node temp = head;
        Node t = head;
        Node curr = head;

        if (head == null) {
            return null;
        }

        while (curr != null) {
            if (curr.data == key) {
                t = curr;
            }
            curr = curr.next;
        }

        while (temp.next != t) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    static void print(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 2 -> 4 -> 2
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(2);

        int key = 4;
        head = deleteLastOccurrence(head, key);
        print(head);
    }
}